package com.cbg.studio.client.data.geometry;

import java.io.Serializable;


public class Material implements Serializable{
    private static final long serialVersionUID = 1L;

    private Vector color;
    private Vector specLight;
    private Vector ambientLight;

    private String texture;

    /*@Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        b.append("{color:");
        b.append(color.toString()).append(",specLight:")
                .append(specLight.toString()).append(",ambientLight:")
                .append(ambientLight.toString()).append(",texture:")
                .append("\"" + texture + "\"").append("}");

        return b.toString();
    }*/
    
    /**
     * @return the color
     */
    public Vector getColor() {
        return color;
    }

    /**
     * @param color
     *            the color to set
     */
    public void setColor(Vector color) {
        this.color = color;
    }

    /**
     * @return the specLight
     */
    public Vector getSpecLight() {
        return specLight;
    }

    /**
     * @param specLight
     *            the specLight to set
     */
    public void setSpecLight(Vector specLight) {
        this.specLight = specLight;
    }

    /**
     * @return the ambientLight
     */
    public Vector getAmbientLight() {
        return ambientLight;
    }

    /**
     * @param ambientLight
     *            the ambientLight to set
     */
    public void setAmbientLight(Vector ambientLight) {
        this.ambientLight = ambientLight;
    }

    /**
     * @return the texture
     */
    public String getTexture() {
        return texture;
    }

    /**
     * @param texture
     *            the texture to set
     */
    public void setTexture(String texture) {
        this.texture = texture;
    }
}
