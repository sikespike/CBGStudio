/**
 * 
 */
package com.cbg.studio.server.rpc.impl;

import com.cbg.studio.client.data.CATModelDto;
import com.cbg.studio.client.rpc.ModelRpc;
import com.cbg.studio.server.domain.CATModel;
import com.cbg.studio.server.rpc.dto.CATModelDtoFactory;

/**
 * @author Siebe
 * 
 */
public class ModelRpcImpl extends AbstractStudioRpc implements ModelRpc {
    private static final long serialVersionUID = 1L;

    @Override
    public CATModelDto getModel() {
        CATModel model = (CATModel) this.getServletContext().getAttribute(
                "model");
        CATModelDto dto = CATModelDtoFactory.createModelDto(model);

        this.getServletContext().removeAttribute("model");

        return dto;
    }
}
