package com.cbg.studio.client.gwt.js.renderers;

import com.google.gwt.core.client.JavaScriptObject;

public class CanvasRenderer extends WebGLRenderer {
    public final native JavaScriptObject getParameters()/*-{
                                                        return this.parameters;
                                                        }-*/;

    // public final native Element getDomElement()/*-{
    // return this.domElement;
    // }-*/;

    public final native boolean isSortElements()/*-{
                                                return this.sortElements;
                                                }-*/;

    public final native void setSortElements(boolean sortElements)/*-{
                                                                  this.sortElements = sortElements;
                                                                  }-*/;
}
