/**
 * 
 */
package com.cbg.studio.client.menu.command;

import com.cbg.studio.client.widget.dialog.OpenFileDialog;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;

/**
 * @author Siebe
 *
 */
public class OpenFileCommand implements ScheduledCommand {
    /* (non-Javadoc)
     * @see com.google.gwt.core.client.Scheduler.ScheduledCommand#execute()
     */
    public void execute() {
        OpenFileDialog d = new OpenFileDialog("Open File...",false,true);
        d.center();
        d.show();
    }
}
