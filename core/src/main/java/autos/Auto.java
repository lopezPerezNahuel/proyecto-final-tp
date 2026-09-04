package autos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Auto extends Sprite {

    private static final int velocidad = 100;


    public Auto() {
        super(new Texture("img_1.png"),0,0,550,284);
    }

    public void entradaTeclado() {
        boolean arriba = Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean abajo = Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN);
        boolean izquierda = Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean derecha = Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT);

        float x = getX(), y = getY();

        // if (arriba && !abajo) y += velocidad * delta;
        // if (abajo && !arriba) y -= velocidad * delta;
        if (izquierda && !derecha) actualizarPoscicion(marchaAtras(x),y);
        else if (derecha && !izquierda) actualizarPoscicion(avanzar(x),y);


    }

    private void actualizarPoscicion(float x, float y){
        setPosition(x,y);
    }

    public float avanzar(float x){
        float delta = Gdx.graphics.getDeltaTime();
        return x+= velocidad * delta;
    }

    public float marchaAtras(float x){
        float delta = Gdx.graphics.getDeltaTime();
        return x -= velocidad * delta;
    }


}
