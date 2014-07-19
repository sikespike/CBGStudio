/**
 * 
 */
package com.cbg.studio.client.widget.screen.security.group.data;

import java.io.Serializable;

/**
 * @author vladimir.kavoun
 *
 */
public class GroupDetailsDto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long userId;
    private String password;
    private String groupName;
    private String userName;
    private String fullName;
    private String email;
    private Boolean lockedOut;
    private Boolean deleted;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Boolean getLockedOut() {
        return lockedOut;
    }
    public void setLockedOut(Boolean lockedOut) {
        this.lockedOut = lockedOut;
    }
    public Boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

}
