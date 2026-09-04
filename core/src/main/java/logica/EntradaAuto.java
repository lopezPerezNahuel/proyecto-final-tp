package logica;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

public class EntradaAuto extends InputAdapter {

    ControladorVirtual controlador;

    public EntradaAuto(ControladorVirtual controlador) {
        this.controlador = controlador;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Input.Keys.LEFT:
            case Input.Keys.A:
                if(!controlador.moverDerecha){
                    controlador.moverIzquierda = true;
                    return true;
                }
            case Input.Keys.RIGHT:
            case Input.Keys.D:
                if(!controlador.moverIzquierda){
                    controlador.moverDerecha = true;
                    return true;
                }
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
                return true;
            case Input.Keys.RIGHT:
            case Input.Keys.D:
                controlador.moverDerecha = false;
                return true;
            default:
                return false;
        }
    }


}

