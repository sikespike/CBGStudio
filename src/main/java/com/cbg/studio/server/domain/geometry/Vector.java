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
public class Vector implements Serializable{
    private static final long serialVersionUID = 1L;
    private float x;
    private float y;
    private float z;
    private float a;

    public Vector(){
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.a = 0.0f;
    }
    
    public Vector(float x, float y, float z, float a){
        this.x = x;
        this.y = y;
        this.z = z;
        this.a = a;
    }
    
    public Vector(float[] vector){
        if(vector.length == 4){
            this.x = vector[0];
            this.y = vector[1];
            this.z = vector[2];
            this.a = vector[3];
        } else {
            throw new RuntimeException("Vector provided is of size:"+vector.length);
        }
    }
    
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        b.append("{x:").append(x).append(",y:").append(y).append(",z:")
                .append(z).append(",a:").append(a).append("}");

        return b.toString();
    }
    
    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        this.x = stream.readFloat();
        this.y = stream.readFloat();
        this.z = stream.readFloat();
        this.a = stream.readFloat();
    }

    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        stream.writeFloat(this.x);
        stream.writeFloat(this.y);
        stream.writeFloat(this.z);
        stream.writeFloat(this.a);
    }
    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x
     *            the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y
     *            the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the z
     */
    public float getZ() {
        return z;
    }

    /**
     * @param z
     *            the z to set
     */
    public void setZ(float z) {
        this.z = z;
    }

    /**
     * @return the a
     */
    public float getA() {
        return a;
    }

    /**
     * @param a
     *            the a to set
     */
    public void setA(float a) {
        this.a = a;
    }
}
