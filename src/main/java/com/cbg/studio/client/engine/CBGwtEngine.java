/**
 * 
 */
package com.cbg.studio.client.engine;

import java.util.ArrayList;
import java.util.List;

import com.cbg.studio.client.data.CATModelDto;
import com.cbg.studio.client.data.geometry.Triangle;
import com.cbg.studio.client.data.geometry.Vertex;
import com.cbg.studio.client.gwtgl.binding.WebGLRenderingContext;
import com.cbg.studio.client.gwtgl.binding.WebGLUniformLocation;

/**
 * @author Xif
 * 
 */
public class CBGwtEngine extends AbstractGwtEngine {
    private CATModelDto model;

    public CBGwtEngine() {
        super();
    }

    public CATModelDto getModel() {
        return model;
    }

    public void setModel(CATModelDto model) {
        this.model = model;
    }

    @Override
    protected float[] getVerticies(){
        return this.polygonsToFloatArray(this.model.getPolygons());
    }
    
    private float[] polygonsToFloatArray(List<Triangle> polygons){
        List<Float> verts = new ArrayList<Float>();
        
        for(Triangle t:polygons){
            verts.addAll(polygonToArray(t));
        }
        
        return floatListToArray(verts);
    }
    
    private List<Float> polygonToArray(Triangle polygon){
        List<Float> list = new ArrayList<Float>();
        
        for(Vertex v:polygon.getVerticies()){
            list.addAll(v.getPosition().toFloatList3());
        }
        
        return list;
    }
    
    private float[] floatListToArray(List<Float> list){
        float[] verts = new float[list.size()];
        
        for(int x=0;x<list.size();x++){
            verts[x] = list.get(x).floatValue();
        }
        
        return verts;
    }
    
    @Override
    protected void drawScene() {
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
