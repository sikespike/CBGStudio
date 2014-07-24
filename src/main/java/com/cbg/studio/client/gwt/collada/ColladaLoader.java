package com.cbg.studio.client.gwt.collada;

import com.google.gwt.core.client.JavaScriptObject;

public class ColladaLoader extends JavaScriptObject {

    /*
     * dont workd on r46,only work on dev
     */
    protected ColladaLoader() {
    }

    public final native void load(String path, ColladaLoadHandler handler)/*-{
                                                                          this.load(path,function ( collada ) {
                                                                          handler.@com.akjava.gwt.three.client.examples.ColladaLoader$ColladaLoadHandler::colladaReady(Lcom/akjava/gwt/three/client/gwt/collada/ColladaData;)(collada);
                                                                          });
                                                                          
                                                                          }-*/;

    public static interface ColladaLoadHandler {
        public void colladaReady(ColladaData collada);
    }
}
