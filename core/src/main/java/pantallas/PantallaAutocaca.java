package pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mijuego.MainGame;

public class PantallaAutocaca extends PantallaBase{


    SpriteBatch batch;

    private static final int velocidad = 100;

    private Texture auto;
    private int height, width;

    private Sprite miAuto;

    public PantallaAutocaca(MainGame game) {
        super(game);
        this.batch = game.getSB();
    }

    @Override
    public void show() {
        auto = new Texture("img_1.png");
        height = Gdx.graphics.getHeight();
        width = Gdx.graphics.getWidth();

        miAuto = new Sprite(auto,0,0,550,284);
        miAuto.setPosition(0,0);
        miAuto.setFlip(true, false);
        miAuto.setScale(0.3f,0.3f);
    }

    @Override
    public void render(float delta) {
        renderizarJuego();
        entradaTeclado();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


    private void entradaTeclado() {
        boolean arriba = Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean abajo = Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN);
        boolean izquierda = Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean derecha = Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT);

        float x = miAuto.getX(), y = miAuto.getY();
        float delta = Gdx.graphics.getDeltaTime();
        if (arriba && !abajo) y += velocidad * delta;
        if (abajo && !arriba) y -= velocidad * delta;
        if (izquierda && !derecha) x -= velocidad * delta;
        if (derecha && !izquierda) x+= velocidad * delta;

        actualizarPoscicion(x,y);
    }

    private void actualizarPoscicion(float x, float y){
        miAuto.setPosition(x,y);
    }



    private void renderizarJuego() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        miAuto.draw(batch);
        batch.end();
    }
}
