package com.allsopg.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Comparator;

import utility.Constants;

public class BasicAnimation implements ApplicationListener {
    private static final Color
            BACKGROUND_COLOR = new Color(1,1,1,1);
    private static final float FRAME_DURATION = 1.0f/30.0f;

    private SpriteBatch batch;

    private Animation ani;
    private float animationTime;


    @Override
    public void create() {
        ScreenViewport viewport = new ScreenViewport();
        viewport.update(Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());

        batch = new SpriteBatch();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(
                Constants.BALL_ATLAS));

        //load animations
        Array<TextureAtlas.AtlasRegion> sawRegions = new
                Array<TextureAtlas.AtlasRegion>(atlas.getRegions());
        sawRegions.sort(new RegionComparator());
        ani = new Animation(FRAME_DURATION,sawRegions,
                Animation.PlayMode.LOOP);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(BACKGROUND_COLOR.r,BACKGROUND_COLOR.g,
                BACKGROUND_COLOR.b,BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        animationTime += Gdx.graphics.getDeltaTime();
        TextureRegion sawFrame = (TextureRegion)
                ani.getKeyFrame(animationTime);

        batch.begin();
        batch.draw(sawFrame,100,100);
        batch.end();
    }


    private static class RegionComparator implements
            Comparator<TextureAtlas.AtlasRegion>{
        @Override
        public int compare(TextureAtlas.AtlasRegion region_1,
                           TextureAtlas.AtlasRegion region_2) {
            return region_1.name.compareTo(region_2.name);
        }
    }

    @Override
    public void resize(int width, int height) {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void dispose() {}
}
