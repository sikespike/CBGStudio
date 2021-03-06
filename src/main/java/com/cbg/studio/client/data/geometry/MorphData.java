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
public class MorphData implements Serializable {
    private static final long serialVersionUID = 1L;
    private int index;
    private Vector3f offset;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    /*
     * @Override public String toString() { StringBuilder b = new
     * StringBuilder();
     * 
     * b.append("{"); b.append("index:").append(this.index).append(",")
     * .append(StringUtil.jsonParamater("offset", this.offset)); b.append("}");
     * 
     * return b.toString(); }
     */

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index
     *            the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the offset
     */
    public Vector3f getOffset() {
        return offset;
    }

    /**
     * @param offset
     *            the offset to set
     */
    public void setOffset(Vector3f offset) {
        this.offset = offset;
    }
}
