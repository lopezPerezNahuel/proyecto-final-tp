package logica;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class Entrada extends InputAdapter {

    ControladorVirtual controlador;

    public Entrada(ControladorVirtual controlador) {
        this.controlador = controlador;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Input.Keys.LEFT:
            case Input.Keys.A:
                if(!controlador.moverDerecha){
                    controlador.moverIzquierda = true;
                }
                return true;

            case Input.Keys.RIGHT:
            case Input.Keys.D:
                if(!controlador.moverIzquierda){
                    controlador.moverDerecha = true;
                }
                return true;

            case Input.Keys.UP:
            case Input.Keys.W:
                if(!controlador.moverAbajo){
                    controlador.moverArriba = true;
                }
                return true;

            case Input.Keys.DOWN:
            case Input.Keys.S:
                if(!controlador.moverArriba){
                    controlador.moverAbajo = true;
                }
                return true;

            default:
                return false;
        }
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case Input.Keys.LEFT:
            case Input.Keys.A:
                controlador.moverIzquierda = false;
                return false;

            case Input.Keys.RIGHT:
            case Input.Keys.D:
                controlador.moverDerecha = false;
                return false;

            case Input.Keys.UP:
            case Input.Keys.W:
                controlador.moverArriba = false;
                return false;

            case Input.Keys.DOWN:
            case Input.Keys.S:
                controlador.moverAbajo = false;
                return false;

            default:
                return false;
        }
    }



}

