package com.allsopg.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
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


    public void closeRoutine(){
        Tween.to(tweenData, TweenDataAccessor.TYPE_POS,100f)
                .delay(2000)
                .target(-250,0).start(tweenManager)
                .setCallback(new TweenCallback() {
                    @Override
                    public void onEvent(int type, BaseTween<?> source) {
                        setAnimation(Animation.PlayMode.NORMAL);
                    }
                })
                .start(tweenManager);
    }

    public void startupRoutine(){ ;
        Timeline.createSequence()
                .push(Tween.to(tweenData, TweenDataAccessor.TYPE_ROTATION,0f)
                        .target(90))
                .pushPause(100)
                .push(Tween.to(tweenData,TweenDataAccessor.TYPE_ROTATION,10)
                .target(360))
                .push(Tween.to(tweenData, TweenDataAccessor.TYPE_POS,75)
                .target(getX(),0))
                .setCallback(new TweenCallback() {
                    @Override
                    public void onEvent(int type, BaseTween<?> source) {
                        setAnimation(Animation.PlayMode.LOOP);
                        closeRoutine();
                    }
                })
                .start(tweenManager);
    }


}
