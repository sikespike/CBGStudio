/**
 * 
 */
package com.cbg.studio.client.widget.screen.security.group.data;

import java.io.Serializable;

/**
 * @author vladimir.kavoun
 *
 */
public class SecurityResourceDto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long secResourceId;
    private String group;
    private String secResourceName;
    
    public Long getSecResourceId() {
        return secResourceId;
    }
    public void setSecResourceId(Long secResourceId) {
        this.secResourceId = secResourceId;
    }
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public String getSecResourceName() {
        return secResourceName;
    }
    public void setSecResourceName(String secResourceName) {
        this.secResourceName = secResourceName;
    }
}
