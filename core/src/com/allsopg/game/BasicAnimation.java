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

public class BasicAnimation implements ApplicationListener {
    static final Color BACKGROUND_COLOR = new Color(0,0,0,1);
    static final float FRAME_DURATION = 1.0f/30.0f;
    SpriteBatch batch;
    ScreenViewport viewport;
    TextureAtlas atlas;
    Animation aniSaw;
    float animationTime;


    @Override
    public void create() {
        viewport = new ScreenViewport();
        viewport.update(Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        atlas = new TextureAtlas(Gdx.files.internal(
                "texture_atlas/saw_assets.atlas"));

        //load animations
        Array<TextureAtlas.AtlasRegion> sawRegions = new
                Array<TextureAtlas.AtlasRegion>(atlas.getRegions());
        sawRegions.sort(new RegionComparator());
        aniSaw = new Animation(FRAME_DURATION,sawRegions,
                Animation.PlayMode.LOOP);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(BACKGROUND_COLOR.r,BACKGROUND_COLOR.g,
                BACKGROUND_COLOR.b,BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        animationTime += Gdx.graphics.getDeltaTime();
        batch.begin();
        TextureRegion sawFrame = (TextureRegion) aniSaw.getKeyFrame(animationTime);
        batch.draw(sawFrame,100,100);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

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

    private static class RegionComparator implements
            Comparator<TextureAtlas.AtlasRegion>{
        @Override
        public int compare(TextureAtlas.AtlasRegion region_1,
                           TextureAtlas.AtlasRegion region_2) {
            return region_1.name.compareTo(region_2.name);
        }
    }
}
