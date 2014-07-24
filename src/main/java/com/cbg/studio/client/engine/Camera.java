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
    private Vector3f lookFrom;
    private Vector3f lookAt;

    public FloatMatrix getPerspectiveMatrix() {
        Vector3f direction = MathUtil
                .subtractVector(this.lookAt, this.lookFrom);

        FloatMatrix perspectiveMatrix = MathUtil.createPerspectiveMatrix(45,
                1.0f, 0.1f, 100);
        FloatMatrix translationMatrix = MathUtil
                .createTranslationMatrix(this.lookFrom);
        FloatMatrix rotationMatrix = MathUtil.createRotationMatrix(direction);
        FloatMatrix resultingMatrix = perspectiveMatrix.multiply(
                translationMatrix).multiply(rotationMatrix);
        
        return perspectiveMatrix;
    }

    public Vector3f getLookFrom() {
        return lookFrom;
    }


    public void setLookFrom(Vector3f lookFrom) {
        this.lookFrom = lookFrom;
    }

    public Vector3f getLookAt() {
        return lookAt;
    }

    public void setLookAt(Vector3f lookAt) {
        this.lookAt = lookAt;
    }
}
