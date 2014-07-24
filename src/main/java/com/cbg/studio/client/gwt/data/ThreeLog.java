package com.cbg.studio.client.gwt.data;

import com.cbg.studio.client.gwt.data.utils.GWTThreeUtils;
import com.cbg.studio.client.gwt.js.THREE;
import com.cbg.studio.client.gwt.js.math.Matrix4;
import com.cbg.studio.client.gwt.js.math.Vector3;
import com.google.gwt.core.client.JsArrayNumber;

public class ThreeLog {

    public static String getAngle(Matrix4 mx) {
        if (mx == null) {
            return "Null";
        }
        Vector3 vec = THREE.Vector3();
        vec.getRotationFromMatrix(mx);
        return getAngle(vec);
    }

    public static String getAngle(Vector3 vec) {
        if (vec == null) {
            return "Null";
        }
        String ret = "x:" + Math.toDegrees(vec.getX());
        ret += ",y:" + Math.toDegrees(vec.getY());
        ret += ",z:" + Math.toDegrees(vec.getZ());
        return ret;
    }

    public static String getAsDegree(Vector3 vec) {
        return get(GWTThreeUtils.radiantToDegree(vec));
    }

    public static String get(Vector3 vec) {
        if (vec == null) {
            return "Null";
        }
        String ret = "x:" + vec.getX();
        ret += ",y:" + vec.getY();
        ret += ",z:" + vec.getZ();
        return ret;
    }

    public static String get(JsArrayNumber numbers) {
        if (numbers == null) {
            return "Null";
        }

        String ret = "";
        for (int i = 0; i < numbers.length(); i++) {
            ret += numbers.get(i) + ",";
        }
        return ret;
    }
}
