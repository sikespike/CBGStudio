/**
 * 
 */
package com.cbg.studio.client.widget.tree;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * @author vladimir.kavoun
 * 
 */
public class CheckBoxTreeItem extends TreeItem implements
        ValueChangeHandler<Boolean> {
    public CheckBoxTreeItem() {
        super();
    }

    public CheckBoxTreeItem(String itemText) {
        super();
        CheckBox cb = new CheckBox(itemText);
        cb.addValueChangeHandler(this);
        this.setWidget(cb);
    }

    @Override
    public TreeItem addTextItem(String itemText) {
        CheckBoxTreeItem ret = new CheckBoxTreeItem();

        CheckBox cb = new CheckBox(itemText);
        cb.addValueChangeHandler(ret);

        ret.setWidget(cb);
        addItem(ret);
        return ret;
    }

    public TreeItem addItem(String itemText, Object userObject) {
        TreeItem ret = this.addTextItem(itemText);
        ret.setUserObject(userObject);

        return ret;
    }

    /**
     * Gets the checkbox value
     * 
     * @return
     */
    public Boolean getSelected() {
        CheckBox cb = (CheckBox) this.getWidget();

        return cb.getValue();
    }

    public List<Object> getSelectedItems() {
        List<Object> items = new ArrayList<Object>();

        if (this.getChildCount() == 0) {
            if (this.getSelected().booleanValue()
                    && this.getUserObject() != null) {
                items.add(this.getUserObject());
            }
        } else {
            for (int x = 0; x < this.getChildCount(); x++) {
                CheckBoxTreeItem item = (CheckBoxTreeItem) this.getChild(x);
                List<Object> childItems = item.getSelectedItems();

                items.addAll(childItems);
            }
        }

        return items;
    }

    public int getSelectedCount() {
        int count = 0;

        for (int x = 0; x < this.getChildCount(); x++) {
            CheckBoxTreeItem item = (CheckBoxTreeItem) this.getChild(x);
            if (item.getSelected().booleanValue()) {
                count++;
            }
        }

        return count;
    }

    private void setCheckBoxValue(Boolean value, boolean fireEvent) {
        CheckBox cb = (CheckBox) this.getWidget();
        cb.setValue(value, fireEvent);
    }

    public void onValueChange(ValueChangeEvent<Boolean> e) {
        Boolean state = e.getValue();

        if (!state.booleanValue()) {
            CheckBoxTreeItem parent = (CheckBoxTreeItem) this.getParentItem();
            parent.setCheckBoxValue(state, false);
        } else if (state.booleanValue()) {
            CheckBoxTreeItem parent = (CheckBoxTreeItem) this.getParentItem();
            if(parent.getSelectedCount() == parent.getChildCount()){
                parent.setCheckBoxValue(state, false);
            }
        }

        if (this.getChildCount() > 0) {
            for (int x = 0; x < this.getChildCount(); x++) {
                CheckBoxTreeItem item = (CheckBoxTreeItem) this.getChild(x);
                item.setCheckBoxValue(state, true);
            }
        }
    }
}
