/**
 * 
 */
package com.cbg.studio.client.widget.screen.scheduler;

import java.util.List;

import com.cbg.studio.client.widget.panel.StyledFormPanel;
import com.cbg.studio.client.widget.screen.scheduler.data.ScheduledTaskManagementDto;
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
public class ScheduledTaskManagementPanel extends StyledFormPanel implements
        UiCallbackHandler {

    private CBGTable scheduledTaskTable;

    public ScheduledTaskManagementPanel() {
        super();
        initTable();
        loadData();
    }

    private void initTable() {
        this.scheduledTaskTable = new CBGTable();

        this.scheduledTaskTable.addHeader("Scheduled Task Name");
        this.scheduledTaskTable.addHeader("Scheduled Task Type");
        this.scheduledTaskTable.addHeader("State");
        this.scheduledTaskTable.addHeader("Actions");

        this.add(this.scheduledTaskTable);
    }

    private void loadData() {

    }

    private void setData(List<ScheduledTaskManagementDto> ScheduledTasks) {
        int x = 0;
        for (ScheduledTaskManagementDto ScheduledTask : ScheduledTasks) {
            final Long uid = ScheduledTask.getScheduledTaskId();
            Button uNameButton = new Button(
                    ScheduledTask.getScheduledTaskName(), new ClickHandler() {
                        @Override
                        public void onClick(ClickEvent e) {
                            ScheduledTaskDetailsDialog d = new ScheduledTaskDetailsDialog(
                                    uid);
                            d.setUiHandler(ScheduledTaskManagementPanel.this);
                            d.center();
                            d.show();
                        }
                    });

            scheduledTaskTable.setWidget(x, 0, uNameButton);
            scheduledTaskTable.setHTML(x, 1, ScheduledTask.getFullName());
            scheduledTaskTable.setHTML(x, 2, ScheduledTask.getEmail());
            scheduledTaskTable.setWidget(x, 3, new ActionsPanel(ScheduledTask));
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

        private ScheduledTaskManagementDto scheduledTask;

        private Button enable;
        private Button delete;

        public ActionsPanel(ScheduledTaskManagementDto dto) {
            this.scheduledTask = dto;

            String enableText = !this.scheduledTask.getLockedOut() ? DISABLE
                    : ENABLE;
            this.enable = new Button(enableText, this);

            String deleteText = !this.scheduledTask.getDeleted() ? DELETE
                    : RESTORE;
            this.delete = new Button(deleteText, this);

            this.setWidget(0, 0, this.enable);
            this.setWidget(0, 1, delete);
        }

        @Override
        public void onClick(ClickEvent e) {
            if (e.getSource() == enable) {

            } else if (e.getSource() == delete) {

            }
        }
    }
}
