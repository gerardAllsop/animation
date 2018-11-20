package com.allsopg.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Comparator;

public class AnimatedSprite extends Sprite {
    static final float FRAME_DURATION = 1.0f/30.0f;
    TextureAtlas atlas;
    Animation animation;
    Vector2 position;

    public AnimatedSprite(String atlasString,Vector2 position,String size){
        super(new Texture(size));
        this.position = position;
        this.setX(this.position.x);
        this.setY(this.position.y);
        atlas = new TextureAtlas(Gdx.files.internal(atlasString));
        //load animations
        Array<TextureAtlas.AtlasRegion> regions = new
                Array<TextureAtlas.AtlasRegion>(atlas.getRegions());
        regions.sort(new RegionComparator());
        animation = new Animation(FRAME_DURATION,regions,Animation.PlayMode.NORMAL);
    }


    public void setAnimation(Animation.PlayMode mode){
         animation.setPlayMode(mode);
    }

    public void update(float deltaTime){
            this.setRegion(
                    (TextureRegion) animation.getKeyFrame(deltaTime));
    }


    private static class RegionComparator implements Comparator<TextureAtlas.AtlasRegion>{
        @Override
        public int compare(TextureAtlas.AtlasRegion region_1, TextureAtlas.AtlasRegion region_2){
            return region_1.name.compareTo(region_2.name);
        }
    }
}
