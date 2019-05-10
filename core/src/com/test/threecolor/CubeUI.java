package com.test.threecolor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by Anonym on 2019/5/10.
 */
public class CubeUI extends GameUI {
    private Core game;
    public Stage stage;
    public CubeWorld cubeWorld;

    public TextButton whiteButton;
    public TextButton yellowButton;
    public TextButton redButton;
    public TextButton orangeButton;
    public TextButton greenButton;
    public TextButton blueButton;

    public CubeUI(Core game, CubeWorld cubeWorld) {
        this.game = game;
        this.cubeWorld = cubeWorld;

        stage = new Stage(new FitViewport(Core.VIRTUAL_WIDTH, Core.VIRTUAL_HEIGHT));
        setWidges();
        configureWidges();
    }

    public void setWidges() {
        whiteButton = new TextButton("", Assets.skin);
        yellowButton = new TextButton("", Assets.skin);
        redButton = new TextButton("", Assets.skin);
        orangeButton = new TextButton("", Assets.skin);
        greenButton = new TextButton("", Assets.skin);
        blueButton = new TextButton("", Assets.skin);
    }

    public void configureWidges() {
        float x0 = Core.VIRTUAL_WIDTH / 24 * 5;
        float y0 = Core.VIRTUAL_HEIGHT / 2.5f - Core.VIRTUAL_WIDTH / 6;
        float dy = 1.5f * Core.VIRTUAL_WIDTH / 6;
        float dx = Core.VIRTUAL_WIDTH / 24 * 8;

        addButton(whiteButton, Color.WHITE, x0, y0);
        addButton(yellowButton, Color.YELLOW, x0 + dx, y0);
        addButton(redButton, Color.RED, x0, y0 - dy);
        addButton(orangeButton, Color.ORANGE, x0 + dx, y0 - dy);
        addButton(greenButton, Color.GREEN, x0, y0 - 2 * dy);
        addButton(blueButton, Color.BLUE, x0 + dx, y0 - 2 * dy);
    }
    
    private void addButton(final TextButton button, Color color, float x, float y) {
        button.setColor(color);
        button.setSize(Core.VIRTUAL_WIDTH / 12 * 3, Core.VIRTUAL_WIDTH / 6);
        button.setPosition(x, y);
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                cubeWorld.handleAnswer(button.getColor());
            }
        });
        stage.addActor(button);
    }

    @Override
    public void update(float delta) {
        stage.act(delta);
    }

    @Override
    public void render() {
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
