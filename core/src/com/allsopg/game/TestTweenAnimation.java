package com.allsopg.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import utility.UniversalResource;

public class TestTweenAnimation implements ApplicationListener {
    static final Color BACKGROUND_COLOR = new Color(0,0,0,1);
    private SpriteBatch batch;
    private float animationTime;
    private static final String size = "data/mediumSize.png";
    BonusSprite bp;
    private ScreenViewport viewport;

    @Override
    public void create() {
        viewport = new ScreenViewport();
        batch = new SpriteBatch();
        bp = new BonusSprite("texture_atlas/saw_assets.atlas",
                new Vector2(100,100),
                size);
       bp.startupRoutine();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(BACKGROUND_COLOR.r,BACKGROUND_COLOR.g,
                BACKGROUND_COLOR.b,BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        animationTime+=Gdx.graphics.getDeltaTime();
        UniversalResource.getInstance().tweenManager.update(animationTime);
        bp.update(animationTime);
        //draw
        batch.begin();
        bp.draw(batch);
        batch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
