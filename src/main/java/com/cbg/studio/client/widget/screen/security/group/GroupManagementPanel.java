/**
 * 
 */
package com.cbg.studio.client.widget.screen.security.group;

import java.util.List;

import com.cbg.studio.client.widget.panel.StyledPanel;
import com.cbg.studio.client.widget.screen.security.group.data.GroupManagementDto;
import com.cbg.studio.client.widget.screen.util.UiAction;
import com.cbg.studio.client.widget.screen.util.UiCallbackHandler;
import com.cbg.studio.client.widget.table.CBGTable;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;

/**
 * @author vladimir.kavoun
 * 
 */
public class GroupManagementPanel extends StyledPanel implements UiCallbackHandler{

    private CBGTable groupTable;

    public GroupManagementPanel() {
        super();
        initTable();
        loadData();
    }

    private void initTable() {
        this.groupTable = new CBGTable();

        this.groupTable.addHeader("Group");
        this.groupTable.addHeader("Actions");

        this.add(this.groupTable);
    }

    private void loadData(){
        
    }
    
    private void setData(List<GroupManagementDto> groups){
        int x=0;
        for(GroupManagementDto group:groups){
            final Long gid = group.getGroupId();
            Button gNameButton = new Button(group.getGroupName(), new ClickHandler(){
                public void onClick(ClickEvent e){
                    /*GroupDetailsDialog d = new GroupDetailsDialog(gid);
                    d.setUiHandler(GroupManagementPanel.this);
                    d.center();
                    d.show();*/
                }
            });
            
            groupTable.setWidget(x, 0, gNameButton);
            groupTable.setWidget(x, 1, new ActionsPanel(group));
            x++;
        }
    }
    
    public void onUiAction(UiAction action){
        if(action == UiAction.REFRESH){
            this.loadData();
        }
    }
    
    class ActionsPanel extends FlexTable implements ClickHandler {
        public static final String DELETE = "Delete";

        private GroupManagementDto group;

        private Button delete;

        public ActionsPanel(GroupManagementDto dto) {
            this.group = dto;

            this.delete = new Button(DELETE, this);

            this.setWidget(0, 0, this.delete);
        }

        public void onClick(ClickEvent e) {
            if (e.getSource() == delete) {
                
            }
        }
    }
}
