/**
 * 
 */
package com.cbg.studio.client.widget.screen.security.user;

import java.util.List;

import com.cbg.studio.client.widget.panel.StyledFormPanel;
import com.cbg.studio.client.widget.screen.security.user.data.UserManagementDto;
import com.cbg.studio.client.widget.screen.util.UiAction;
import com.cbg.studio.client.widget.screen.util.UiActionEvent;
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
public class UserManagementPanel extends StyledFormPanel implements
        UiCallbackHandler {

    private CBGTable userTable;

    public UserManagementPanel() {
        super();
        initTable();
        loadData();
    }

    private void initTable() {
        this.userTable = new CBGTable();

        this.userTable.addHeader("Username");
        this.userTable.addHeader("Name");
        this.userTable.addHeader("Email");
        this.userTable.addHeader("Actions");

        this.add(this.userTable);
    }

    private void loadData() {

    }

    private void setData(List<UserManagementDto> users) {
        int x = 0;
        for (UserManagementDto user : users) {
            final Long uid = user.getUserId();
            Button uNameButton = new Button(user.getUserName(),
                    new ClickHandler() {
                        @Override
                        public void onClick(ClickEvent e) {
                            UserDetailsDialog d = new UserDetailsDialog(uid);
                            d.setUiHandler(UserManagementPanel.this);
                            d.center();
                            d.show();
                        }
                    });

            userTable.setWidget(x, 0, uNameButton);
            userTable.setHTML(x, 1, user.getFullName());
            userTable.setHTML(x, 2, user.getEmail());
            userTable.setWidget(x, 3, new ActionsPanel(user));
            x++;
        }
    }

    @Override
    public void onUiAction(UiActionEvent e) {
        if (e.getAction() == UiAction.REFRESH) {
            this.loadData();
        }
    }

    class ActionsPanel extends FlexTable implements ClickHandler {
        public static final String ENABLE = "Enable";
        public static final String DISABLE = "Disable";
        public static final String DELETE = "Delete";
        public static final String RESTORE = "Restore";

        private UserManagementDto user;

        private Button enable;
        private Button delete;

        public ActionsPanel(UserManagementDto dto) {
            this.user = dto;

            String enableText = !this.user.getLockedOut() ? DISABLE : ENABLE;
            this.enable = new Button(enableText, this);

            String deleteText = !this.user.getDeleted() ? DELETE : RESTORE;
            this.delete = new Button(deleteText, this);

            this.setWidget(0, 0, this.enable);
            this.setWidget(0, 1, delete);
        }

        @Override
        public void onClick(ClickEvent e) {
            if (e.getSource() == enable) {
                if (!this.user.getLockedOut()) {

                } else {

                }
            } else if (e.getSource() == delete) {
                if (!this.user.getDeleted()) {

                } else {

                }
            }
        }
    }
}
