package com.cbg.studio.client.gwt.js.math;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @deprecated use Vector2
 * @author aki
 * 
 */
@Deprecated
public class UV extends JavaScriptObject {
    protected UV() {
    }

    public final native double getU()/*-{
                                     return this.u;
                                     }-*/;

    public final native double getV()/*-{
                                     return this.v;
                                     }-*/;

}
