/**
 * 
 */
package com.cbg.studio.client.data.geometry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cbg.studio.client.util.StringUtil;

/**
 * @author Siebe
 *
 */
public abstract class Polygon implements Serializable{
    private static final long serialVersionUID = 1L;
    protected List<Vertex> verts;
    
    public Polygon(){
        verts = new ArrayList<Vertex>();
    }
    
    public Polygon(List<Vertex> verts){
        this.verts = verts;
    }
    
    public void addVertex(Vertex v){
        if(verts == null){
            verts = new ArrayList<Vertex>();
        }
        
        verts.add(v);
    }

    /**
     * @return the verts
     */
    public List<Vertex> getVerticies() {
        return verts;
    }

    /**
     * @param verts the verts to set
     */
    public void setVerticies(List<Vertex> verticies) {
        this.verts = verticies;
    }
    
    @Override
    public String toString(){
        StringBuilder b = new StringBuilder();
        
        b.append("{polygon:");
        b.append(StringUtil.serializeJsonList(this.verts));
        b.append("}");
        
        return b.toString();
    }
}
