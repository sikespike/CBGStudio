/**
 * 
 */
package com.cbg.studio.client.widget.screen.security.group.data;

import java.io.Serializable;

/**
 * @author vladimir.kavoun
 *
 */
public class GroupManagementDto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long groupId;
    private String groupName;
    
    public Long getGroupId() {
        return groupId;
    }
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
