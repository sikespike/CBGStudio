package com.cbg.studio.client.gwt.core;

import com.cbg.studio.client.gwt.js.math.Vector3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * i'm not sure,what is it.
 * 
 * @author aki
 * 
 */
public class MorphTarget extends JavaScriptObject {
    protected MorphTarget() {
    }

    public final native JsArray<Vector3> getVertices()/*-{
                                                      return this.vertices;
                                                      }-*/;
}
