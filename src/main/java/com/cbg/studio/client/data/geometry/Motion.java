/**
 * 
 */
package com.cbg.studio.client.data.geometry;

import java.io.Serializable;
import java.util.List;

/**
 * @author Siebe
 * 
 */
public class Motion implements Serializable {
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
    /*
     * @Override public String toString() { StringBuilder b = new
     * StringBuilder();
     * 
     * b.append("{"); b.append(StringUtil.jsonParamater("bone",
     * this.bone.getName()))
     * .append(",").append(StringUtil.jsonParamater("targetBone",
     * this.targetBone.getName()))
     * .append(",links:").append(this.links).append(",iteration:")
     * .append(this.iteration).append(",maxAngle:")
     * .append(this.maxAngle).append(",");
     * 
     * List<String> boneNames = new ArrayList<String>();
     * 
     * for (int x = 0; x < childBones.size(); x++) {
     * boneNames.add(childBones.get(x).getName()); }
     * 
     * b.append(StringUtil.jsonParamater("childBones", boneNames));
     * b.append("}");
     * 
     * return b.toString(); }
     */

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
