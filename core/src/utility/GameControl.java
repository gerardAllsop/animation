package utility;

/**
 * Created by gerard on 17/02/2017
 * Updated Feb 2019
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameControl extends Stage {
    private boolean move = false;
    private CurrentDirection direction = CurrentDirection.STOP;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private String displayMsg = "Awaiting mouse activity";
    private Vector2 camPos;

    public GameControl(OrthographicCamera camera) {
        this.camera = camera;
        this.camPos = new Vector2(10,10);
    }

    public String getDisplayMsg(){
        return displayMsg;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        displayMsg = "Freshly pressed Mouse!";
        move = true;
        if (screenY > 250) {
            direction = CurrentDirection.UP;
        } else if (screenY < 200 && screenX < 600) {
            direction = CurrentDirection.LEFT;
        } else if (screenY < 200 && screenX > 600) {
            direction = CurrentDirection.RIGHT;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        displayMsg = "Awaiting mouse activity";
        direction = CurrentDirection.STOP;
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }


    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public void update() {
    }
}
