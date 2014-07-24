package com.cbg.studio.client.gwt.data.ui;

import java.util.List;

import com.cbg.studio.client.gwt.js.core.Object3D;
import com.cbg.studio.client.gwt.math.XYObject;

public class MovingXYControler extends AbstractMovingXYControler {

    private Object3D target;
    private MovingEndListener listener;

    public Object3D getTarget() {
        return target;
    }

    public void setTarget(Object3D target) {
        this.target = target;
    }

    public MovingEndListener getListener() {
        return listener;
    }

    public void setListener(MovingEndListener listener) {
        this.listener = listener;
    }

    public MovingXYControler(List<XYObject> points, int duration,
            Object3D target) {
        super(points, duration);
        this.target = target;
    }

    @Override
    public void moveEnd() {
        // move finished
        XYObject last = points.get(points.size() - 1);
        target.getPosition().setX(last.getX());
        target.getPosition().setY(last.getY());

        if (listener != null) {
            listener.moveFinished();
        }
    }

    @Override
    public void moveTo(double x, double y) {
        target.getPosition().setX(x);
        target.getPosition().setY(y);
    }

    public interface MovingEndListener {
        public void moveFinished();
    }

}
