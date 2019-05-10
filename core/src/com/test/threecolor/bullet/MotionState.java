package com.test.threecolor.bullet;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.bullet.linearmath.btMotionState;

/**
 * Created by Anonym on 2019/5/10.
 */
public class MotionState extends btMotionState {
    private final Matrix4 transform;

    public MotionState(final Matrix4 transform) {
        this.transform = transform;
    }

    @Override
    public void getWorldTransform(Matrix4 worldTrans) {
        worldTrans.set(transform);
    }

    @Override
    public void setWorldTransform(Matrix4 worldTrans) {
        transform.set(worldTrans);
    }
}
