package pantallas;

import personaje.Ellie;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mijuego.MainGame;
import logica.ControladorVirtual;
import logica.Entrada;

public class PantallaAnimacion extends PantallaBase {

    private SpriteBatch batch;
    private Ellie ellie;
    private ControladorVirtual controlador;
    private Entrada entrada;

    public PantallaAnimacion(MainGame game) {
        super(game);
        batch = game.getSB();
    }

    @Override
    public void show() {
        ellie = new Ellie(100, 100);

        controlador = new ControladorVirtual();
        entrada = new Entrada(controlador);
        Gdx.input.setInputProcessor(entrada);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Actualizamos lógica y animación
        ellie.actualizar(delta);

        if (controlador.moverDerecha){
            ellie.entradaTeclado();
        } else if (controlador.moverIzquierda){
            ellie.entradaTeclado();
        } else if (controlador.moverDerecha){
            ellie.entradaTeclado();
        } else if (controlador.moverIzquierda){
            ellie.entradaTeclado();
        }

        // Renderizado usando el método .draw() heredado de Sprite
        batch.begin();
        ellie.draw(batch);
        batch.end();
    }
}
