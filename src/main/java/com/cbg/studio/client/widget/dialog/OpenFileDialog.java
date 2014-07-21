/**
 * 
 */
package com.cbg.studio.client.widget.dialog;

import com.cbg.studio.client.data.CATModelDto;
import com.cbg.studio.client.util.RPCUtil;
import com.cbg.studio.client.widget.screen.util.UiAction;
import com.cbg.studio.client.widget.screen.util.UiActionEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.HTML;

/**
 * @author Siebe
 * 
 */
public class OpenFileDialog extends AbstractAppDialog implements
        SubmitCompleteHandler {
    private FormPanel form;
    private FileUpload fileUpload;

    private CATModelDto model;

    /**
     * @param autoHide
     * @param modal
     */
    public OpenFileDialog(String title, boolean autoHide, boolean modal) {
        super(autoHide, modal);
        this.setHTML(title);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cbg.studio.client.widget.dialog.AbstractAppDialog#addBody()
     */
    @Override
    protected void addBody() {
        this.body.setWidget(0, 0, new HTML("File:"));

        form = new FormPanel();
        form.setAction(GWT.getModuleBaseURL()+"openFile");
        form.setMethod(FormPanel.METHOD_POST);
        form.setEncoding(FormPanel.ENCODING_MULTIPART);

        fileUpload = new FileUpload();
        fileUpload.setName("file");

        form.add(fileUpload);

        form.addSubmitCompleteHandler(this);
        this.body.setWidget(0, 1, form);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler#
     * onSubmitComplete
     * (com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent)
     */
    public void onSubmitComplete(SubmitCompleteEvent event) {
        RPCUtil.getModelRpc().getModel(new AsyncCallback<CATModelDto>() {

            /*
             * (non-Javadoc)
             * 
             * @see
             * com.google.gwt.user.client.rpc.AsyncCallback#onFailure(java.lang
             * .Throwable)
             */
            public void onFailure(Throwable caught) {

            }

            /*
             * (non-Javadoc)
             * 
             * @see
             * com.google.gwt.user.client.rpc.AsyncCallback#onSuccess(java.lang
             * .Object)
             */
            public void onSuccess(CATModelDto result) {
                setModel(result);
                OpenFileDialog.this.uiHandler.onUiAction(new UiActionEvent(
                        OpenFileDialog.this, UiAction.LOAD));
                OpenFileDialog.this.hide(true);
            }

        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cbg.studio.client.widget.dialog.AbstractAppDialog#onOk()
     */
    @Override
    protected void onOk() {
        form.submit();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cbg.studio.client.widget.dialog.AbstractAppDialog#onCancel()
     */
    @Override
    protected void onCancel() {

    }

    /**
     * @return the model
     */
    public CATModelDto getModel() {
        return model;
    }

    /**
     * @param model
     *            the model to set
     */
    public void setModel(CATModelDto model) {
        this.model = model;
    }
}
