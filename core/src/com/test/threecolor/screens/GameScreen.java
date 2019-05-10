package com.test.threecolor.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.test.threecolor.Core;
import com.test.threecolor.Cube;
import com.test.threecolor.CubeUI;
import com.test.threecolor.CubeWorld;
import com.test.threecolor.GameUI;
import com.test.threecolor.GameWorld;

/**
 * Created by Anonym on 2019/5/6.
 */
public class GameScreen implements Screen {
    Core game;
    GameWorld gameWorld;
    GameUI gameUI;

    public GameScreen(Core game) {
        this.game = game;
        gameWorld = new CubeWorld();
        gameUI = new CubeUI(game, (CubeWorld) gameWorld);
        Gdx.input.setInputProcessor(((CubeUI) gameUI).stage);
//        Gdx.input.setCursorCatched(true);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        gameUI.update(delta);
        gameWorld.render(delta);
        gameUI.render();
    }

    @Override
    public void resize(int width, int height) {
        gameUI.resize(width, height);
        gameWorld.resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        gameWorld.dispose();
        gameUI.dispose();
    }
}
