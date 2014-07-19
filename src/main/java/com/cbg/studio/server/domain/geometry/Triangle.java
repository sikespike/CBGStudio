/**
 * 
 */
package com.cbg.studio.server.domain.geometry;

import java.io.Serializable;
import java.util.List;

/**
 * @author Siebe
 *
 */
public class Triangle extends Polygon implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    public Triangle() {
        super();
    }

    /**
     * @param verts
     */
    public Triangle(List<Vertex> verts) {
        if(verts.size() <= 3){
            this.verts = verts;
        } else {
            throw new RuntimeException("Triangle cannot have more than 3 verticies.");
        }
    }

    /* (non-Javadoc)
     * @see com.cbg.core.geometry.cat.Polygon#addVertex(com.cbg.core.geometry.cat.Vertex)
     */
    @Override
    public void addVertex(Vertex v) {
        if(this.verts.size() < 3){
            super.addVertex(v);
        } else {
            throw new RuntimeException("Triangle cannot have more than 3 verticies.");
        }
    }

    /* (non-Javadoc)
     * @see com.cbg.core.geometry.cat.Polygon#setVerticies(java.util.List)
     */
    @Override
    public void setVerticies(List<Vertex> verticies) {
        if(verticies.size() <= 3){
            super.setVerticies(verticies);
        } else {
            throw new RuntimeException("Triangle cannot have more than 3 verticies.");
        }
    }

}
