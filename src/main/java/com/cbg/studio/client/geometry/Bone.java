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

public class Bone implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Bone parent;
    private String parentName;
    private Bone child;
    private String childName;
    private int type;
    private Bone target;
    private String targetName;

    private Vector position;

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        String parentName = this.parent != null ? this.parent.getName()
                : "null";
        String childName = this.parent != null ? this.parent.getName() : "null";
        String targetName = this.parent != null ? this.parent.getName()
                : "null";

        b.append("{");
        b.append(StringUtil.jsonParamater("name", this.name)).append(",")
                .append(StringUtil.jsonParamater("parentBone", parentName))
                .append(",")
                .append(StringUtil.jsonParamater("childBone", childName))
                .append(",type:").append(this.type).append(",")
                .append(StringUtil.jsonParamater("targetBone", targetName))
                .append(",")
                .append(StringUtil.jsonParamater("position", this.position));
        b.append("}");

        return b.toString();
    }
    
    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        this.name = (String)stream.readObject();
        this.parentName = (String)stream.readObject();
        this.childName = (String)stream.readObject();
        this.targetName = (String)stream.readObject();
        this.type = stream.readInt();
        this.position = (Vector)stream.readObject();

    }

    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        
        String parentName = this.parent != null ? this.parent.getName()
                : null;
        String childName = this.parent != null ? this.parent.getName() : null;
        String targetName = this.parent != null ? this.parent.getName()
                : null;
        
        stream.writeObject(this.name);
        stream.writeObject(parentName);
        stream.writeObject(childName);
        stream.writeObject(targetName);
        stream.writeInt(this.type);
        stream.writeObject(this.position);
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
    public Vector getPosition() {
        return position;
    }

    /**
     * @param position
     *            the position to set
     */
    public void setPosition(Vector position) {
        this.position = position;
    }

    /**
     * @return the parentName
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * @param parentName the parentName to set
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /**
     * @return the childName
     */
    public String getChildName() {
        return childName;
    }

    /**
     * @param childName the childName to set
     */
    public void setChildName(String childName) {
        this.childName = childName;
    }

    /**
     * @return the targetName
     */
    public String getTargetName() {
        return targetName;
    }

    /**
     * @param targetName the targetName to set
     */
    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }
}
