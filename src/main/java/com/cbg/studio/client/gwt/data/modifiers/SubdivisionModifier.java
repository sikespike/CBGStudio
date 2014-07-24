package com.cbg.studio.client.gwt.data.modifiers;

import com.cbg.studio.client.gwt.js.core.Geometry;
import com.google.gwt.core.client.JavaScriptObject;

public class SubdivisionModifier extends JavaScriptObject {
    protected SubdivisionModifier() {
    }

    public native final void modify(Geometry geo)/*-{
                                                 this.modify(geo);
                                                 }-*/;
}
