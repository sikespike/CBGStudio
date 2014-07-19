/**
 * 
 */
package com.cbg.studio.client.geometry;

import java.io.IOException;
import java.io.Serializable;

import com.cbg.studio.client.util.StringUtil;

/**
 * @author Siebe
 * 
 */
public class Vertex implements Serializable {
    private static final long serialVersionUID = 1L;
    private Vector position;
    private Vector normal;

    private Vector2 uv;

    private Bone bone0;
    private String bone0Name;
    private Bone bone1;
    private String bone1Name;

    private int bone0Weight;

    public Vertex() {
        this.position = new Vector();
        this.normal = new Vector();
        this.uv = new Vector2();
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        b.append("{");

        b.append(StringUtil.jsonParamater("position", this.position))
                .append(",")
                .append(StringUtil.jsonParamater("normal", this.normal))
                .append(",")
                .append(StringUtil.jsonParamater("uv", this.uv))
                .append(",")
                .append(StringUtil.jsonParamater("bone0", this.bone0.getName()))
                .append(",")
                .append(StringUtil.jsonParamater("bone1", this.bone1.getName()))
                .append(",").append(",bone0Weight:").append(this.bone0Weight);

        b.append("}");

        return b.toString();
    }

    @SuppressWarnings("all")
    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        this.position = (Vector)stream.readObject();
        this.normal = (Vector)stream.readObject();
        this.uv  = (Vector2)stream.readObject();
        this.bone0Name = (String)stream.readObject();
        this.bone1Name = (String)stream.readObject();
        this.bone0Weight = stream.readInt();
    }

    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        stream.writeObject(this.position);
        stream.writeObject(this.normal);
        stream.writeObject(this.uv);
        stream.writeObject(this.bone0.getName());
        stream.writeObject(this.bone1.getName());
        stream.writeInt(this.bone0Weight);
    }
    
    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getNormal() {
        return normal;
    }

    public void setNormal(Vector normal) {
        this.normal = normal;
    }

    public Vector2 getUv() {
        return uv;
    }

    public void setUv(Vector2 uv) {
        this.uv = uv;
    }

    /**
     * @return the bone0
     */
    public Bone getBone0() {
        return bone0;
    }

    /**
     * @param bone0
     *            the bone0 to set
     */
    public void setBone0(Bone bone0) {
        this.bone0 = bone0;
    }

    /**
     * @return the bone1
     */
    public Bone getBone1() {
        return bone1;
    }

    /**
     * @param bone1
     *            the bone1 to set
     */
    public void setBone1(Bone bone1) {
        this.bone1 = bone1;
    }

    /**
     * @return the bone0Weight
     */
    public int getBone0Weight() {
        return bone0Weight;
    }

    /**
     * @param bone0Weight
     *            the bone0Weight to set
     */
    public void setBone0Weight(int bone0Weight) {
        this.bone0Weight = bone0Weight;
    }

    /**
     * @return the bone0Name
     */
    public String getBone0Name() {
        return bone0Name;
    }

    /**
     * @param bone0Name the bone0Name to set
     */
    public void setBone0Name(String bone0Name) {
        this.bone0Name = bone0Name;
    }

    /**
     * @return the bone1Name
     */
    public String getBone1Name() {
        return bone1Name;
    }

    /**
     * @param bone1Name the bone1Name to set
     */
    public void setBone1Name(String bone1Name) {
        this.bone1Name = bone1Name;
    }
}
