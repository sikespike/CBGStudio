package com.cbg.studio.client;

import com.cbg.studio.client.menu.CBGStudioMenu;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CBGStudio implements EntryPoint {
    private CBGStudioMenu menu;
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        this.menu = new CBGStudioMenu();
        
        RootPanel.get("menu").add(this.menu);
    }
}
