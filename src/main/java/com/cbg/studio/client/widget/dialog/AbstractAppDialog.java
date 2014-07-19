/**
 * 
 */
package com.cbg.studio.client.widget.dialog;

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
public abstract class AbstractAppDialog extends DialogBox implements ClickHandler{
    private int buttonCols = 0;
    
    protected FlexTable body;
    protected FlexTable buttons;
    
    protected Button okButton;
    protected Button cancelButton;
    
    protected UiCallbackHandler uiHandler;
    /**
     * 
     */
    public AbstractAppDialog() {
        super(true,true);
        init();
    }

    /**
     * @param autoHide
     */
    public AbstractAppDialog(boolean autoHide) {
        super(autoHide);
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
        init();
    }

    private void init() {
        this.body = new FlexTable();
        this.addBody();
        
        this.buttons = new FlexTable();

        super.add(this.body);
        super.add(this.buttons);

        this.buttons.getElement().addClassName("display-none");
        
        this.addStyles();
        
        this.okButton = new Button("Ok", this);
    }
    
    protected void addStyles(){
        this.addStyleName("styled-panel-wrapper");
        this.body.addStyleName("styled-panel-body width100");
        this.buttons.addStyleName("styled-panel-buttons width100");
    }
    
    @Override
    public void setWidth(String width){
        String innerWidthString = width.replaceAll("px", "");
        int innerWidth = Integer.parseInt(innerWidthString);
        innerWidth += 10;
        
        super.setWidth(width);
        this.body.setWidth(innerWidth+"px");
    }
    
    public void addButton(Widget button){
        this.buttons.setWidget(0, this.buttonCols, button);
        this.buttonCols++;
        this.buttons.getElement().replaceClassName("display-none", "display-show");
    }
    
    protected abstract void addBody();
    
    protected abstract void onOk();
    protected abstract void onCancel();
    
    public void onClick(ClickEvent e){
        if(e.getSource() == okButton){
            onOk();
            this.hide(true);
        } else if(e.getSource() == cancelButton){
            onCancel();
            this.hide(true);
        }
    }

    public UiCallbackHandler getUiHandler() {
        return uiHandler;
    }

    public void setUiHandler(UiCallbackHandler uiHandler) {
        this.uiHandler = uiHandler;
    }

}
