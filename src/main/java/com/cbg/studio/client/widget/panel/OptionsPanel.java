package com.cbg.studio.client.widget.panel;

import com.cbg.studio.client.widget.screen.util.UiAction;
import com.cbg.studio.client.widget.screen.util.UiActionEvent;
import com.cbg.studio.client.widget.screen.util.UiCallbackHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;

public class OptionsPanel extends FlexTable implements UiEventPanel,
        ClickHandler {
    private Button renderScene;

    private UiCallbackHandler uiHandler;

    public OptionsPanel(UiCallbackHandler uiHandler) {
        this.uiHandler = uiHandler;

        this.renderScene = new Button(
                "<i class=\"fa fa-video-camera fa-3x\"></i>", this);
        this.renderScene.setStyleName("options-button");

        this.setWidth("50px");

        this.setCellPadding(0);
        this.setCellSpacing(0);
        this.setWidget(0, 0, this.renderScene);
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
