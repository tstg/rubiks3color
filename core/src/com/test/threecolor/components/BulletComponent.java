package com.test.threecolor.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody;
import com.test.threecolor.bullet.MotionState;

/**
 * Created by Anonym on 2019/5/10.
 */
public class BulletComponent implements Component {
    public MotionState motionState;
    public btRigidBody.btRigidBodyConstructionInfo bodyInfo;
    public btCollisionObject body;


}
