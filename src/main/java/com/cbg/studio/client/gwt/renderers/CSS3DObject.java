package com.cbg.studio.client.gwt.renderers;

import com.cbg.studio.client.gwt.js.core.Object3D;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Element;

public class CSS3DObject extends Object3D {
    protected CSS3DObject() {
    }

    /*
     * need CSS3DRenderer.js
     */
    public static native final CSS3DObject createObject(Element element)/*-{
                                                                        return new $wnd.THREE.CSS3DObject( element );
                                                                        }-*/;

    public static native final CSS3DObject createObject(CanvasElement element)/*-{
                                                                              return new $wnd.THREE.CSS3DObject( element );
                                                                              }-*/;

}
