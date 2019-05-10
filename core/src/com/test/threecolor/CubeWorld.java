package com.test.threecolor;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DirectionalLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.physics.bullet.Bullet;
import com.test.threecolor.managers.EntityFactory;
import com.test.threecolor.systems.BulletSystem;
import com.test.threecolor.systems.RenderSystem;

import java.util.Random;

/**
 * Created by Anonym on 2019/5/6.
 */
public class CubeWorld extends GameWorld {
    private static final float FOV = 67f;
    private ModelBatch modelBatch;
    private Environment environment;
    private PerspectiveCamera perspectiveCamera;

    private Engine engine;
    public BulletSystem bulletSystem;
    public ModelBuilder modelBuilder = new ModelBuilder();

    private Model cube = modelBuilder.createBox(Cube.D, Cube.D, Cube.D, new Material(ColorAttribute.createDiffuse(Color.GRAY)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
    private Model tileUp;
    private Model tileFront;
    private Model tileRight;

    private Entity tileUpEntity;
    private Entity tileFrontEntity;
    private Entity tileRightEntity;

    private int x;

    public CubeWorld() {
        Bullet.init();
        initPersCamera();
        initEnvironment();
        initModelBatch();
        addSystems();
        addEntities();
    }

    private void addEntities() {
        createCube();
    }

    private void initPersCamera() {
        perspectiveCamera = new PerspectiveCamera(FOV, Core.VIRTUAL_WIDTH, Core.VIRTUAL_HEIGHT);
        perspectiveCamera.position.set(65f, 55f, 65f);
        perspectiveCamera.lookAt(0f, -40f, 0f);
        perspectiveCamera.near = 1f;
        perspectiveCamera.far = 300f;
        perspectiveCamera.update();
    }

    private void initEnvironment() {
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 1f, 1f, 1f, 1f));
        environment.add(new DirectionalLight().set(0.3f, 0.3f, 0.3f, -1f, -0.8f, -0.2f));
    }

    private void initModelBatch() {
        modelBatch = new ModelBatch();
    }

    public void resize(int width, int height) {
        perspectiveCamera.viewportHeight = height;
        perspectiveCamera.viewportWidth = width;
    }

    public void render(float delta) {
        renderWorld(delta);
    }

    private void createCube() {
        engine.addEntity(EntityFactory.createStaticEntity(cube, 0, 0,0));

        tileUpEntity = new Entity();
        tileFrontEntity = new Entity();
        tileRightEntity = new Entity();

        changeTile();
    }

    private void changeTile() {
        engine.removeEntity(tileUpEntity);
        engine.removeEntity(tileFrontEntity);
        engine.removeEntity(tileRightEntity);

        Random random = new Random();
        x = random.nextInt(72);

        tileUp = modelBuilder.createBox(Cube.D / 3, Cube.T * 2, Cube.D / 3, new Material(ColorAttribute.createDiffuse(Cube.states[x].u)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        tileFront = modelBuilder.createBox(Cube.D / 3, Cube.D / 3, Cube.T * 2, new Material(ColorAttribute.createDiffuse(Cube.states[x].f)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        tileRight = modelBuilder.createBox(Cube.T * 2, Cube.D / 3, Cube.D / 3, new Material(ColorAttribute.createDiffuse(Cube.states[x].r)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);

        tileUpEntity = EntityFactory.createStaticEntity(tileUp, Cube.states[x].ux * Cube.D / 3, Cube.S, Cube.states[x].uz * Cube.D / 3);
        tileFrontEntity = EntityFactory.createStaticEntity(tileFront, Cube.states[x].fx * Cube.D / 3, Cube.states[x].fy * Cube.D / 3, Cube.S);
        tileRightEntity = EntityFactory.createStaticEntity(tileRight, Cube.S, Cube.states[x].ry * Cube.D / 3, Cube.states[x].rz * Cube.D / 3);

        engine.addEntity(tileUpEntity);
        engine.addEntity(tileFrontEntity);
        engine.addEntity(tileRightEntity);
    }

    private void addSystems() {
        engine = new Engine();
        engine.addSystem(new RenderSystem(modelBatch, environment));
        engine.addSystem(bulletSystem = new BulletSystem());
    }

    protected void renderWorld(float delta) {
        modelBatch.begin(perspectiveCamera);
        engine.update(delta);
        modelBatch.end();
    }

    public void dispose() {
        bulletSystem.dispose();
        bulletSystem = null;
        cube.dispose();
        tileUp.dispose();
        tileFront.dispose();
        tileRight.dispose();
        modelBatch.dispose();
        modelBatch = null;
    }

    public void handleAnswer(Color color) {
        if (Cube.states[x].a.equals(color)) {
            changeTile();
        }
    }
}
