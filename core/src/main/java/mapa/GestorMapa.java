package mapa;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import personaje.Ellie;

public class GestorMapa {
    private TiledMap mapa;
    private OrthogonalTiledMapRenderer rendererMapa;
    private OrthographicCamera camera;
    private int width, height;

    public GestorMapa() {
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

        mapa = new TmxMapLoader().load("mapas/Biblioteca.tmx");
        rendererMapa = new OrthogonalTiledMapRenderer(mapa);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, width / 2, height / 2);
    }



    public void actualizar(Ellie ellie) {
        camera.position.x = ellie.getHitboxEllie().x + ellie.getALTO_CUADRO();
        camera.position.y = ellie.getHitboxEllie().y + ellie.getANCHO_CUADRO();
        camera.update();
    }

    public void render(SpriteBatch batch) {

        rendererMapa.setView(camera);
        rendererMapa.render();

        batch.setProjectionMatrix(camera.combined);
    }

    public void dispose() {
        if (mapa != null) {
            mapa.dispose();
        }
        if (rendererMapa != null) {
            rendererMapa.dispose();
        }
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public TiledMap getMapa() {
        return mapa;
    }
}
