/**
 * 
 */
package com.cbg.studio.client.engine.util.math;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * @author Xif
 * 
 */
public class MathUtil {
    /**
     * 
     * @param fieldOfViewVertical
     *            Vertikaler Öffnungswinkel in Grad
     * @param aspectRatio
     *            Verhältnis von Höhe zu Breite
     * @param minimumClearance
     *            Mindestabstand sichtbarer Punkte
     * @param maximumClearance
     *            Höchstabstand sichtbarer Punkte
     * @return the created perspective matrix
     */
    public static FloatMatrix4x4 createPerspectiveMatrix(
            int fieldOfViewVertical, float aspectRatio, float minimumClearance,
            float maximumClearance) {
            float top    = minimumClearance * (float)Math.tan(fieldOfViewVertical * Math.PI / 360.0);
            float bottom = -top;
            float left   = bottom * aspectRatio;
            float right  = top * aspectRatio;

            float X = 2*minimumClearance/(right-left);
            float Y = 2*minimumClearance/(top-bottom);
            float A = (right+left)/(right-left);
            float B = (top+bottom)/(top-bottom);
            float C = -(maximumClearance+minimumClearance)/(maximumClearance-minimumClearance);
            float D = -2*maximumClearance*minimumClearance/(maximumClearance-minimumClearance);

            float[] v1 = new float[]{X, 0.0f, A, 0.0f};
            float[] v2 = new float[]{0.0f, Y, B, 0.0f};
            float[] v3 = new float[]{0.0f, 0.0f, C, -1.0f};
            float[] v4 = new float[]{0.0f, 0.0f, D, 0.0f};
            
        return new FloatMatrix4x4(new float[][] {v1,v2,v3,v4});
    };

    /**
     * Creates a rotation matrix.
     * 
     * @param angleX
     *            the angle in degrees for the rotation around the x axis
     * @param angleY
     *            the angle in degrees for the rotation around the y axis
     * @param angleZ
     *            the angle in degrees for the rotation around the z axis
     * @return the created matrix
     */
    public static FloatMatrix4x4 createRotationMatrix(float angleX, float angleY,
            float angleZ) {
        return createRotationMatrixX(angleX).multiply(
                createRotationMatrixY(angleY)).multiply(
                createRotationMatrixZ(angleZ));
    }

    public static FloatMatrix4x4 createRotationMatrix(Vector3f vector) {
        Vector3f unitVector = (Vector3f)vector.toUnitVector();
        
        return createRotationMatrix(unitVector.getX(), unitVector.getY(), unitVector.getY());
    }
    
    private static FloatMatrix4x4 createRotationMatrixX(float angle) {
        double angleInRad = angle * (Math.PI / 180.0);

        // 1 0 0 0
        //
        // 0 cos(q) sin(q) 0
        //
        // 0 -sin(q) cos(q) 0
        //
        // 0 0 0 1

        return new FloatMatrix4x4(new float[][] {
                new float[] { 1, 0, 0, 0 },
                new float[] { 0, (float) cos(angleInRad),
                        (float) sin(angleInRad), 0 },
                new float[] { 0, (float) -sin(angleInRad),
                        (float) cos(angleInRad), 0 },
                new float[] { 0, 0, 0, 1 } });
    }

    private static FloatMatrix4x4 createRotationMatrixY(float angle) {
        double angleInRad = angle * (Math.PI / 180.0);

        // cos(a) 0 -sin(a) 0
        //
        // 0 1 0 0
        //
        // sin(a) 0 cos(a) 0
        //
        // 0 0 0 1

        return new FloatMatrix4x4(new float[][] {
                new float[] { (float) cos(angleInRad), 0,
                        (float) -sin(angleInRad), 0 },
                new float[] { 0, 1, 0, 0 },
                new float[] { (float) sin(angleInRad), 0.0f,
                        (float) cos(angleInRad), 0.0f },
                new float[] { 0, 0, 0, 1 } });
    }

    private static FloatMatrix4x4 createRotationMatrixZ(float angle) {
        double angleInRad = angle * (Math.PI / 180.0);

        // cos(a) sin(a) 0 0
        //
        // -sin(a) cos(a) 0 0
        //
        // 0 0 1 0
        //
        // 0 0 0 1

        return new FloatMatrix4x4(new float[][] {
                new float[] { (float) cos(angleInRad), (float) sin(angleInRad),
                        0, 0 },
                new float[] { (float) -sin(angleInRad),
                        (float) cos(angleInRad), 0, 0 },
                new float[] { 0, 0, 1, 0 }, new float[] { 0, 0, 0, 1 } });
    }

    /**
     * Creates a translation matrix.
     * 
     * @param translateX
     *            the amount to translate parallel to the x axis
     * @param translateY
     *            the amount to translate parallel to the y axis
     * @param translateZ
     *            the amount to translate parallel to the z axis
     * @return the created matrix
     */
    public static FloatMatrix4x4 createTranslationMatrix(float translateX,
            float translateY, float translateZ) {
        return new FloatMatrix4x4(
                new float[][] { new float[] { 1, 0, 0, translateX },
                        new float[] { 0, 1, 0, translateY },
                        new float[] { 0, 0, 1, translateZ },
                        new float[] { 0, 0, 0, 1 } });
    }
    
    public static FloatMatrix4x4 createTranslationMatrix(Vector3f vector) {
        return createTranslationMatrix(vector.getX(), vector.getY(), vector.getZ());
    }
    
    public static Vector3f subtractVector(Vector3f v1, Vector3f v2){
        float[] vectorArray = new float[3];
        
        vectorArray[0] = v2.getX() - v1.getX();
        vectorArray[1] = v2.getY() - v1.getY();
        vectorArray[2] = v2.getZ() - v1.getZ();
        
        Vector3f vector = new Vector3f(vectorArray);
        
        return vector;
    }
}
