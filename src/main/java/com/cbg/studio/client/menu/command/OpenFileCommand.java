/**
 * 
 */
package com.cbg.studio.client.menu.command;

import com.cbg.studio.client.widget.dialog.OpenFileDialog;
import com.cbg.studio.client.widget.screen.util.UiCallbackHandler;

/**
 * @author Siebe
 * 
 */
public class OpenFileCommand extends UiCommand {

    public OpenFileCommand() {
        super();
    }

    public OpenFileCommand(UiCallbackHandler uiHandler) {
        super(uiHandler);
    }

    @Override
    public void execute() {
        OpenFileDialog d = new OpenFileDialog("Open File...", false, true);
        d.setUiHandler(this.uiHandler);
        d.center();
        d.show();
    }
}
