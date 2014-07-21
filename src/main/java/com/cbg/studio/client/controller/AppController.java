/**
 * 
 */
package com.cbg.studio.client.controller;

import com.cbg.studio.client.data.CATModelDto;
import com.cbg.studio.client.menu.CBGStudioMenu;
import com.cbg.studio.client.widget.dialog.OpenFileDialog;
import com.cbg.studio.client.widget.screen.util.UiActionEvent;
import com.cbg.studio.client.widget.screen.util.UiCallbackHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author Siebe
 * 
 */
public class AppController implements UiCallbackHandler{
    private CBGStudioMenu menu;
    private CATModelDto model;
    
    private FlexTable content;
    
    
    
    public void initialize() {
        this.menu = new CBGStudioMenu(this);

        
        
        RootPanel.get("menu").add(this.menu);
        RootPanel.get("contentWrapper").add(this.content);
    }

    @Override
    public void onUiAction(UiActionEvent action) {
        if(action.getSource() instanceof OpenFileDialog){
            OpenFileDialog d = (OpenFileDialog)action.getSource();
            model = d.getModel();
        }
    }
}
