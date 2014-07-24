package com.cbg.studio.client.gwt.js.math;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @deprecated totall removed at r49
 * @author aki
 * 
 */
@Deprecated
public class Vertex extends JavaScriptObject {
    protected Vertex() {
    }

    public final native Vector3 getPosition()/*-{
                                             return this.position;
                                             }-*/;

}
