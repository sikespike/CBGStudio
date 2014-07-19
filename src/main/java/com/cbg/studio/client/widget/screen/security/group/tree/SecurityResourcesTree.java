/**
 * 
 */
package com.cbg.studio.client.widget.screen.security.group.tree;

import java.util.ArrayList;
import java.util.List;

import com.cbg.studio.client.widget.screen.security.group.data.SecurityResourceDto;
import com.cbg.studio.client.widget.tree.CheckBoxTree;
import com.cbg.studio.client.widget.tree.CheckBoxTreeItem;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * @author vladimir.kavoun
 *
 */
public class SecurityResourcesTree extends CheckBoxTree {

    public void buildTree(List<SecurityResourceDto> secResources){
        TreeItem root = new TreeItem();
        
        this.addItem(root);
        
        String group = null;
        CheckBoxTreeItem currentItem = null;
        
        for(SecurityResourceDto resource : secResources){
            if(group != resource.getGroup()){
                currentItem = new CheckBoxTreeItem();
                group = resource.getGroup();
                currentItem.setWidget(new CheckBox(group));
                root.addItem(currentItem);
            }
            currentItem.addItem(resource.getSecResourceName(), resource);
        }
    }
    
    public List<SecurityResourceDto> getItems(){
        List<SecurityResourceDto> items = new ArrayList<SecurityResourceDto>();
        
        List<Object> selected = this.getSelectedItems();
        
        for(Object i:selected){
            items.add((SecurityResourceDto)i);
        }
        
        return items;
    }
}
