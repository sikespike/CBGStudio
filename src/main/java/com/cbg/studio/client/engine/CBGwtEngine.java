/**
 * 
 */
package com.cbg.studio.client.engine;

import com.cbg.studio.client.data.CATModelDto;
import com.cbg.studio.client.gwtgl.binding.WebGLRenderingContext;
import com.cbg.studio.client.gwtgl.binding.WebGLUniformLocation;

/**
 * @author Xif
 *
 */
public class CBGwtEngine extends AbstractGwtEngine {
	private CATModelDto model;
	
	public CBGwtEngine(){
		super();
	}
	
	public CATModelDto getModel() {
		return model;
	}

	public void setModel(CATModelDto model) {
		this.model = model;
	}

	@Override
	public void drawScene(){
		glContext.clear(WebGLRenderingContext.COLOR_BUFFER_BIT
				| WebGLRenderingContext.DEPTH_BUFFER_BIT);
		float[] perspectiveMatrix = createPerspectiveMatrix(45, 1, 0.1f, 1000);
		WebGLUniformLocation uniformLocation = glContext.getUniformLocation(
				shaderProgram, "perspectiveMatrix");
		glContext.uniformMatrix4fv(uniformLocation, false, perspectiveMatrix);
		glContext.vertexAttribPointer(vertexPositionAttribute, 3,
				WebGLRenderingContext.FLOAT, false, 0, 0);
		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 0, 3);
	}
}
