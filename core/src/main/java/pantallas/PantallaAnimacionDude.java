package pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.mijuego.MainGame;

public class PantallaAnimacionDude extends PantallaBase{

    private SpriteBatch batch;

    private Texture dude;
    private TextureRegion dudeRegion;
    private TextureRegion[] dudeFrames;
    TextureRegion frame;

    private Animation dudeAnimation;

    private static final int velocidad = 100;
    private static final int ANCHO = 252, ALTO = 49;
    private float duracion;

    public PantallaAnimacionDude(MainGame game) {
        super(game);
        this.batch = game.getSB();
    }



    @Override
    public void show() {
        dude = new Texture("caminador.png");
        dudeRegion = new TextureRegion(dude, ANCHO,ALTO);
        TextureRegion[][] temp = dudeRegion.split(ANCHO / 9, ALTO);
        dudeFrames = new TextureRegion[temp.length * temp[0].length];
        int indice = 0;

        for(int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                dudeFrames[indice++] = temp[i][j];

            }

        }

        dudeAnimation = new Animation(0.1f, dudeFrames);
    }



    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(1f,0.5f,05f,1);

        duracion += delta;
        frame= (TextureRegion) dudeAnimation.getKeyFrame(duracion, true);
        batch.begin();
        batch.draw(frame,100,100);
        batch.end();
    }


}
