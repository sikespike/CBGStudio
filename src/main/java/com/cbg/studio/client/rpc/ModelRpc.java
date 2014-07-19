package com.cbg.studio.client.rpc;

import com.cbg.studio.client.data.CATModel;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("modelRpc")
public interface ModelRpc extends RemoteService{
    public CATModel getModel();
}
