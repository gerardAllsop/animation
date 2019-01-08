package com.allsopg.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenAccessor;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import utility.Constants;
import utility.TweenData;
import utility.TweenDataAccessor;
import utility.UniversalResource;

import java.util.Comparator;

public class AnimationMulti extends Sprite {
    private Animation radioactive, explode,animation;
    private TextureAtlas atlas_1,atlas_2;
    private TweenData tweenData;
    private TweenManager tweenManager;


    public AnimationMulti(String atlasString_1,
                          String atlasString_2,
                          String size){
        super(new Texture(size));
        atlas_1 = new TextureAtlas(Gdx.files.internal(atlasString_1));
        Array <TextureAtlas.AtlasRegion> regions_1 =
                new Array<TextureAtlas.AtlasRegion>(atlas_1.getRegions());
        regions_1.sort(new RegionComparator());
        radioactive = new Animation(Constants.FRAME_DURATION,
                                    regions_1,
                                    Animation.PlayMode.LOOP);

        atlas_2 = new TextureAtlas(Gdx.files.internal(atlasString_2));
        Array <TextureAtlas.AtlasRegion> regions_2 =
                new Array<TextureAtlas.AtlasRegion>(atlas_2.getRegions());
        regions_2.sort(new RegionComparator());
        explode = new Animation(Constants.FRAME_DURATION,
                regions_2,
                Animation.PlayMode.NORMAL);

        animation = radioactive;

        this.setPosition(75,250);
        initTweenData();
    }

    public void endRoutine(){
        Tween.to(tweenData,TweenDataAccessor.TYPE_POS,250f)
                .start(tweenManager);
    }


    public void update(float deltaTime){
        this.setRegion((TextureAtlas.AtlasRegion)
                animation.getKeyFrame(deltaTime));
    }


    public void closeRoutine(){
        Tween.to(tweenData, TweenDataAccessor.TYPE_POS,250f)
                .target(150,100).start(tweenManager)
                .delay(1500)
                .setCallback(new TweenCallback() {
                    @Override
                    public void onEvent(int type, BaseTween<?> source) {
                        animation = explode;
                        endRoutine();
                    }
                })
                .start(tweenManager);
    }

    private void initTweenData(){
        tweenData = new TweenData();
        tweenData.setXY(new Vector2(this.getX(),this.getY()));
        tweenManager = UniversalResource.getInstance().getTweenManager();
    }


    private static class RegionComparator implements
            Comparator<TextureAtlas.AtlasRegion> {
        @Override
        public int compare(TextureAtlas.AtlasRegion region_1,
                           TextureAtlas.AtlasRegion region_2) {
            return region_1.name.compareTo(region_2.name);
        }
    }
}
