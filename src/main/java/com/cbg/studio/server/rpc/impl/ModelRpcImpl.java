/**
 * 
 */
package com.cbg.studio.server.rpc.impl;

import com.cbg.studio.client.data.CATModel;
import com.cbg.studio.client.rpc.ModelRpc;

/**
 * @author Siebe
 *
 */
public class ModelRpcImpl extends AbstractStudioRpc implements ModelRpc {
    private static final long serialVersionUID = 1L;
    
    public CATModel getModel(){
        CATModel model = (CATModel)this.getServletContext().getAttribute("model");
        return model;
    }
}
