package com.cbg.studio.client.gwt.renderers;

import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Element;

public class CSS3DSprite extends CSS3DObject {
    protected CSS3DSprite() {
    }

    public static native final CSS3DObject createSprite(Element element)/*-{
                                                                        return new $wnd.THREE.CSS3DSprite( element );
                                                                        }-*/;

    public static native final CSS3DObject createSprite(CanvasElement element)/*-{
                                                                              return new $wnd.THREE.CSS3DSprite( element );
                                                                              }-*/;
}
