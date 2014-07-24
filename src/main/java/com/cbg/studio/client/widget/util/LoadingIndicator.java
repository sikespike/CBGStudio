/**
 * 
 */
package com.cbg.studio.client.widget.util;

import com.google.gwt.user.client.ui.DialogBox;

/**
 * @author vladimir.kavoun
 * @since 0.1
 */
public class LoadingIndicator extends DialogBox {
    public LoadingIndicator() {
        super(true, true);

        this.getElement().setId("global-loading-widget");

        this.setHTML("<i class=\"fa fa-spinner fa-spin\"></i>");
        this.center();
    }
}
