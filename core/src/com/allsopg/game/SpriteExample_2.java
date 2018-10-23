package com.allsopg.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Comparator;

public class SpriteExample_2 extends InputAdapter implements ApplicationListener {
    static final Color BACKGROUND_COLOR = new Color(0,0,0,1);
    private SpriteBatch batch;
    private Texture txRegion;
    private Sprite sprSaw;
    private Array<Color> colors;
    private int currentColor;
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
        //add a few colors to the collection
        colors = new Array<Color>();
        colors.add(new Color(Color.YELLOW));
        colors.add(new Color(Color.BLUE));
        colors.add(new Color(Color.FIREBRICK));
        //set up user input
        Gdx.input.setInputProcessor(this);
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

    @Override
    public boolean touchDown (int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.RIGHT) {
            currentColor = (currentColor + 1) % colors.size;
           sprSaw.setColor(colors.get(currentColor));
        }
        else if (button == Input.Buttons.LEFT){
            position.x = Gdx.input.getX();
            position.y = Gdx.input.getY();
            sprSaw.setPosition(position.x - sprSaw.getWidth()/2,
                    Gdx.graphics.getHeight() - position.y - sprSaw.getHeight()/2);
        }
        return true;
    }

    @Override
    public boolean scrolled (int amount) {
        if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
            sprSaw.scale(amount * 0.5f);
        }
        else {
            sprSaw.rotate(amount * 5.0f);
        }

        return true;
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
