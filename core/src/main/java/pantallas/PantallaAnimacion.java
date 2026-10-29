package pantallas;

import personaje.Ellie;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mijuego.MainGame;
import entrada.ControladorVirtual;
import entrada.Entrada;
import mapa.GestorMapa; // Importas tu nueva clase

public class PantallaAnimacion extends PantallaBase {

    private SpriteBatch batch;
    private Ellie ellie;
    private ControladorVirtual controlador;
    private Entrada entrada;

    // Reemplazamos mapa, renderer y cámara por el gestor
    private GestorMapa gestorMapa;

    public PantallaAnimacion(MainGame game) {
        super(game);
        batch = game.getSB();
    }

    @Override
    public void show() {
        controlador = new ControladorVirtual();
        entrada = new Entrada(controlador);

        ellie = new Ellie(949, 150, controlador);
        Gdx.input.setInputProcessor(entrada);


        gestorMapa = new GestorMapa();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // 1. Actualizar personaje
        ellie.actualizar(delta);
        ellie.actualizarMovimiento();

        gestorMapa.actualizar(ellie);

        gestorMapa.render(batch);

        batch.begin();
        ellie.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        if (ellie != null) {
            ellie.dispose();
        }
        if (gestorMapa != null) {
            gestorMapa.dispose();
        }
    }
}

