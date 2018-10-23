package com.allsopg.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SpriteExample implements ApplicationListener{
    static final Color BACKGROUND_COLOR = new Color(0,0,0,1);
    private SpriteBatch batch;
    private Texture txRegion;
    private Sprite sprSaw;
    private Vector2 position;

    private ScreenViewport viewport;

    @Override
    public void create() {
        position = new Vector2(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        viewport = new ScreenViewport();
        batch = new SpriteBatch();
        txRegion = new Texture(Gdx.files.internal("gfx/threeblades.png"));
        sprSaw = new Sprite(txRegion);
        sprSaw.setPosition(position.x*.5f,position.y*.5f);
    }

    @Override
    public void render() {
        //clear screen
        Gdx.gl.glClearColor(BACKGROUND_COLOR.r,BACKGROUND_COLOR.g,
                BACKGROUND_COLOR.b,BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //draw
        batch.begin();
        sprSaw.draw(batch);
        batch.end();
    }

    //Unused ApplicationListener overrides
    @Override
    public void resize(int width, int height) {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void dispose() {}

}
