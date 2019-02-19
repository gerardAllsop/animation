package utility;

/**
 * Updated Feb 2019
 */
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameControl extends Stage {
    private String displayMsg = "Awaiting mouse activity";
    private boolean mousePressed = false;

    public GameControl() {
    }

    public String getDisplayMsg(){
        return displayMsg;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        CameraControl.getInstance().storeMousePress(screenX,screenY);
        mousePressed=true;
        displayMsg = "Freshly pressed Mouse!";
        return false;
    }
    @Override
     public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        displayMsg = "Awaiting mouse activity";
        mousePressed=false;
        return false;
    }
    public void update() {
        if(mousePressed){
            CameraControl.getInstance().update();
        }
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
}
