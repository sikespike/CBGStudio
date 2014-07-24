package com.cbg.studio.client.gwt.data.utils;

import com.cbg.studio.client.gwt.animation.AnimationBone;
import com.cbg.studio.client.gwt.animation.AnimationData;
import com.cbg.studio.client.gwt.animation.AnimationHierarchyItem;
import com.cbg.studio.client.gwt.animation.AnimationKey;
import com.cbg.studio.client.gwt.js.THREE;
import com.cbg.studio.client.gwt.js.math.Vector3;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;

public class AnimationUtils {
    private AnimationUtils() {
    }

    public static AnimationData createAnimationData() {
        AnimationData data = (AnimationData) AnimationData.createObject();
        GWT.log("create:" + data);
        JsArray<AnimationHierarchyItem> array = (JsArray<AnimationHierarchyItem>) JsArray
                .createArray();
        data.setHierarchy(array);
        data.setJIT(0);
        return data;
    }

    public static AnimationHierarchyItem createAnimationHierarchyItem() {
        AnimationHierarchyItem data = (AnimationHierarchyItem) AnimationHierarchyItem
                .createObject();
        JsArray<AnimationKey> array = (JsArray<AnimationKey>) JsArray
                .createArray();
        data.setKeys(array);
        return data;
    }

    public static AnimationKey createAnimationKey() {
        AnimationKey data = (AnimationKey) AnimationKey.createObject();
        data.setScl(1, 1, 1);
        return data;
    }

    public static AnimationBone createAnimationBone() {
        AnimationBone data = (AnimationBone) AnimationBone.createObject();
        data.setScl(1, 1, 1);
        data.setRotq(0, 0, 0, 1);
        return data;
    }

    public static Vector3 getPosition(AnimationKey key) {
        return THREE.Vector3(key.getPos().get(0), key.getPos().get(1), key
                .getPos().get(2));
    }

    public static Vector3 getPosition(AnimationBone key) {
        return THREE.Vector3(key.getPos().get(0), key.getPos().get(1), key
                .getPos().get(2));
    }

}
