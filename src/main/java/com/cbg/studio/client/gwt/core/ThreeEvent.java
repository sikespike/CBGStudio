package com.cbg.studio.client.gwt.core;

import com.cbg.studio.client.gwt.js.core.Object3D;
import com.cbg.studio.client.gwt.js.scenes.Scene;
import com.google.gwt.core.client.JavaScriptObject;

public class ThreeEvent extends JavaScriptObject {
    protected ThreeEvent() {
    }

    public final native String getType()/*-{
                                        return this.type;
                                        }-*/;

    public final native Scene getScene()/*-{
                                        return this.scene;
                                        }-*/;

    public final native Object3D getObject()/*-{
                                            return this.object;
                                            }-*/;

}
