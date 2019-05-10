package com.test.threecolor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;



/**
 * Created by Anonym on 2019/5/10.
 */
public class Assets {
    public static Skin skin;

    public Assets() {
        skin = new Skin();
        FileHandle fileHandle = Gdx.files.internal("skin/uiskin.json");
        FileHandle atlasFile = fileHandle.sibling("uiskin.atlas");

        if (atlasFile.exists()) {
            skin.addRegions(new TextureAtlas(atlasFile));
            Gdx.app.log(this.getClass().getName(), "uiskin exists");
        }
        skin.load(fileHandle);
    }

    public static void dispose() {
        skin.dispose();
    }
}
