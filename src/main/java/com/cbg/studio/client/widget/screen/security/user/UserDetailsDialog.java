/**
 * 
 */
package com.cbg.studio.client.widget.screen.security.user;

import com.cbg.studio.client.widget.dialog.AbstractAppDialog;
import com.cbg.studio.client.widget.input.AppListBox;
import com.cbg.studio.client.widget.screen.security.user.data.UserDetailsDto;
import com.cbg.studio.client.widget.screen.util.UiAction;
import com.cbg.studio.client.widget.screen.util.UiActionEvent;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

/**
 * @author vladimir.kavoun
 * 
 */
public class UserDetailsDialog extends AbstractAppDialog{
    private Long userId;
    private UserDetailsDto dto;
    
    private TextBox userName;
    private PasswordTextBox password;
    private PasswordTextBox newPassword;
    private AppListBox groups;
    private TextBox firstName;
    private TextBox lastName;
    private TextBox email;
    private CheckBox deleted;
    private CheckBox lockedOut;

    private boolean groupsLoaded = false;
    
    public UserDetailsDialog(Long userId) {
        super();
        
        this.userId = userId;
        loadUi();
        loadUser();
    }

    private void loadUi(){
        
    }
    
    private void loadUser(){
        
    }
    
    private void setData(){
        
        
        
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.vfmlSupportApp.client.app.widget.dialog.AbstractAppDialog#addBody()
     */
    @Override
    protected void addBody() {
        int row = 0;
        this.body.setHTML(row, 0, "Username");

        this.userName = createTextBox("username");

        this.body.setWidget(row, 1, userName);

        row++;

        this.body.setHTML(row, 0, "Password");

        this.password = createPasswordTextBox("password");

        this.body.setWidget(row, 1, password);

        row++;

        this.body.setHTML(row, 0, "New Password");

        this.newPassword = createPasswordTextBox("new-password");

        this.body.setWidget(row, 1, newPassword);

        row++;
        
        this.body.setHTML(row, 0, "Group");

        this.groups = new AppListBox("group");

        this.body.setWidget(row, 1, groups);

        row++;

        this.body.setHTML(row, 0, "First Name");

        this.firstName = createTextBox("first-name");

        this.body.setWidget(row, 1, firstName);

        row++;

        this.body.setHTML(row, 0, "Last Name");

        this.lastName = createTextBox("last-name");

        this.body.setWidget(row, 1, lastName);

        row++;

        this.body.setHTML(row, 0, "Email");

        this.email = createTextBox("email");

        this.body.setWidget(row, 1, email);

        row++;

        this.body.setHTML(row, 0, "Deleted");

        this.deleted = createCheckBox("deleted");

        this.body.setWidget(row, 1, deleted);

        row++;

        this.body.setHTML(row, 0, "Locked Out");

        this.lockedOut = createCheckBox("locked-out");

        this.body.setWidget(row, 1, lockedOut);
    }

    private TextBox createTextBox(String id) {
        TextBox tb = new TextBox();
        tb.getElement().setId(id);

        return tb;
    }

    private PasswordTextBox createPasswordTextBox(String id) {
        PasswordTextBox tb = new PasswordTextBox();
        tb.getElement().setId(id);

        return tb;
    }

    private CheckBox createCheckBox(String id) {
        CheckBox cb = new CheckBox();
        cb.getElement().setId(id);

        return cb;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vfmlSupportApp.client.app.widget.dialog.AbstractAppDialog#onOk()
     */
    @Override
    protected void onOk() {
        uiHandler.onUiAction(new UiActionEvent(this,UiAction.REFRESH));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.vfmlSupportApp.client.app.widget.dialog.AbstractAppDialog#onCancel()
     */
    @Override
    protected void onCancel() {
        //do nothing;
    }

}
