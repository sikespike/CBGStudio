/**
 * 
 */
package com.cbg.studio.client.widget.panel;

import java.util.LinkedHashMap;

import com.cbg.studio.client.widget.screen.util.UiCallbackHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Xif
 * 
 */
public class CollapsedOptionsPanel extends FlexTable {
    private UiCallbackHandler uiHandler;

    private LinkedHashMap<Widget,UiCollapsibleEventPanel> collapsedPanels;

    public CollapsedOptionsPanel(UiCallbackHandler uiHandler) {
        this.uiHandler = uiHandler;

        collapsedPanels = new LinkedHashMap<Widget,UiCollapsibleEventPanel>();

        this.setHeight("50px");
        this.setWidth("100%");
    }

    public void addCollapsedPanel(UiCollapsibleEventPanel panel) {
        Widget w = createBarWidget();
        collapsedPanels.put(w,panel);
        this.setWidget(0, collapsedPanels.keySet().size(), w);
    }

    private Widget createBarWidget(){
        Button w = new Button(" ", new ClickHandler(){
            @Override
            public void onClick(ClickEvent e){
                collapsedPanels.get(e.getSource()).openPanel();
            }
        });
        w.setStyleName("collapsed-widget");
        return w;
    }

}
