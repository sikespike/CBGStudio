/**
 * 
 */
package com.cbg.studio.client.menu.command;

import com.cbg.studio.client.widget.screen.util.UiCallbackHandler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;

/**
 * @author Siebe
 * 
 */
public abstract class UiCommand implements ScheduledCommand {

    protected UiCallbackHandler uiHandler;

    public UiCommand() {
        super();
    }

    public UiCommand(UiCallbackHandler uiHandler) {
        this.uiHandler = uiHandler;
    }
}
