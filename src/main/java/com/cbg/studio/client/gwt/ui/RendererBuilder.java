package com.cbg.studio.client.gwt.ui;

import com.cbg.studio.client.gwt.js.renderers.WebGLRenderer;
import com.google.gwt.core.client.GWT;

//TODO move somewhere not here
public class RendererBuilder {

    public static WebGLRenderer createRenderer() {
        WebGLBuilder builder = GWT.create(WebGLBuilder.class);
        return builder.createRenderer();
    }
}
