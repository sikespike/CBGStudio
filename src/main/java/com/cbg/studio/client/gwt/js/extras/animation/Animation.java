package com.cbg.studio.client.gwt.js.extras.animation;

import com.cbg.studio.client.gwt.animation.AnimationData;
import com.cbg.studio.client.gwt.animation.AnimationHierarchyItem;
import com.cbg.studio.client.gwt.animation.AnimationKey;
import com.cbg.studio.client.gwt.js.core.Object3D;
import com.cbg.studio.client.gwt.js.math.Vector3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;

public class Animation extends JavaScriptObject {
    protected Animation() {
    }

    public final native Object3D getRoot()/*-{
                                          return this.root;
                                          }-*/;

    public final native AnimationData getData()/*-{
                                               return this.data;
                                               }-*/;

    public final native JsArray<AnimationHierarchyItem> getHierarchy()/*-{
                                                                      return this.hierarchy;
                                                                      }-*/;

    public final native double getCurrentTime()/*-{
                                               return this.currentTime;
                                               }-*/;

    public final native void setCurrentTime(double currentTime)/*-{
                                                               this.currentTime = currentTime;
                                                               }-*/;

    public final native double getTimeScale()/*-{
                                             return this.timeScale;
                                             }-*/;

    public final native void setTimeScale(double timeScale)/*-{
                                                           this.timeScale = timeScale;
                                                           }-*/;

    public final native boolean isIsPlaying()/*-{
                                             return this.isPlaying;
                                             }-*/;

    public final native void setIsPlaying(boolean isPlaying)/*-{
                                                            this.isPlaying = isPlaying;
                                                            }-*/;

    public final native boolean isIsPaused()/*-{
                                            return this.isPaused;
                                            }-*/;

    public final native void setIsPaused(boolean isPaused)/*-{
                                                          this.isPaused = isPaused;
                                                          }-*/;

    public final native boolean isLoop()/*-{
                                        return this.loop;
                                        }-*/;

    public final native void setLoop(boolean loop)/*-{
                                                  this.loop = loop;
                                                  }-*/;

    public final native int getInterpolationType()/*-{
                                                  return this.interpolationType;
                                                  }-*/;

    public final native void setInterpolationType(int interpolationType)/*-{
                                                                        this.interpolationType = interpolationType;
                                                                        }-*/;

    public final native JsArrayNumber getPoints()/*-{
                                                 return this.points;
                                                 }-*/;

    public final native Vector3 getTarget()/*-{
                                           return this.target;
                                           }-*/;

    public final native void setTarget(Vector3 target)/*-{
                                                      this.target = target;
                                                      }-*/;

    public final native void play(boolean loop, double startTimeMS)/*-{
                                                                   this.play(loop,startTimeMS);
                                                                   }-*/;

    public final native void pause()/*-{
                                    this.pause();
                                    }-*/;

    public final native void stop()/*-{
                                   this.stop();
                                   }-*/;

    public final native void update(double deltaTimeMS)/*-{
                                                       this.update(deltaTimeMS);
                                                       }-*/;

    public final native Vector3 interpolateCatmullRom(JsArrayNumber points,
            double scale)/*-{
                         return this.interpolateCatmullRom(points,scale);
                         }-*/;

    public final native double interpolate(double p0, double p1, double p2,
            double p3, double t, double t2, double t3)/*-{
                                                      return this.interpolate(p0,p1,p2,p3,t,t2,t3);
                                                      }-*/;

    public final native AnimationKey getNextKeyWith(int type, int h, int key)/*-{
                                                                             return this.getNextKeyWith(type,h,key);
                                                                             }-*/;

    public final native AnimationKey getPrevKeyWith(int type, int h, int key)/*-{
                                                                             return this.getPrevKeyWith(type,h,key);
                                                                             }-*/;

    public native final void play()/*-{
                                   this.play();
                                   }-*/;

    public native final void play(int startTime)/*-{
                                                this.play(startTime);
                                                }-*/;

}
