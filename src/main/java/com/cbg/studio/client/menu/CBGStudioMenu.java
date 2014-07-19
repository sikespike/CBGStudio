/**
 * 
 */
package com.cbg.studio.client.menu;

import com.cbg.studio.client.menu.command.OpenFileCommand;
import com.cbg.studio.client.menu.command.SaveFileCommand;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;

/**
 * @author Siebe
 *
 */
public class CBGStudioMenu extends MenuBar {
    public CBGStudioMenu(){
        super();
        
        MenuBar fileMenu = new MenuBar(true);
        MenuItem openFile = new MenuItem("Open File...",new OpenFileCommand());
        MenuItem saveFile = new MenuItem("Save",new SaveFileCommand());
        
        fileMenu.addItem(openFile);
        fileMenu.addItem(saveFile);
        
        this.addItem("File",fileMenu);
    }
}
