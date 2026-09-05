package personaje;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import logica.ControladorVirtual;
import logica.Entrada;

public class Ellie extends Sprite {
    private Animation<TextureRegion> animacion;
    private float tiempoEstado;
    private ControladorVirtual controlador;






    private static final int ANCHO_CUADRO = 21;
    private static final int ALTO_CUADRO = 32;
    private static final int ALTO_ELLIE = ALTO_CUADRO * 2;
    private static final int ANCHO_ELLIE = ANCHO_CUADRO * 2;
    private static final float VELOCIDAD = 150f;



    public Ellie(float x, float y, ControladorVirtual controlador) {
        super();
        this.controlador = controlador;
        tiempoEstado = 0f;


        Texture spriteSheet = new Texture("SpriteEllie.png");
        TextureRegion[][] temp = TextureRegion.split(spriteSheet, ANCHO_CUADRO, ALTO_CUADRO);
        TextureRegion[] ellieFrames = new TextureRegion[5];

        for (int i = 0; i < 5; i++) {
            ellieFrames[i] = temp[0][i];
        }

        animacion = new Animation<>(0.2f, ellieFrames);

        setRegion(ellieFrames[0]);
        setBounds(x, y, ANCHO_ELLIE, ALTO_ELLIE);
    }

    public void actualizar(float delta) {
        boolean seEstaMoviendo = controlador.moverIzquierda ||
            controlador.moverDerecha ||
            controlador.moverArriba ||
            controlador.moverAbajo;
        if (seEstaMoviendo){
            tiempoEstado += delta;
        }else {
            tiempoEstado = 0;
        }
        setRegion(animacion.getKeyFrame(tiempoEstado, true));

    }

    public void entradaTeclado() {
        boolean arriba = Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean abajo = Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN);
        boolean izquierda = Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean derecha = Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT);

        float delta = Gdx.graphics.getDeltaTime();
        float x = getX();
        float y = getY();


        if (controlador.moverIzquierda && !controlador.moverDerecha) {
            x -= VELOCIDAD * delta;
        } else if (controlador.moverDerecha && !controlador.moverIzquierda) {
            x += VELOCIDAD * delta;
        }

// Movimiento Vertical (Eje Y) - ¡SEPARADO DEL HORIZONTAL!
        if (controlador.moverArriba && !controlador.moverAbajo) {
            y += VELOCIDAD * delta;
        } else if (controlador.moverAbajo && !controlador.moverArriba) {
            y -= VELOCIDAD * delta;
        }

        actualizarPoscicion(x, y);
    }
    private void actualizarPoscicion(float x, float y){
        setPosition(x,y);
    }

    public void dispose(){
        getTexture().dispose();
    }

}
