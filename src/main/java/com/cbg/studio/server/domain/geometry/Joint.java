/**
 * 
 */
package com.cbg.studio.server.domain.geometry;

import java.io.IOException;
import java.io.Serializable;

import com.cbg.studio.client.util.StringUtil;

/**
 * @author Siebe
 * 
 */
public class Joint implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private RigidBody sourceRigidBody;
    private RigidBody destRigidBody;
    private Vector location;
    private Vector rotation;
    private Vector minLoc;
    private Vector maxLoc;
    private Vector minRot;
    private Vector maxRot;
    private Vector springConst;
    private Vector springRotConst;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        b.append("{");
        b.append(StringUtil.jsonParamater("name", this.name))
                .append(",")
                .append(StringUtil.jsonParamater("sourceRigidBody",
                        this.sourceRigidBody))
                .append(",")
                .append(StringUtil.jsonParamater("destRigidBody",
                        this.sourceRigidBody))
                .append(",")
                .append(StringUtil.jsonParamater("location", this.location))
                .append(",")
                .append(StringUtil.jsonParamater("rotation", this.rotation))
                .append(",")
                .append(StringUtil.jsonParamater("minLoc", this.minLoc))
                .append(",")
                .append(StringUtil.jsonParamater("maxLoc", this.maxLoc))
                .append(",")
                .append(StringUtil.jsonParamater("minRot", this.minRot))
                .append(",")
                .append(StringUtil.jsonParamater("maxRot", this.maxRot))
                .append(",")
                .append(StringUtil.jsonParamater("springConst",
                        this.springConst))
                .append(",")
                .append(StringUtil.jsonParamater("springRotConst",
                        this.springRotConst));
        b.append("}");

        return b.toString();
    }

    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        this.name = (String)stream.readObject();
        this.sourceRigidBody = (RigidBody)stream.readObject();
        this.destRigidBody = (RigidBody)stream.readObject();
        this.location = (Vector)stream.readObject();
        this.rotation = (Vector)stream.readObject();
        this.minLoc = (Vector)stream.readObject();
        this.maxLoc = (Vector)stream.readObject();
        this.minRot = (Vector)stream.readObject();
        this.maxRot = (Vector)stream.readObject();
        this.springConst = (Vector)stream.readObject();
        this.springRotConst = (Vector)stream.readObject();
    }

    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        stream.writeObject(this.name);
        stream.writeObject(this.sourceRigidBody);
        stream.writeObject(this.destRigidBody);
        stream.writeObject(this.location);
        stream.writeObject(this.rotation);
        stream.writeObject(this.minLoc);
        stream.writeObject(this.maxLoc);
        stream.writeObject(this.minRot);
        stream.writeObject(this.maxRot);
        stream.writeObject(this.maxRot);
        stream.writeObject(this.springConst);
        stream.writeObject(this.springRotConst);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sourceRigidBody
     */
    public RigidBody getSourceRigidBody() {
        return sourceRigidBody;
    }

    /**
     * @param sourceRigidBody
     *            the sourceRigidBody to set
     */
    public void setSourceRigidBody(RigidBody sourceRigidBody) {
        this.sourceRigidBody = sourceRigidBody;
    }

    /**
     * @return the destRigidBody
     */
    public RigidBody getDestRigidBody() {
        return destRigidBody;
    }

    /**
     * @param destRigidBody
     *            the destRigidBody to set
     */
    public void setDestRigidBody(RigidBody destRigidBody) {
        this.destRigidBody = destRigidBody;
    }

    /**
     * @return the location
     */
    public Vector getLocation() {
        return location;
    }

    /**
     * @param location
     *            the location to set
     */
    public void setLocation(Vector location) {
        this.location = location;
    }

    /**
     * @return the rotation
     */
    public Vector getRotation() {
        return rotation;
    }

    /**
     * @param rotation
     *            the rotation to set
     */
    public void setRotation(Vector rotation) {
        this.rotation = rotation;
    }

    /**
     * @return the minLoc
     */
    public Vector getMinLoc() {
        return minLoc;
    }

    /**
     * @param minLoc
     *            the minLoc to set
     */
    public void setMinLoc(Vector minLoc) {
        this.minLoc = minLoc;
    }

    /**
     * @return the maxLoc
     */
    public Vector getMaxLoc() {
        return maxLoc;
    }

    /**
     * @param maxLoc
     *            the maxLoc to set
     */
    public void setMaxLoc(Vector maxLoc) {
        this.maxLoc = maxLoc;
    }

    /**
     * @return the minRot
     */
    public Vector getMinRot() {
        return minRot;
    }

    /**
     * @param minRot
     *            the minRot to set
     */
    public void setMinRot(Vector minRot) {
        this.minRot = minRot;
    }

    /**
     * @return the maxRot
     */
    public Vector getMaxRot() {
        return maxRot;
    }

    /**
     * @param maxRot
     *            the maxRot to set
     */
    public void setMaxRot(Vector maxRot) {
        this.maxRot = maxRot;
    }

    /**
     * @return the springConst
     */
    public Vector getSpringConst() {
        return springConst;
    }

    /**
     * @param springConst
     *            the springConst to set
     */
    public void setSpringConst(Vector springConst) {
        this.springConst = springConst;
    }

    /**
     * @return the springRotConst
     */
    public Vector getSpringRotConst() {
        return springRotConst;
    }

    /**
     * @param springRotConst
     *            the springRotConst to set
     */
    public void setSpringRotConst(Vector springRotConst) {
        this.springRotConst = springRotConst;
    }
}
