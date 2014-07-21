/**
 * 
 */
package com.cbg.studio.server.domain.geometry;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author Siebe
 * 
 */

public class Bone implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String parentName;
    private String childName;
    private int type;
    private String targetName;

    private Vector position;
    
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
        
        stream.writeObject(this.name);
        stream.writeObject(this.parentName);
        stream.writeObject(this.childName);
        stream.writeObject(this.targetName);
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
