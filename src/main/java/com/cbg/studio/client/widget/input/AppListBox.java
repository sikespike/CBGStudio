/**
 * 
 */
package com.cbg.studio.client.widget.input;

import java.io.Serializable;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;

/**
 * @author vladimir.kavoun
 * 
 */
public class AppListBox extends Composite {
    private ListBox lb;
    private LinkedHashMap<String, Serializable> data;

    public AppListBox(String id) {
        lb = new ListBox();
        lb.getElement().setId(id);

        this.data = new LinkedHashMap<String, Serializable>();

        this.initWidget(lb);
    }

    @Override
    public void setWidth(String width) {
        this.lb.setWidth(width);
    }

    public void clearData() {
        this.data = new LinkedHashMap<String, Serializable>();
        this.lb.clear();
    }

    public void setData(LinkedHashMap<String, Serializable> data) {
        this.data = data;
        lb.clear();
        this.setListBoxValues();
    }

    private void setListBoxValues() {
        for (String key : data.keySet()) {
            lb.addItem(key);
        }
    }

    public Serializable getSelectedValue() {
        int selected = lb.getSelectedIndex();
        String item = lb.getItemText(selected);

        return data.get(item);
    }
}
