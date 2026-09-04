package pantallas;

import autos.Auto;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mijuego.MainGame;
import logica.ControladorVirtual;
import logica.Entrada;

public class PantallaAuto extends PantallaBase{

    private SpriteBatch batch;
    private Auto auto;
    private ControladorVirtual controlador;
    private Entrada entradaAuto;




    public PantallaAuto(MainGame game) {
        super(game);
        this.batch = game.getSB();
    }

    @Override
    public void show() {
        auto = new Auto();
        auto.setFlip(true, false);
        auto.setScale(0.2f,0.2f);
        auto.setPosition(40,40);

        controlador = new ControladorVirtual();
        entradaAuto = new Entrada(controlador);
        Gdx.input.setInputProcessor(entradaAuto);

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        auto.draw(batch);
        batch.end();

        if (controlador.moverDerecha){
        auto.entradaTeclado();
        } else if (controlador.moverIzquierda){
            auto.entradaTeclado();
            }



    }
}
