/**
 * 
 */
package com.cbg.studio.server.domain.geometry;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cbg.studio.client.util.StringUtil;

/**
 * @author Siebe
 * 
 */
public class Motion implements Serializable{
    private static final long serialVersionUID = 1L;
    private Bone bone;
    private Bone targetBone;
    private int links;
    private int iteration;
    private float maxAngle;
    private List<Bone> childBones;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        b.append("{");
        b.append(StringUtil.jsonParamater("bone", this.bone.getName()))
                .append(",").append(StringUtil.jsonParamater("targetBone", this.targetBone.getName()))
                .append(",links:").append(this.links).append(",iteration:")
                .append(this.iteration).append(",maxAngle:")
                .append(this.maxAngle).append(",");

        List<String> boneNames = new ArrayList<String>();

        for (int x = 0; x < childBones.size(); x++) {
            boneNames.add(childBones.get(x).getName());
        }

        b.append(StringUtil.jsonParamater("childBones", boneNames));
        b.append("}");

        return b.toString();
    }

    @SuppressWarnings("all")
    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        this.bone = (Bone)stream.readObject();
        this.targetBone = (Bone)stream.readObject();
        this.links = stream.readInt();
        this.iteration = stream.readInt();
        this.maxAngle = stream.readFloat();
        this.childBones = (List<Bone>)stream.readObject();
    }

    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        stream.writeObject(this.bone);
        stream.writeObject(this.targetBone);
        stream.writeInt(this.links);
        stream.writeInt(this.iteration);
        stream.writeFloat(this.maxAngle);
        stream.writeObject(this.childBones);
    }
    
    /**
     * @return the bone
     */
    public Bone getBone() {
        return bone;
    }

    /**
     * @param bone
     *            the bone to set
     */
    public void setBone(Bone bone) {
        this.bone = bone;
    }

    /**
     * @return the targetBone
     */
    public Bone getTargetBone() {
        return targetBone;
    }

    /**
     * @param targetBone
     *            the targetBone to set
     */
    public void setTargetBone(Bone targetBone) {
        this.targetBone = targetBone;
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

    /**
     * @return the childBones
     */
    public List<Bone> getChildBones() {
        return childBones;
    }

    /**
     * @param childBones
     *            the childBones to set
     */
    public void setChildBones(List<Bone> childBones) {
        this.childBones = childBones;
    }
}
