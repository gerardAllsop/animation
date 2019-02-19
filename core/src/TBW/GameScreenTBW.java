package TBW;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

import utility.CameraControl;
import utility.Constants;
import utility.GameControl;

import static utility.Constants.WORLD_HEIGHT;
import static utility.Constants.WORLD_WIDTH;

/**
 * Created by gerard on 12/02/2017
 * Update: Feb/2019
 */

public class GameScreenTBW extends ScreenAdapter {
    private FitViewport viewport;
    private SpriteBatch batch;
    private TBWGame tbwGame;
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;
    private BitmapFont font;
    private GameControl control;


    public GameScreenTBW(TBWGame tbwGame){
        this.tbwGame = tbwGame;
        font = new BitmapFont(Gdx.files.internal(Constants.fontPath));
    }

    @Override
    public void show() {
        super.show();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, CameraControl.getInstance().getCamera());
        viewport.apply(true);
        batch = new SpriteBatch();

        control = new GameControl();
        Gdx.input.setInputProcessor(control);

        tiledMap = tbwGame.getAssetManager().get("tileData/floorTiles.tmx");
        orthogonalTiledMapRenderer = new
                OrthogonalTiledMapRenderer(tiledMap, batch);
        orthogonalTiledMapRenderer.setView(CameraControl.getInstance().getCamera());
    }

    @Override
    public void render(float delta) {
        control.update();
        clearScreen();
        draw();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g,
                Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void draw() {
        batch.setProjectionMatrix(CameraControl.getInstance().getCamera().projection);
        batch.setTransformMatrix(CameraControl.getInstance().getCamera().view);
        batch.begin();
            font.draw(batch,control.getDisplayMsg(),
                Gdx.graphics.getWidth()/8,Gdx.graphics.getHeight()/2);
        batch.end();
        orthogonalTiledMapRenderer.render();
    }
}