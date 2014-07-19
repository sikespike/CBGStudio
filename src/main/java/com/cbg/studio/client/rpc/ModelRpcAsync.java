package com.cbg.studio.client.rpc;

import com.cbg.studio.client.data.CATModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ModelRpcAsync {
    public void getModel(AsyncCallback<CATModel> callback);
}
