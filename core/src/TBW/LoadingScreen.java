package TBW;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import utility.CameraControl;

import static utility.Constants.WORLD_HEIGHT;
import static utility.Constants.WORLD_WIDTH;

/**
 * Created by gerard on 12/02/2017
 * Update: Feb/2019
 */

public class LoadingScreen extends ScreenAdapter {
    private Viewport viewport;
    private TBWGame tbwGame;

    public LoadingScreen(TBWGame tbwGame) {
        this.tbwGame = tbwGame;
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void show() {
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, CameraControl.getInstance().getCamera());
        tbwGame.getAssetManager().load("tileData/floorTiles.tmx", TiledMap.class);
    }

    @Override
    public void render(float delta) {
        update();
        clearScreen();
        draw();
    }

    @Override
    public void dispose(){}

    private void update() {
        if (tbwGame.getAssetManager().update()) {
            tbwGame.setScreen(new GameScreenTBW(tbwGame));
        }
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g,
                Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    private void draw() {}
}