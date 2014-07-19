/**
 * 
 */
package com.cbg.studio.client.widget.screen.scheduler.data;

import java.io.Serializable;

/**
 * @author vladimir.kavoun
 *
 */
public class ScheduledTaskManagementDto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long userId;
    private String userName;
    private String fullName;
    private String email;
    private Boolean lockedOut;
    private Boolean deleted;
    
    public Long getScheduledTaskId() {
        return userId;
    }
    public void setScheduledTaskId(Long userId) {
        this.userId = userId;
    }
    public String getScheduledTaskName() {
        return userName;
    }
    public void setScheduledTaskName(String userName) {
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
