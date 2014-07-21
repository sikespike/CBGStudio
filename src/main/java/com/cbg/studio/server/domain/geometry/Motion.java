/**
 * 
 */
package com.cbg.studio.server.domain.geometry;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * @author Siebe
 * 
 */
public class Motion implements Serializable{
    private static final long serialVersionUID = 1L;
    private String boneName;
    private String targetBoneName;
    private int links;
    private int iteration;
    private float maxAngle;
    private List<String> childBoneNames;

    @SuppressWarnings("all")
    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        this.boneName = (String)stream.readObject();
        this.targetBoneName = (String)stream.readObject();
        this.links = stream.readInt();
        this.iteration = stream.readInt();
        this.maxAngle = stream.readFloat();
        this.childBoneNames = (List<String>)stream.readObject();
    }

    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        stream.writeObject(this.boneName);
        stream.writeObject(this.targetBoneName);
        stream.writeInt(this.links);
        stream.writeInt(this.iteration);
        stream.writeFloat(this.maxAngle);
        stream.writeObject(this.childBoneNames);
    }
    
    public String getBoneName() {
        return boneName;
    }

    public void setBoneName(String boneName) {
        this.boneName = boneName;
    }

    public String getTargetBoneName() {
        return targetBoneName;
    }

    public void setTargetBoneName(String targetBoneName) {
        this.targetBoneName = targetBoneName;
    }

    public List<String> getChildBoneNames() {
        return childBoneNames;
    }

    public void setChildBoneNames(List<String> childBoneNames) {
        this.childBoneNames = childBoneNames;
    }

    /**
     * @return the links
     */
    public int getLinks() {
        return links;
    }

    /**
     * @param links
     *            the links to set
     */
    public void setLinks(int links) {
        this.links = links;
    }

    /**
     * @return the iteration
     */
    public int getIteration() {
        return iteration;
    }

    /**
     * @param iteration
     *            the iteration to set
     */
    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    /**
     * @return the maxAngle
     */
    public float getMaxAngle() {
        return maxAngle;
    }

    /**
     * @param maxAngle
     *            the maxAngle to set
     */
    public void setMaxAngle(float maxAngle) {
        this.maxAngle = maxAngle;
    }
    
    
}
