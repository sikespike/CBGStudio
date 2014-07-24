package com.cbg.studio.client.gwt.js.lights;

public class AmbientLight extends Light {
    protected AmbientLight() {
    }

    public final native AmbientLight clone()/*-{
                                            return this.clone();
                                            }-*/;
}
