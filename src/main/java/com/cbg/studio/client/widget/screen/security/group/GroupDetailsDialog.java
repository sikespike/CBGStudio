/**
 * 
 */
package com.cbg.studio.client.widget.screen.security.group;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.cbg.studio.client.widget.screen.security.group.data.GroupDetailsDto;
import com.cbg.studio.client.widget.screen.security.group.tree.SecurityResourcesTree;
import com.google.gwt.user.client.ui.TextBox;

/**
 * @author vladimir.kavoun
 * 
 */
public class GroupDetailsDialog extends AbstractAction {
    private static final long serialVersionUID = 1L;
    private Long groupId;
    private GroupDetailsDto dto;

    private TextBox groupName;
    private SecurityResourcesTree secResources;

    public GroupDetailsDialog(Long groupId) {
        super();
        this.groupId = groupId;
        loadUi();
        loadGroup();
    }

    private void loadUi() {

    }

    private void loadGroup() {

    }

    private void setData() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.vfmlSupportApp.client.app.widget.dialog.AbstractAppDialog#addBody()
     */
    protected void addBody() {
        /*
         * int row = 0; this.body.setHTML(row, 0, "Group name");
         * 
         * this.groupName = createTextBox("group-name");
         * 
         * this.body.setWidget(row, 1, groupName);
         * 
         * row++;
         * 
         * this.body.setHTML(row, 0, "Security Resources");
         * 
         * this.secResources = new SecurityResourcesTree();
         * 
         * this.body.setWidget(row, 1, secResources);
         */
    }

    private TextBox createTextBox(String id) {
        TextBox tb = new TextBox();
        tb.getElement().setId(id);

        return tb;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vfmlSupportApp.client.app.widget.dialog.AbstractAppDialog#onOk()
     */
    protected void onOk() {
        // uiHandler.onUiAction(UiAction.REFRESH);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.vfmlSupportApp.client.app.widget.dialog.AbstractAppDialog#onCancel()
     */
    protected void onCancel() {
        // do nothing;
    }

}
