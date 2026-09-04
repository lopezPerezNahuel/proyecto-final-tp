package pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mijuego.MainGame;

public class PantallaNumero extends PantallaBase{

    private int numero;
    private BitmapFont font;

    private SpriteBatch batch;

    public PantallaNumero(MainGame game, int numero) {
        super(game);
        this.numero = numero;
        font = new BitmapFont();

        batch = game.getSB();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.draw(batch, Integer.toString(numero), Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);

        batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.NUM_1)){
            game.setScreen(game.uno);
        }else if (Gdx.input.isKeyPressed(Input.Keys.NUM_2)){
            game.setScreen((game.dos));
        }


    }

    @Override
    public void dispose() {
        super.dispose();
        font.dispose();
    }
}
