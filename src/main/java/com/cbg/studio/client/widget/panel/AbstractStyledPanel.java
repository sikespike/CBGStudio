/**
 * 
 */
package com.cbg.studio.client.widget.panel;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author vladimir.kavoun
 * @since 0.1
 */
public abstract class AbstractStyledPanel extends FlexTable {
    private int buttonCols = 0;
    
    protected FlowPanel body;
    protected FlexTable buttons;
    
    public AbstractStyledPanel() {
        super();
        init();
    }
    
    private void init() {
        this.body = new FlowPanel();

        this.buttons = new FlexTable();

        super.add(this.body);
        super.add(this.buttons);

        this.buttons.getElement().addClassName("display-none");
        
        this.addStyles();
    }

    @Override
    public void add(Widget w){
        this.body.add(w);
    }
    
    public void addButton(Widget button){
        this.buttons.setWidget(0, this.buttonCols, button);
        this.buttonCols++;
        this.buttons.getElement().replaceClassName("display-none", "display-show");
    }
    
    @Override
    public void setWidth(String width){
        String innerWidthString = width.replaceAll("px", "");
        int innerWidth = Integer.parseInt(innerWidthString);
        innerWidth += 10;
        
        super.setWidth(width);
        this.body.setWidth(innerWidth+"px");
    }
    
    protected abstract void addStyles();
}
