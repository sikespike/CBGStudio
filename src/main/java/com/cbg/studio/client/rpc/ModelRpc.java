package com.cbg.studio.client.rpc;

import com.cbg.studio.client.data.CATModelDto;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("modelRpc")
public interface ModelRpc extends RemoteService{
    public CATModelDto getModel();
}
