/**   
 * Copyright 2009-2010 Sönke Sothmann, Steffen Schäfer and others
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cbg.studio.client.engine.util.math;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a vector with two elements.
 * 
 * @author Sönke Sothmann
 * @author Steffen Schäfer
 * 
 */
public class Vector2f implements Vectorf, Serializable {
    private static final long serialVersionUID = 1L;
    private float u;
    private float v;

    public Vector2f() {
        this.u = 0.0f;
        this.v = 0.0f;
    }

    /**
     * Constructs a new instance of the Vector2f with the given coordinates to
     * set.
     * 
     * @param u
     * @param v
     */
    public Vector2f(float u, float v) {
        super();
        this.u = u;
        this.v = v;
    }

    public Vector2f(float[] vector) {
        super();
        this.u = vector[0];
        this.v = vector[1];
    }

    /**
     * Returns the u coordinate.
     * 
     * @return the u coordinate
     */
    public float getU() {
        return u;
    }

    /**
     * Sets the u coordinate.
     * 
     * @param u
     *            the u coordinate to set
     */
    public void setU(float u) {
        this.u = u;
    }

    /**
     * Returns the v coordinate.
     * 
     * @return the v coordinate
     */
    public float getV() {
        return v;
    }

    /**
     * Sets the v coordinate.
     * 
     * @param v
     *            the v coordinate to set
     */
    public void setV(float v) {
        this.v = v;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.googlecode.gwtgl.example.client.util.math.Vector#multiply(float)
     */
    @Override
    public Vectorf multiply(float scalar) {
        return new Vector2f(this.u * scalar, this.v * scalar);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.googlecode.gwtgl.example.client.util.math.Vector#length()
     */
    @Override
    public float length() {
        return (float) Math.sqrt(this.u * this.u + this.v * this.v);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.googlecode.gwtgl.example.client.util.math.Vector#toUnitVector()
     */
    @Override
    public Vectorf toUnitVector() {
        float length = length();
        return new Vector2f(this.u / length, this.v / length);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.googlecode.gwtgl.example.client.util.math.Vector#toArray()
     */
    @Override
    public float[] toArray() {
        return new float[] { this.u, this.v };
    }

    @Override
    public List<Float> toList() {
        List<Float> list = new ArrayList<Float>();

        float[] coords = this.toArray();

        for (int x = 0; x < coords.length; x++) {
            list.add(new Float(coords[x]));
        }

        return list;
    }
}
