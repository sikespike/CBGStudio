/**
 * 
 */
package com.cbg.studio.client.controller.util;

import com.cbg.studio.client.controller.AppController;
import com.google.gwt.core.shared.GWT;

/**
 * @author Siebe
 *
 */
public class AppUtil {
    private static AppController controller;
    
    public static AppController getController(){
        if(controller == null){
            controller = GWT.create(AppController.class);
        }
        
        return controller;
    }
}
