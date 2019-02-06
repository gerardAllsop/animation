package TBW;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static utility.Constants.WORLD_HEIGHT;
import static utility.Constants.WORLD_WIDTH;

/**
 * Created by gerard on 12/02/2017
 * Update: Feb/2019
 */

public class GameScreenTBW extends ScreenAdapter {
    private Viewport viewport;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private TBWGame tbwGame;
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;


    public GameScreenTBW(TBWGame tbwGame){
        this.tbwGame = tbwGame;
    }

    @Override
    public void show() {
        super.show();
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        viewport.apply(true);
        batch = new SpriteBatch();

        tiledMap = tbwGame.getAssetManager().get("tileData/floorTiles.tmx");
        orthogonalTiledMapRenderer = new
                OrthogonalTiledMapRenderer(tiledMap, batch);
        orthogonalTiledMapRenderer.setView(camera);
    }

    @Override
    public void render(float delta) {
        clearScreen();
        draw();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(Color.RED.r, Color.BLACK.g,
                Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void draw() {
        batch.setProjectionMatrix(camera.projection);
        batch.setTransformMatrix(camera.view);
        batch.begin();
        batch.end();
        orthogonalTiledMapRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

}