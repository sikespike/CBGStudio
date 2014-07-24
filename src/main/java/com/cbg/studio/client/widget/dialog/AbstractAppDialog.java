/**
 * 
 */
package com.cbg.studio.client.widget.dialog;

import com.cbg.studio.client.widget.panel.UiEventPanel;
import com.cbg.studio.client.widget.screen.util.UiCallbackHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author vladimir.kavoun
 * 
 */
public abstract class AbstractAppDialog extends DialogBox implements
        UiEventPanel, ClickHandler {
    private int buttonCols = 0;

    private FlexTable wrapper;
    protected FlexTable body;
    protected FlexTable buttons;

    protected Button okButton;
    protected Button cancelButton;

    protected boolean autoHide = false;

    protected UiCallbackHandler uiHandler;

    /**
     * 
     */
    public AbstractAppDialog() {
        super(false, true);
        init();
    }

    /**
     * @param autoHide
     */
    public AbstractAppDialog(boolean autoHide) {
        super(autoHide);
        this.autoHide = autoHide;
        init();
    }

    /**
     * @param captionWidget
     */
    public AbstractAppDialog(Caption captionWidget) {
        super(captionWidget);
        init();
    }

    /**
     * @param autoHide
     * @param modal
     */
    public AbstractAppDialog(boolean autoHide, boolean modal) {
        super(autoHide, modal);
        this.autoHide = autoHide;
        init();
    }

    /**
     * @param autoHide
     * @param modal
     * @param captionWidget
     */
    public AbstractAppDialog(boolean autoHide, boolean modal,
            Caption captionWidget) {
        super(autoHide, modal, captionWidget);
        this.autoHide = autoHide;
        init();
    }

    private void init() {
        this.wrapper = new FlexTable();
        this.body = new FlexTable();
        this.addBody();

        this.buttons = new FlexTable();

        wrapper.setWidget(0, 0, this.body);
        wrapper.setWidget(1, 0, this.buttons);

        super.add(wrapper);

        this.buttons.getElement().addClassName("display-none");

        this.addStyles();

        this.okButton = new Button("OK", this);
        this.cancelButton = new Button("Cancel", this);

        this.addButton(this.okButton);
        this.addButton(this.cancelButton);
    }

    protected void addStyles() {
        this.addStyleName("styled-panel-wrapper");
        this.body.addStyleName("styled-panel-body width100");
        this.buttons.addStyleName("styled-panel-buttons");
    }

    @Override
    public void setWidth(String width) {
        String innerWidthString = width.replaceAll("px", "");
        int innerWidth = Integer.parseInt(innerWidthString);
        innerWidth += 10;

        super.setWidth(width);
        this.body.setWidth(innerWidth + "px");
    }

    public void addButton(Widget button) {
        this.buttons.setWidget(0, this.buttonCols, button);
        this.buttonCols++;
        this.buttons.getElement().replaceClassName("display-none",
                "display-show");
    }

    protected abstract void addBody();

    protected abstract void onOk();

    protected abstract void onCancel();

    @Override
    public void onClick(ClickEvent e) {
        if (e.getSource() == okButton) {
            onOk();
            if (this.autoHide) {
                this.hide(true);
            }
        } else if (e.getSource() == cancelButton) {
            onCancel();
            this.hide(true);
        }
    }

    @Override
    public void setUiHandler(UiCallbackHandler uiHandler) {
        this.uiHandler = uiHandler;
    }

}
