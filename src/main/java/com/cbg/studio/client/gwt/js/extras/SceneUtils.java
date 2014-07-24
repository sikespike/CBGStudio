package com.cbg.studio.client.gwt.js.extras;

import com.cbg.studio.client.gwt.js.THREE;
import com.cbg.studio.client.gwt.js.core.Geometry;
import com.cbg.studio.client.gwt.js.core.Object3D;
import com.cbg.studio.client.gwt.js.materials.Material;
import com.cbg.studio.client.gwt.js.scenes.Scene;
import com.google.gwt.core.client.JsArray;

public class SceneUtils {

    public static final native void detach(Object3D child, Object3D parent,
            Scene scene)/*-{
                        $wnd.THREE.SceneUtils.detach(child,parent,scene);
                        }-*/;

    public static final native void attach(Object3D child, Object3D scene,
            Scene parent)/*-{
                         $wnd.THREE.SceneUtils.attach(child,scene,parent);
                         }-*/;

    public static native final Object3D createMultiMaterialObject(
            Geometry geometry, JsArray<Material> materials)/*-{
                                                           return $wnd.THREE.SceneUtils.createMultiMaterialObject(geometry,materials);
                                                           }-*/;

    public static final Object3D createMultiMaterialObject(Geometry geometry,
            Iterable<Material> materials) {
        @SuppressWarnings("unchecked")
        JsArray<Material> jsmaterials = THREE.createJsArray();
        for (Material m : materials) {
            jsmaterials.push(m);
        }
        return createMultiMaterialObject(geometry, jsmaterials);
    }

    /**
     * @deprecated
     * @param child
     * @param scene
     * @param parent
     */
    @Deprecated
    public static native final void detach(Object3D child, Scene scene,
            Object3D parent)/*-{
                            return $wnd.THREE.SceneUtils.detach(child,parent,scene);
                            }-*/;

    /**
     * @deprecated
     * @param child
     * @param scene
     * @param parent
     */
    @Deprecated
    public static native final void attach(Object3D child, Scene scene,
            Object3D parent)/*-{
                            return $wnd.THREE.SceneUtils.attach(child,parent,scene);
                            }-*/;
}
