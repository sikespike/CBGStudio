/**
 * 
 */
package com.cbg.studio.server.domain.geometry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xif
 * 
 */
public class DisplayBoneGroupList implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<String> keys;
    private Map<String, List<String>> groups;

    /**
     * 
     */
    public DisplayBoneGroupList() {
        this.keys = new ArrayList<String>();
        this.groups = new HashMap<String, List<String>>();
    }
    
    public void put(String key, List<String> group) {
        if (!this.groups.containsKey(key)) {
            this.addKey(key);
        }

        this.groups.put(key, group);
    }

    private void addKey(String key) {
        this.keys.add(key);

        Collections.sort(this.keys);
    }

    public List<String> getGroup(String key) {
        return this.groups.get(key);
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public Map<String, List<String>> getGroups() {
        return groups;
    }
}
