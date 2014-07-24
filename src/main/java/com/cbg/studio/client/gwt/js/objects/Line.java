package com.cbg.studio.client.gwt.js.objects;

import com.cbg.studio.client.gwt.js.core.Geometry;
import com.cbg.studio.client.gwt.js.core.Object3D;
import com.cbg.studio.client.gwt.js.materials.Material;

public class Line extends Object3D {
    public static final int LineStrip = 0;
    public static final int LinePieces = 1;

    protected Line() {
    }

    public final native Geometry getGeometry()/*-{
                                              return this.geometry;
                                              }-*/;

    public final native void setGeometry(Geometry geometry)/*-{
                                                           this.geometry = geometry;
                                                           }-*/;

    public final native Material getMaterial()/*-{
                                              return this.material;
                                              }-*/;

    public final native void setMaterial(Material material)/*-{
                                                           this.material = material;
                                                           }-*/;

    public final native int getType()/*-{
                                     return this.type;
                                     }-*/;

    public final native void setType(int type)/*-{
                                              this.type = type;
                                              }-*/;

    public final native Line clone(Line object)/*-{
                                               return this.clone(object);
                                               }-*/;

}
