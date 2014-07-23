/**
 * 
 */
package com.cbg.studio.client.widget.panel;

import com.cbg.studio.client.widget.dialog.AbstractAppDialog;
import com.cbg.studio.client.widget.screen.util.UiAction;
import com.cbg.studio.client.widget.screen.util.UiActionEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * @author vladimir.kavoun
 * @since 0.1
 */
public abstract class AbstractStyledPanel extends AbstractAppDialog implements
        UiCollapsibleEventPanel, ClickHandler {

    private Button collapse;
    private Button close;
    
    public AbstractStyledPanel() {
        super();
    }

    @Override
    public void onClick(ClickEvent e){
        if(e.getSource() == collapse){
            this.uiHandler.onUiAction(new UiActionEvent(this, UiAction.COLLAPSE));
        } else if(e.getSource() == close){
            this.uiHandler.onUiAction(new UiActionEvent(this, UiAction.CLOSE));
            this.hide(true);
        }
    }
    
    @Override
    protected void onOk() {

    }

    @Override
    protected void onCancel() {

    }
    
    @Override
    public void openPanel(){
        this.show();
    }
}
