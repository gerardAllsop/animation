package com.allsopg.game;

import com.badlogic.gdx.math.Vector2;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import utility.TweenData;
import utility.TweenDataAccessor;
import utility.UniversalResource;

public class BonusSprite extends AnimatedSprite{
    private TweenData tweenData;
    private TweenManager tweenManager;


    public BonusSprite(String atlasString, Vector2 position, String size) {
        super(atlasString, position, size);
        initTweenData();
    }

    private void initTweenData(){
        tweenData = new TweenData();
        tweenData.setXY(new Vector2(this.getX(),this.getY()));
        tweenData.setColor(this.getColor());
        tweenData.setScale(this.getScaleX());
        tweenManager = UniversalResource.getInstance().tweenManager;
    }

    private TweenData getTweenData(){return tweenData;}

    @Override
    public void update(float stateTime){
        super.update(stateTime);
        this.setX(tweenData.getXY().x);
        this.setY(tweenData.getXY().y);
        this.setColor(tweenData.getColor());
        this.setScale(tweenData.getScale());
        this.setRotation(tweenData.getRotation());
    }

    public void startupRoutine(){
        Tween.to(tweenData, TweenDataAccessor.TYPE_POS,250f)
                .target(200,100).start(tweenManager).to(tweenData,TweenDataAccessor.TYPE_ROTATION,250f).target(100).start(tweenManager);
    }


}
