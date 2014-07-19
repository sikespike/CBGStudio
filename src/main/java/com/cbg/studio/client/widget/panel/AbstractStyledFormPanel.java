/**
 * 
 */
package com.cbg.studio.client.widget.panel;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.NamedFrame;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author vladimir.kavoun
 * @since 0.1
 */
public abstract class AbstractStyledFormPanel extends FormPanel {
    private int fieldRows = 0;
    private int buttonCols = 0;

    protected FlowPanel wrapper;
    
    protected FlexTable body;
    protected FlexTable buttons;

    
    /**
     * 
     */
    public AbstractStyledFormPanel() {
        super();
        init();
    }

    /**
     * @param frameTarget
     */
    public AbstractStyledFormPanel(NamedFrame frameTarget) {
        super(frameTarget);
        init();
    }

    /**
     * @param target
     */
    public AbstractStyledFormPanel(String target) {
        super(target);
        init();
    }

    /**
     * @param element
     */
    public AbstractStyledFormPanel(Element element) {
        super(element);
        init();
    }

    /**
     * @param element
     * @param createIFrame
     */
    public AbstractStyledFormPanel(Element element, boolean createIFrame) {
        super(element, createIFrame);
        init();
    }

    private void init() {
        this.wrapper = new FlowPanel();
        
        this.body = new FlexTable();

        this.buttons = new FlexTable();

        wrapper.add(this.body);
        wrapper.add(this.buttons);

        super.add(wrapper);

        this.addStyles();
    }

    @Override
    public void add(Widget child) {
        this.body.setWidget(this.fieldRows, 1, child);
        Element tr = DOM.getParent(DOM.getParent(child.getElement()));
        tr.getStyle().setWidth(100, Style.Unit.EX);
        Element sibling = DOM.getChild(tr, 0);
        sibling.addClassName("display-none");
        this.fieldRows++;
    }

    public void addButton(Widget button) {
        this.buttons.setWidget(0, this.buttonCols, button);
        this.buttonCols++;
    }

    public void addLabel(int row, String text){
        this.body.setHTML(row, 0, text);
        this.showLabel(row);
    }
    
    private void showLabel(int row){
        Element tBody = DOM.getChild(this.body.getElement(), 1);
        Element tr = DOM.getChild(tBody, row);
        Element sibling = DOM.getChild(tr, 0);
        sibling.replaceClassName("display-none", "display-show");
    }
    
    protected abstract void addStyles();
}
