package utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

import static utility.Constants.CAMERASPEED;
import static utility.Constants.WORLD_HEIGHT;
import static utility.Constants.WORLD_WIDTH;

public class CameraControl {
    private OrthographicCamera camera;
    private CurrentDirection cameraDirection = CurrentDirection.STOP;
    private Vector2 cameraPressPos;
    private static CameraControl instance;

    private CameraControl() {
        camera = new OrthographicCamera();
        camera.position.set(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, 0);
        camera.update();
        cameraPressPos = new Vector2();
    }

    public static CameraControl getInstance() {
        if (instance == null)
            instance = new CameraControl();
        return instance;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void storeMousePress(float x, float y) {
        cameraPressPos.x = x;
        cameraPressPos.y = y;
    }

    public void update() {
        if (Gdx.input.getX() - cameraPressPos.x > 0) {
            camera.translate(CAMERASPEED, 0);
            cameraDirection = CurrentDirection.RIGHT;
        } else {
            camera.translate(-CAMERASPEED, 0);
            cameraDirection = CurrentDirection.LEFT;
        }
        camera.update();
    }
}
