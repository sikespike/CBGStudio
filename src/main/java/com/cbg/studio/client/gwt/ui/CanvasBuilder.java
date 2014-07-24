package com.cbg.studio.client.gwt.ui;

import com.cbg.studio.client.gwt.js.THREE;
import com.cbg.studio.client.gwt.js.renderers.WebGLRenderer;

//TODO move somewhere not here
public class CanvasBuilder extends WebGLBuilder {

    WebGLRenderer createRenderer() {
        return THREE.CanvasRenderer();
    }
}
