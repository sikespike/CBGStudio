/**
 * 
 */
package com.cbg.studio.client.geometry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cbg.studio.client.util.StringUtil;

/**
 * @author Xif
 * 
 */
public class DisplayBoneGroupList implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<String> keys;
    private Map<String, List<Bone>> groups;

    /**
     * 
     */
    public DisplayBoneGroupList() {
        this.keys = new ArrayList<String>();
        this.groups = new HashMap<String, List<Bone>>();
    }

    @Override
    public String toString(){
        StringBuilder b = new StringBuilder();
        
        b.append("{[");
        int size = this.keys.size();
        int x=0;
        for(String key:this.keys){
            
            b.append("{");
            b.append(StringUtil.jsonParamater("groupName", key));
            b.append(",");
            
            List<Bone> bones = this.groups.get(key);
            
            List<String> boneNames = new ArrayList<String>();
            for(int i=0;i<bones.size();i++){
                boneNames.add(bones.get(i).getName());
            }
            
            b.append(StringUtil.jsonParamater("groupBones", boneNames)).append("}");
            
            if(x+1 != size){
                b.append(",");
            }
            x++;
        }
        
        b.append("]}");
        return b.toString();
    }
    
    public void put(String key, List<Bone> group) {
        if (!this.groups.containsKey(key)) {
            this.addKey(key);
        }

        this.groups.put(key, group);
    }

    private void addKey(String key) {
        this.keys.add(key);

        Collections.sort(this.keys);
    }

    public List<Bone> getGroup(String key) {
        return this.groups.get(key);
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public Map<String, List<Bone>> getGroups() {
        return groups;
    }
}
