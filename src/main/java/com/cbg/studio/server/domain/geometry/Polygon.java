/**
 * 
 */
package com.cbg.studio.server.domain.geometry;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Siebe
 * 
 */
public abstract class Polygon implements Serializable {
    private static final long serialVersionUID = 1L;
    protected List<Vertex> verts;

    public Polygon() {
        verts = new ArrayList<Vertex>();
    }

    public Polygon(List<Vertex> verts) {
        this.verts = verts;
    }

    public void addVertex(Vertex v) {
        if (verts == null) {
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
     * @param verts
     *            the verts to set
     */
    public void setVerticies(List<Vertex> verticies) {
        this.verts = verticies;
    }

    @SuppressWarnings("all")
    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        this.verts = (List<Vertex>) stream.readObject();
    }

    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        stream.writeObject(this.verts);
    }
}
