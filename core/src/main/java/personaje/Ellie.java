package personaje;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import entrada.ControladorVirtual;
import com.badlogic.gdx.math.Rectangle;


public class Ellie {
    private Animation<TextureRegion> animacion;
    private float tiempoEstado;
    private TextureRegion frameActual;
    private ControladorVirtual controlador;


    private  final int ANCHO_CUADRO = 21;
    private  final int ALTO_CUADRO = 32;
    private  final int ALTO_ELLIE = ALTO_CUADRO;
    private  final int ANCHO_ELLIE = ANCHO_CUADRO;

    private static final float VELOCIDAD = 100f;

    private Rectangle hitboxEllie;
    private Texture spriteSheet;
    private TextureRegion[][] temp;
    private TextureRegion[] ellieFrames;
    private float x;
    private float y;

    private void incializarSprite(int x, int y){
        spriteSheet = new Texture("SpriteEllie.png");
        temp = TextureRegion.split(spriteSheet, ANCHO_CUADRO, ALTO_CUADRO);
        ellieFrames = new TextureRegion[5];

        for (int i = 0; i < 5; i++) {
            ellieFrames[i] = temp[0][i];
        }

        animacion = new Animation<>(0.2f, ellieFrames);
        hitboxEllie = new Rectangle(x,y, ANCHO_ELLIE, ALTO_ELLIE);
    }



    public Ellie(int x, int y, ControladorVirtual controlador) {
        this.controlador = controlador;
        tiempoEstado = 0f;
        incializarSprite(x,y);
    }




    public void actualizarMovimiento() {
        boolean arriba = Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean abajo = Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN);
        boolean izquierda = Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean derecha = Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT);

        float delta = Gdx.graphics.getDeltaTime();
        x = this.hitboxEllie.getX();
        y = this.hitboxEllie.getY();


        if (controlador.moverIzquierda && !controlador.moverDerecha) {
            x -= VELOCIDAD * delta;
        } else if (controlador.moverDerecha && !controlador.moverIzquierda) {
            x += VELOCIDAD * delta;
        }

        if (controlador.moverArriba && !controlador.moverAbajo) {
            y += VELOCIDAD * delta;
        } else if (controlador.moverAbajo && !controlador.moverArriba) {
            y -= VELOCIDAD * delta;
        }

        actualizarPosicion(x, y); // actualizarPosicion(x, y);
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
        frameActual = animacion.getKeyFrame(tiempoEstado, true);

    }

    private void actualizarPosicion(float x, float y){
        this.hitboxEllie.setPosition(x,y);
    }

    public void draw(SpriteBatch batch){
        batch.draw(frameActual, hitboxEllie.x,hitboxEllie.y, ANCHO_ELLIE, ALTO_ELLIE);
    }

    public void dispose(){
        this.getSpriteSheet().dispose();
    }

    public Texture getSpriteSheet() {return spriteSheet;}
    public Rectangle getHitboxEllie() {return hitboxEllie;}
    public int getANCHO_CUADRO() {return ANCHO_CUADRO;}
    public int getALTO_CUADRO() {return ALTO_CUADRO;}

}
