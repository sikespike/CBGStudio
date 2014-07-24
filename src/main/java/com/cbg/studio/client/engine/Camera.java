/**
 * 
 */
package com.cbg.studio.client.engine;

import com.cbg.studio.client.engine.util.math.FloatMatrix;
import com.cbg.studio.client.engine.util.math.MathUtil;
import com.cbg.studio.client.engine.util.math.Vector3f;

/**
 * @author Xif
 * 
 */
public class Camera {
    private Vector3f position;
    private Vector3f lookAt;

    private Vector3f getDirection() {
        Vector3f direction = MathUtil.subtractVector(this.lookAt, this.position);

        float distance = direction.length();
        
        /*FloatMatrix perspectiveMatrix = MathUtil.createPerspectiveMatrix(45, 1.0f, 0.1f, distance);
        FloatMatrix translationMatrix = MathUtil.createTranslationMatrix(this.position);
        FloatMatrix rotationMatrix = MathUtil.createRotationMatrix(angleX, angleY, angleZ);
        FloatMatrix resultingMatrix = perspectiveMatrix.multiply(translationMatrix).multiply(rotationMatrix);*/
        
        return direction;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Vector3f getLookAt() {
        return lookAt;
    }

    public void setLookAt(Vector3f lookAt) {
        this.lookAt = lookAt;
    }
}
