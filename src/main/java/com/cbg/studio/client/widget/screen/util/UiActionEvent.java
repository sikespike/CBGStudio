/**
 * 
 */
package com.cbg.studio.client.widget.screen.util;

/**
 * @author vladimir.kavoun
 * 
 */
public class UiActionEvent {
    private Object source;
    private UiAction action;

    public UiActionEvent(Object source, UiAction action) {
        this.source = source;
        this.action = action;
    }

    /**
     * @return the source
     */
    public Object getSource() {
        return source;
    }

    /**
     * @param source
     *            the source to set
     */
    public void setSource(Object source) {
        this.source = source;
    }

    /**
     * @return the action
     */
    public UiAction getAction() {
        return action;
    }

    /**
     * @param action
     *            the action to set
     */
    public void setAction(UiAction action) {
        this.action = action;
    }
}
