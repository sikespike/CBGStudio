package com.cbg.studio.client.widget.panel;

import com.cbg.studio.client.widget.screen.util.UiAction;
import com.cbg.studio.client.widget.screen.util.UiActionEvent;
import com.cbg.studio.client.widget.screen.util.UiCallbackHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;

public class OptionsPanel extends FlexTable implements UiEventPanel,ClickHandler {
    private Button renderScene;

    private UiCallbackHandler uiHandler;
    
    public OptionsPanel(UiCallbackHandler uiHandler) {
        this.renderScene = new Button("Render Scene", this);
        
        this.setWidth("50px");
        this.setHeight("100%");
        
        this.add(this.renderScene);
    }

    @Override
    public void onClick(ClickEvent e) {
        if (e.getSource() == this.renderScene) {
            uiHandler.onUiAction(new UiActionEvent(UiAction.RENDER));
        }

    }

    @Override
    public void setUiHandler(UiCallbackHandler uiHandler) {
        this.uiHandler = uiHandler;
    }

}
