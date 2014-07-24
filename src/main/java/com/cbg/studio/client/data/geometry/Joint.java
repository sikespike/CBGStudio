/**
 * 
 */
package com.cbg.studio.client.data.geometry;

import java.io.Serializable;

import com.cbg.studio.client.engine.util.math.Vector3f;

/**
 * @author Siebe
 * 
 */
public class Joint implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private RigidBody sourceRigidBody;
    private RigidBody destRigidBody;
    private Vector3f location;
    private Vector3f rotation;
    private Vector3f minLoc;
    private Vector3f maxLoc;
    private Vector3f minRot;
    private Vector3f maxRot;
    private Vector3f springConst;
    private Vector3f springRotConst;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    /*@Override
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
    }*/

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
    public Vector3f getLocation() {
        return location;
    }

    /**
     * @param location
     *            the location to set
     */
    public void setLocation(Vector3f location) {
        this.location = location;
    }

    /**
     * @return the rotation
     */
    public Vector3f getRotation() {
        return rotation;
    }

    /**
     * @param rotation
     *            the rotation to set
     */
    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }

    /**
     * @return the minLoc
     */
    public Vector3f getMinLoc() {
        return minLoc;
    }

    /**
     * @param minLoc
     *            the minLoc to set
     */
    public void setMinLoc(Vector3f minLoc) {
        this.minLoc = minLoc;
    }

    /**
     * @return the maxLoc
     */
    public Vector3f getMaxLoc() {
        return maxLoc;
    }

    /**
     * @param maxLoc
     *            the maxLoc to set
     */
    public void setMaxLoc(Vector3f maxLoc) {
        this.maxLoc = maxLoc;
    }

    /**
     * @return the minRot
     */
    public Vector3f getMinRot() {
        return minRot;
    }

    /**
     * @param minRot
     *            the minRot to set
     */
    public void setMinRot(Vector3f minRot) {
        this.minRot = minRot;
    }

    /**
     * @return the maxRot
     */
    public Vector3f getMaxRot() {
        return maxRot;
    }

    /**
     * @param maxRot
     *            the maxRot to set
     */
    public void setMaxRot(Vector3f maxRot) {
        this.maxRot = maxRot;
    }

    /**
     * @return the springConst
     */
    public Vector3f getSpringConst() {
        return springConst;
    }

    /**
     * @param springConst
     *            the springConst to set
     */
    public void setSpringConst(Vector3f springConst) {
        this.springConst = springConst;
    }

    /**
     * @return the springRotConst
     */
    public Vector3f getSpringRotConst() {
        return springRotConst;
    }

    /**
     * @param springRotConst
     *            the springRotConst to set
     */
    public void setSpringRotConst(Vector3f springRotConst) {
        this.springRotConst = springRotConst;
    }
}
