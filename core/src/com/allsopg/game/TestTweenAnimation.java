package com.allsopg.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import utility.Constants;
import utility.UniversalResource;

import static utility.Constants.BACKGROUND_COLOR;

public class TestTweenAnimation implements ApplicationListener {
    private SpriteBatch batch;
    private float animationTime;
    private BonusSprite bp;
    private BitmapFont font;
    private ScreenViewport viewport;
    private AnimationMulti am;

    @Override
    public void create() {
        viewport = new ScreenViewport();
        batch = new SpriteBatch();
        bp = new BonusSprite(Constants.BALL_ATLAS,
                new Vector2(400,300),
                Constants.SIZE);
        am = new AnimationMulti(Constants.RADIOACTIVE_ATLAS,
                                Constants.EXPLODE_ATLAS,
                                Constants.SIZE);

        font = UniversalResource.getInstance().getFont();
        UniversalResource.getInstance().setScreenText("Hey, it' bouncey Bob!");
       bp.startupRoutine();
       am.closeRoutine();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(BACKGROUND_COLOR.r,BACKGROUND_COLOR.g,
                BACKGROUND_COLOR.b,BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        animationTime+=Gdx.graphics.getDeltaTime();
        UniversalResource.getInstance().getTweenManager().update(animationTime);
        bp.update(animationTime);
        am.update(animationTime);
        //draw
        batch.begin();
        font.draw(batch,UniversalResource.getInstance().getScreenText(),
                Gdx.graphics.getWidth()/7,Gdx.graphics.getHeight()/2);
        bp.draw(batch);
        am.draw(batch);
        batch.end();
    }

    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void dispose() {}
    @Override
    public void resize(int width, int height) {}
}
