package com.cbg.studio.client.gwt.js.loaders;

import com.cbg.studio.client.gwt.js.core.Geometry;
import com.cbg.studio.client.gwt.js.materials.Material;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class JSONLoader extends Loader {

    protected JSONLoader() {
    }

    // show status not support
    public final void load(String path, JSONLoadHandler handler) {
        load(path, handler, null);
    }

    public final native void load(String path, JSONLoadHandler handler,
            String texturePath)/*-{
                               this.load(path,function ( geometry,materials ) {
                               handler.@com.cbg.studio.client.gwt.js.loaders.JSONLoader$JSONLoadHandler::loaded(Lcom/akjava/gwt/three/client/js/core/Geometry;Lcom/google/gwt/core/client/JsArray;)(geometry,materials);
                               },texturePath);
                               }-*/;

    public static interface JSONLoadHandler {
        public void loaded(Geometry geometry, JsArray<Material> materials);
    }

    // TODO implement class to easy access
    public final native JavaScriptObject parse(JavaScriptObject json,
            String texturePath)/*-{
                               return this.parse(json,texturePath);
                               }-*/;

    /** @deprecated don't work anymore */
    // public final native void createModel(JavaScriptObject
    // object,JSONLoadHandler handler,String texturepath)/*-{
    // this.createModel(object,function ( geometry ) {
    // handler.@com.cbg.studio.client.gwt.js.loaders.JSONLoader$JSONLoadHandler::loaded(Lcom/akjava/gwt/three/client/core/Geometry;)(geometry);
    // },texturepath);

    // }-*/;

}
