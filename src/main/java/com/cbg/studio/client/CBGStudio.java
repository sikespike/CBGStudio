package com.cbg.studio.client;

import com.cbg.studio.client.controller.AppController;
import com.cbg.studio.client.controller.util.AppUtil;
import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CBGStudio implements EntryPoint {
    /**
     * This is the entry point method.
     */
    @Override
    public void onModuleLoad() {
        AppController controller = AppUtil.getController();

        controller.initialize();
    }
}
