/**
 * 
 */
package com.cbg.studio.client.widget.table;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.FlexTable;

/**
 * @author vladimir.kavoun
 * 
 */
public class CBGTable extends FlexTable {
    protected Element thead;
    protected Element thRow;
    protected Element tbody;

    /**
     * 
     */
    public CBGTable() {
        super();
        init();
    }

    private void init() {
        this.thead = DOM.createTHead();
        this.thRow = DOM.createTR();

        thead.appendChild(thRow);

        DOM.insertChild(this.getElement(), thead, 0);
    }

    public void addHeader(String html) {
        Element el = DOM.createTH();
        el.setInnerHTML(html);
        this.thRow.appendChild(el);
    }
}
