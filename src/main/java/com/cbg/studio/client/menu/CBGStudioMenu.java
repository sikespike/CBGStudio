/**
 * 
 */
package com.cbg.studio.client.menu;

import com.cbg.studio.client.menu.command.OpenFileCommand;
import com.cbg.studio.client.menu.command.SaveFileCommand;
import com.cbg.studio.client.widget.screen.util.UiCallbackHandler;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;

/**
 * @author Siebe
 *
 */
public class CBGStudioMenu extends MenuBar {
    public CBGStudioMenu(UiCallbackHandler handler){
        super();
        
        MenuBar fileMenu = new MenuBar(true);
        MenuItem openFile = new MenuItem("Open File...",new OpenFileCommand(handler));
        MenuItem saveFile = new MenuItem("Save",new SaveFileCommand(handler));
        
        fileMenu.addItem(openFile);
        fileMenu.addItem(saveFile);
        
        this.addItem("File",fileMenu);
    }
}
