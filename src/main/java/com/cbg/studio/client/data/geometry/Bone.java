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

public class Bone implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Bone parent;
    private Bone child;
    private int type;
    private Bone target;

    private Vector3f position;

    /*
     * @Override public String toString() { StringBuilder b = new
     * StringBuilder();
     * 
     * String parentName = this.parent != null ? this.parent.getName() : "null";
     * String childName = this.parent != null ? this.parent.getName() : "null";
     * String targetName = this.parent != null ? this.parent.getName() : "null";
     * 
     * b.append("{"); b.append(StringUtil.jsonParamater("name",
     * this.name)).append(",") .append(StringUtil.jsonParamater("parentBone",
     * parentName)) .append(",") .append(StringUtil.jsonParamater("childBone",
     * childName)) .append(",type:").append(this.type).append(",")
     * .append(StringUtil.jsonParamater("targetBone", targetName)) .append(",")
     * .append(StringUtil.jsonParamater("position", this.position));
     * b.append("}");
     * 
     * return b.toString(); }
     */

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
     * @return the parent
     */
    public Bone getParent() {
        return parent;
    }

    /**
     * @param parent
     *            the parent to set
     */
    public void setParent(Bone parent) {
        this.parent = parent;
    }

    /**
     * @return the child
     */
    public Bone getChild() {
        return child;
    }

    /**
     * @param child
     *            the child to set
     */
    public void setChild(Bone child) {
        this.child = child;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the target
     */
    public Bone getTarget() {
        return target;
    }

    /**
     * @param target
     *            the target to set
     */
    public void setTarget(Bone target) {
        this.target = target;
    }

    /**
     * @return the position
     */
    public Vector3f getPosition() {
        return position;
    }

    /**
     * @param position
     *            the position to set
     */
    public void setPosition(Vector3f position) {
        this.position = position;
    }
}
