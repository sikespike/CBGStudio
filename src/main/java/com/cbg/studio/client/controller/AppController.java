/**
 * 
 */
package com.cbg.studio.client.controller;

import com.cbg.studio.client.engine.CBGwtEngine;
import com.cbg.studio.client.menu.CBGStudioMenu;
import com.cbg.studio.client.widget.dialog.OpenFileDialog;
import com.cbg.studio.client.widget.panel.CollapsedOptionsPanel;
import com.cbg.studio.client.widget.panel.OptionsPanel;
import com.cbg.studio.client.widget.screen.util.UiAction;
import com.cbg.studio.client.widget.screen.util.UiActionEvent;
import com.cbg.studio.client.widget.screen.util.UiCallbackHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author Siebe
 * 
 */
public class AppController implements UiCallbackHandler {
    private CBGStudioMenu menu;

    private FlexTable content;
    private CBGwtEngine engine;
    private OptionsPanel optionsPanel;
    private CollapsedOptionsPanel collapsedPanel;

    public void initialize() {
        this.menu = new CBGStudioMenu(this);

        content = new FlexTable();

        content.setWidth("100%");
        content.setHeight("100%");

        engine = new CBGwtEngine();
        this.content.setWidget(0, 0, this.engine);

        optionsPanel = new OptionsPanel(this);
        optionsPanel.setWidth("50px");
        optionsPanel.setHeight("100%");

        this.content.setWidget(0, 1, this.optionsPanel);

        this.collapsedPanel = new CollapsedOptionsPanel(this);

        this.content.setWidget(1, 0, this.collapsedPanel);

        this.collapsedPanel.getElement().getParentElement()
                .setAttribute("colspan", "2");
        
        RootPanel.get("menu").add(this.menu);
        RootPanel.get("contentWrapper").add(this.content);
    }

    @Override
    public void onUiAction(UiActionEvent action) {
        if (action.getAction().equals(UiAction.LOAD)) {
            if (action.getSource() instanceof OpenFileDialog) {
                OpenFileDialog d = (OpenFileDialog) action.getSource();
                this.engine.setModel(d.getModel());
            }
        } else if (action.getAction().equals(UiAction.RENDER)) {
            this.engine.drawScene();
        }

    }
}
