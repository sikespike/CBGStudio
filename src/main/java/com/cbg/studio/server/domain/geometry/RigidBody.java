package com.cbg.studio.server.domain.geometry;

import java.io.IOException;
import java.io.Serializable;

public class RigidBody implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String boneName;
    private int collisionGroupId;
    private int collisionMaskId;
    private String shape;

    private Vector size;
    private Vector position;
    private Vector rotation;

    private float mass;
    private float velocityAtt;
    private float rotationAtt;
    private float bounce;
    private float friction;

    private String mode;

    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        this.name = (String) stream.readObject();
        this.boneName = (String) stream.readObject();
        this.collisionGroupId = stream.readInt();
        this.collisionMaskId = stream.readInt();
        this.shape = (String) stream.readObject();
        this.size = (Vector) stream.readObject();
        this.position = (Vector) stream.readObject();
        this.rotation = (Vector) stream.readObject();
        this.mass = stream.readFloat();
        this.velocityAtt = stream.readFloat();
        this.rotationAtt = stream.readFloat();
        this.bounce = stream.readFloat();
        this.friction = stream.readFloat();
        this.mode = (String) stream.readObject();

    }

    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        stream.writeObject(this.name);
        stream.writeObject(this.boneName);
        stream.writeObject(this.collisionGroupId);
        stream.writeObject(this.collisionMaskId);
        stream.writeObject(this.shape);
        stream.writeObject(this.size);
        stream.writeObject(this.position);
        stream.writeObject(this.rotation);
        stream.writeFloat(this.mass);
        stream.writeFloat(this.velocityAtt);
        stream.writeFloat(this.rotationAtt);
        stream.writeFloat(this.bounce);
        stream.writeFloat(this.friction);
        stream.writeObject(this.mode);
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

    public String getBoneName() {
        return boneName;
    }

    public void setBoneName(String boneName) {
        this.boneName = boneName;
    }

    /**
     * @return the collisionGroupId
     */
    public int getCollisionGroupId() {
        return collisionGroupId;
    }

    /**
     * @param collisionGroupId
     *            the collisionGroupId to set
     */
    public void setCollisionGroupId(int collisionGroupId) {
        this.collisionGroupId = collisionGroupId;
    }

    /**
     * @return the collisionMaskId
     */
    public int getCollisionMaskId() {
        return collisionMaskId;
    }

    /**
     * @param collisionMaskId
     *            the collisionMaskId to set
     */
    public void setCollisionMaskId(int collisionMaskId) {
        this.collisionMaskId = collisionMaskId;
    }

    /**
     * @return the shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * @param shape
     *            the shape to set
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * @return the size
     */
    public Vector getSize() {
        return size;
    }

    /**
     * @param size
     *            the size to set
     */
    public void setSize(Vector size) {
        this.size = size;
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
     * @return the mass
     */
    public float getMass() {
        return mass;
    }

    /**
     * @param mass
     *            the mass to set
     */
    public void setMass(float mass) {
        this.mass = mass;
    }

    /**
     * @return the velocityAtt
     */
    public float getVelocityAtt() {
        return velocityAtt;
    }

    /**
     * @param velocityAtt
     *            the velocityAtt to set
     */
    public void setVelocityAtt(float velocityAtt) {
        this.velocityAtt = velocityAtt;
    }

    /**
     * @return the rotationAtt
     */
    public float getRotationAtt() {
        return rotationAtt;
    }

    /**
     * @param rotationAtt
     *            the rotationAtt to set
     */
    public void setRotationAtt(float rotationAtt) {
        this.rotationAtt = rotationAtt;
    }

    /**
     * @return the bounce
     */
    public float getBounce() {
        return bounce;
    }

    /**
     * @param bounce
     *            the bounce to set
     */
    public void setBounce(float bounce) {
        this.bounce = bounce;
    }

    /**
     * @return the friction
     */
    public float getFriction() {
        return friction;
    }

    /**
     * @param friction
     *            the friction to set
     */
    public void setFriction(float friction) {
        this.friction = friction;
    }

    /**
     * @return the mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * @param mode
     *            the mode to set
     */
    public void setMode(String mode) {
        this.mode = mode;
    }
}
