package personaje;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Ellie extends Sprite {

    private static final int ANCHO_CUADRO = 21;
    private static final int ALTO_CUADRO = 32;
    private static final int ALTO_ELLIE = ALTO_CUADRO * 2;
    private static final int ANCHO_ELLIE = ANCHO_CUADRO * 2;
    private static final float VELOCIDAD = 150f;

    private Animation<TextureRegion> animacion;
    private float tiempoEstado;

    public Ellie(float x, float y) {
        super();
        tiempoEstado = 0f;


        Texture spriteSheet = new Texture("SpriteEllie.png");
        TextureRegion[][] temp = TextureRegion.split(spriteSheet, ANCHO_CUADRO, ALTO_CUADRO);
        TextureRegion[] ellieFrames = new TextureRegion[6];

        for (int i = 0; i < 6; i++) {
            ellieFrames[i] = temp[0][i];
        }

        animacion = new Animation<>(0.2f, ellieFrames);

        setRegion(ellieFrames[0]);
        setBounds(x, y, ANCHO_ELLIE, ALTO_ELLIE);
    }

    public void actualizar(float delta) {
        tiempoEstado += delta;
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

        if (izquierda && !derecha) {
            x -= VELOCIDAD * delta;
        } else if (derecha && !izquierda) {
            x += VELOCIDAD * delta;
        } else if (abajo && !arriba) {
            y -= VELOCIDAD * delta;
        } else if (arriba && !abajo) {
            y += VELOCIDAD * delta;
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
