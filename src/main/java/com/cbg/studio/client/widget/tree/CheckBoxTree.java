/**
 * 
 */
package com.cbg.studio.client.widget.tree;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Tree;

/**
 * @author vladimir.kavoun
 *
 */
public class CheckBoxTree extends Tree {

    public CheckBoxTree() {
        super();
    }

    /**
     * @param resources
     */
    public CheckBoxTree(Resources resources) {
        super(resources);
    }

    /**
     * @param resources
     * @param useLeafImages
     */
    public CheckBoxTree(Resources resources, boolean useLeafImages) {
        super(resources, useLeafImages);
    }

    public List<Object> getSelectedItems(){
        List<Object> items = new ArrayList<Object>();
        
        for(int x=0;x < this.getItemCount();x++){
            CheckBoxTreeItem item = (CheckBoxTreeItem)this.getItem(x);
            List<Object> childItems = item.getSelectedItems();
            
            items.addAll(childItems);
        }
        
        return items;
    }
}
