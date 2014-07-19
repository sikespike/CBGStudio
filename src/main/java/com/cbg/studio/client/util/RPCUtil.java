/**
 * 
 */
package com.cbg.studio.client.util;

import com.cbg.studio.client.rpc.ModelRpc;
import com.cbg.studio.client.rpc.ModelRpcAsync;
import com.google.gwt.core.client.GWT;


/**
 * @author Siebe
 *
 */
public class RPCUtil {
    private static ModelRpcAsync modelRpc;
    
    public static ModelRpcAsync getModelRpc(){
        if(modelRpc == null){
            modelRpc = GWT.create(ModelRpc.class);
        }
        
        return modelRpc;
    }
}
