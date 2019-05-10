package com.test.threecolor;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by Anonym on 2019/5/10.
 */
public class Cube {

    public static final float T = 0.2f;  // thickness of tile
    public static final float D = 30;  // dimension of cube
    public static final float S = D / 2 + T;  // distance from center to surface
    public static final float INF = 100;

    public static class State {
        public float fx;
        public float fy;
        public float ux;
        public float uz;
        public float ry;
        public float rz;
        public Color f;
        public Color u;
        public Color r;
        public Color a;

        public State() {}

        public State(float fx, float fy, float ux, float uz, float ry, float rz, Color f, Color u, Color r, Color a) {
            this.fx = fx;
            this.fy = fy;
            this.ux = ux;
            this.uz = uz;
            this.ry = ry;
            this.rz = rz;
            this.f = f;
            this.u = u;
            this.r = r;
            this.a = a;
        }
    }

    public static final State[] states = new State[] {
            new State(-1, 1, -1, 1, INF, INF, Color.WHITE, Color.ORANGE, Color.GREEN, Color.GREEN),
            new State(INF, INF, 1, -1, 1, -1, Color.WHITE, Color.ORANGE, Color.GREEN, Color.WHITE),
            new State(1, -1, INF, INF, -1, 1, Color.WHITE, Color.ORANGE, Color.GREEN, Color.ORANGE),
            new State(-1, 1, -1, 1, INF, INF, Color.ORANGE, Color.GREEN, Color.WHITE, Color.WHITE),
            new State(INF, INF, 1, -1, 1, -1, Color.ORANGE, Color.GREEN, Color.WHITE, Color.ORANGE),
            new State(1, -1, INF, INF, -1, 1, Color.ORANGE, Color.GREEN, Color.WHITE, Color.GREEN),
            new State(-1, 1, -1, 1, INF, INF, Color.GREEN, Color.WHITE, Color.ORANGE, Color.ORANGE),
            new State(INF, INF, 1, -1, 1, -1, Color.GREEN, Color.WHITE, Color.ORANGE, Color.GREEN),
            new State(1, -1, INF, INF, -1, 1, Color.GREEN, Color.WHITE, Color.ORANGE, Color.WHITE),
            new State(-1, 1, -1, 1, INF, INF, Color.WHITE, Color.GREEN, Color.ORANGE, Color.ORANGE),
            new State(INF, INF, 1, -1, 1, -1, Color.WHITE, Color.GREEN, Color.RED, Color.WHITE),
            new State(1, -1, INF, INF, -1, 1, Color.WHITE, Color.GREEN, Color.RED, Color.GREEN),
            new State(-1, 1, -1, 1, INF, INF, Color.RED, Color.WHITE, Color.GREEN, Color.GREEN),
            new State(INF, INF, 1, -1, 1, -1, Color.RED, Color.WHITE, Color.GREEN, Color.RED),
            new State(1, -1, INF, INF, -1, 1, Color.RED, Color.WHITE, Color.GREEN, Color.WHITE),
            new State(-1, 1, -1, 1, INF, INF, Color.GREEN, Color.RED, Color.WHITE, Color.WHITE),
            new State(INF, INF, 1, -1, 1, -1, Color.GREEN, Color.RED, Color.WHITE, Color.GREEN),
            new State(1, -1, INF, INF, -1, 1, Color.GREEN, Color.RED, Color.WHITE, Color.RED),
            new State(-1, 1, -1, 1, INF, INF, Color.WHITE, Color.RED, Color.BLUE, Color.BLUE),
            new State(INF, INF, 1, -1, 1, -1, Color.WHITE, Color.RED, Color.BLUE, Color.WHITE),
            new State(1, -1, INF, INF, -1, 1, Color.WHITE, Color.RED, Color.BLUE, Color.RED),
            new State(-1, 1, -1, 1, INF, INF, Color.RED, Color.BLUE, Color.WHITE, Color.WHITE),
            new State(INF, INF, 1, -1, 1, -1, Color.RED, Color.BLUE, Color.WHITE, Color.RED),
            new State(1, -1, INF, INF, -1, 1, Color.RED, Color.BLUE, Color.WHITE, Color.BLUE),
            new State(-1, 1, -1, 1, INF, INF, Color.BLUE, Color.WHITE, Color.RED, Color.RED),
            new State(INF, INF, 1, -1, 1, -1, Color.BLUE, Color.WHITE, Color.RED, Color.BLUE),
            new State(1, -1, INF, INF, -1, 1, Color.BLUE, Color.WHITE, Color.RED, Color.WHITE),
            new State(-1, 1, -1, 1, INF, INF, Color.WHITE, Color.BLUE, Color.ORANGE, Color.ORANGE),
            new State(INF, INF, 1, -1, 1, -1, Color.WHITE, Color.BLUE, Color.ORANGE, Color.WHITE),
            new State(1, -1, INF, INF, -1, 1, Color.WHITE, Color.BLUE, Color.ORANGE, Color.BLUE),
            new State(-1, 1, -1, 1, INF, INF, Color.BLUE, Color.ORANGE, Color.WHITE, Color.WHITE),
            new State(INF, INF, 1, -1, 1, -1, Color.BLUE, Color.ORANGE, Color.WHITE, Color.BLUE),
            new State(1, -1, INF, INF, -1, 1, Color.BLUE, Color.ORANGE, Color.WHITE, Color.ORANGE),
            new State(-1, 1, -1, 1, INF, INF, Color.ORANGE, Color.WHITE, Color.BLUE, Color.BLUE),
            new State(INF, INF, 1, -1, 1, -1, Color.ORANGE, Color.WHITE, Color.BLUE, Color.ORANGE),
            new State(1, -1, INF, INF, -1, 1, Color.ORANGE, Color.WHITE, Color.BLUE, Color.WHITE),
            new State(-1, 1, -1, 1, INF, INF, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.ORANGE),
            new State(INF, INF, 1, -1, 1, -1, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.YELLOW),
            new State(1, -1, INF, INF, -1, 1, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.GREEN),
            new State(-1, 1, -1, 1, INF, INF, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.YELLOW),
            new State(INF, INF, 1, -1, 1, -1, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.GREEN),
            new State(1, -1, INF, INF, -1, 1, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.ORANGE),
            new State(-1, 1, -1, 1, INF, INF, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.GREEN),
            new State(INF, INF, 1, -1, 1, -1, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.ORANGE),
            new State(1, -1, INF, INF, -1, 1, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.YELLOW),
            new State(-1, 1, -1, 1, INF, INF, Color.YELLOW, Color.RED, Color.GREEN, Color.GREEN),
            new State(INF, INF, 1, -1, 1, -1, Color.YELLOW, Color.RED, Color.GREEN, Color.YELLOW),
            new State(1, -1, INF, INF, -1, 1, Color.YELLOW, Color.RED, Color.GREEN, Color.RED),
            new State(-1, 1, -1, 1, INF, INF, Color.RED, Color.GREEN, Color.YELLOW, Color.YELLOW),
            new State(INF, INF, 1, -1, 1, -1, Color.RED, Color.GREEN, Color.YELLOW, Color.RED),
            new State(1, -1, INF, INF, -1, 1, Color.RED, Color.GREEN, Color.YELLOW, Color.GREEN),
            new State(-1, 1, -1, 1, INF, INF, Color.GREEN, Color.YELLOW, Color.RED, Color.RED),
            new State(INF, INF, 1, -1, 1, -1, Color.GREEN, Color.YELLOW, Color.RED, Color.GREEN),
            new State(1, -1, INF, INF, -1, 1, Color.GREEN, Color.YELLOW, Color.RED, Color.YELLOW),
            new State(-1, 1, -1, 1, INF, INF, Color.YELLOW, Color.BLUE, Color.RED, Color.RED),
            new State(INF, INF, 1, -1, 1, -1, Color.YELLOW, Color.BLUE, Color.RED, Color.YELLOW),
            new State(1, -1, INF, INF, -1, 1, Color.YELLOW, Color.BLUE, Color.RED, Color.BLUE),
            new State(-1, 1, -1, 1, INF, INF, Color.BLUE, Color.RED, Color.YELLOW, Color.YELLOW),
            new State(INF, INF, 1, -1, 1, -1, Color.BLUE, Color.RED, Color.YELLOW, Color.BLUE),
            new State(1, -1, INF, INF, -1, 1, Color.BLUE, Color.RED, Color.YELLOW, Color.RED),
            new State(-1, 1, -1, 1, INF, INF, Color.RED, Color.YELLOW, Color.BLUE, Color.BLUE),
            new State(INF, INF, 1, -1, 1, -1, Color.RED, Color.YELLOW, Color.BLUE, Color.RED),
            new State(1, -1, INF, INF, -1, 1, Color.RED, Color.YELLOW, Color.BLUE, Color.YELLOW),
            new State(-1, 1, -1, 1, INF, INF, Color.YELLOW, Color.ORANGE, Color.BLUE, Color.BLUE),
            new State(INF, INF, 1, -1, 1, -1, Color.YELLOW, Color.ORANGE, Color.BLUE, Color.YELLOW),
            new State(1, -1, INF, INF, -1, 1, Color.YELLOW, Color.ORANGE, Color.BLUE, Color.ORANGE),
            new State(-1, 1, -1, 1, INF, INF, Color.ORANGE, Color.BLUE, Color.YELLOW, Color.YELLOW),
            new State(INF, INF, 1, -1, 1, -1, Color.ORANGE, Color.BLUE, Color.YELLOW, Color.ORANGE),
            new State(1, -1, INF, INF, -1, 1, Color.ORANGE, Color.BLUE, Color.YELLOW, Color.BLUE),
            new State(-1, 1, -1, 1, INF, INF, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.ORANGE),
            new State(INF, INF, 1, -1, 1, -1, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.BLUE),
            new State(1, -1, INF, INF, -1, 1, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.YELLOW),
    };
}
