package pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mijuego.MainGame;

public class PantallaAnimacion extends PantallaBase {

    private SpriteBatch batch;

    public PantallaAnimacion(MainGame game) {
        super(game);
        batch = game.getSB();
    }


    // ... (resto de tus declaraciones)
    public Animation<TextureRegion> ellieAnimation;
    public Texture ellie;
    public TextureRegion[] ellieFrames;
    public float duracion;
    //private TextureRegion

    // Supongamos que calculaste que cada cuadro mide 25px de ancho tras recortar en Gimp
    private static final int ANCHO_CUADRO = 21;
    private static final int ALTO_CUADRO = 32;

    // Variables para el movimiento
    private float posY = 400; // Posición inicial en X
    private float velocidad = 1f; // Pixeles por segundo



    @Override
    public void show() {
        ellie = new Texture("SpriteEllie.png");

        TextureRegion[][] temp = TextureRegion.split(ellie, ANCHO_CUADRO, ALTO_CUADRO);

        ellieFrames = new TextureRegion[6]; // Cambiado a 6
        for (int i = 0; i < 6; i++) {
            ellieFrames[i] = temp[0][i];
        }

        ellieAnimation = new Animation<>(0.2f, ellieFrames);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Actualizamos el tiempo de animación
        duracion += delta;

        // Movemos al personaje para que camine
        posY += velocidad * delta;
       // if (posY > 800)
            posY -= velocidad; // Loop de pantalla

        TextureRegion frame = ellieAnimation.getKeyFrame(duracion, true);

        batch.begin();

        // 2. DIBUJAMOS EL PRIMER AUTO (lo haremos 3 veces para simular tráfico)
        // Usamos la variable 'posX' para moverlo. El ancho de dibujo es el mismo del recorte.
        batch.draw(frame, 100, posY, ANCHO_CUADRO * 2, ALTO_CUADRO * 2);

        batch.end();
    }
}
