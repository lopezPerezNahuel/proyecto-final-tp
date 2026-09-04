package pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mijuego.MainGame;

    public class PantallaAutopro extends PantallaBase{
        private SpriteBatch batch;
        private Texture auto;
        private int height, width;
        private Sprite miAuto;

        private float velX = 0;
        private float velY = 0;
        private float aceleracion = 400f;   // Qué tan rápido acelera
        private float friccion = 550f;      // Qué tan rápido frena al soltar las teclas
        private float velocidadMax = 350f;  // Límite de velocidad



        public PantallaAutopro(MainGame game) {
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

            float delta = Gdx.graphics.getDeltaTime();

            // --- MOVIMIENTO VERTICAL (EJE Y) ---
            if (arriba && !abajo) {
                velY += aceleracion * delta; // Acelera hacia arriba
            } else if (abajo && !arriba) {
                velY -= aceleracion * delta; // Acelera hacia abajo
            } else {
                // Fricción: reduce la velocidad poco a poco hasta llegar a 0 si no se presiona nada
                if (velY > 0) {
                    velY -= friccion * delta;
                    if (velY < 0) velY = 0;
                } else if (velY < 0) {
                    velY += friccion * delta;
                    if (velY > 0) velY = 0;
                }
            }

            // --- MOVIMIENTO HORIZONTAL (EJE X) ---
            if (derecha && !izquierda) {
                velX += aceleracion * delta; // Acelera hacia la derecha
            } else if (izquierda && !derecha) {
                velX -= aceleracion * delta; // Acelera hacia la izquierda
            } else {
                // Fricción horizontal
                if (velX > 0) {
                    velX -= friccion * delta;
                    if (velX < 0) velX = 0;
                } else if (velX < 0) {
                    velX += friccion * delta;
                    if (velX > 0) velX = 0;
                }
            }

            // Limitar para que no supere la velocidad máxima (usando MathUtils de LibGDX)
            velX = com.badlogic.gdx.math.MathUtils.clamp(velX, -velocidadMax, velocidadMax);
            velY = com.badlogic.gdx.math.MathUtils.clamp(velY, -velocidadMax, velocidadMax);

            // Aplicar la velocidad calculada a la posición del auto
            float x = miAuto.getX() + velX * delta;
            float y = miAuto.getY() + velY * delta;
            miAuto.setPosition(x, y);
        }


        private void renderizarJuego() {
            ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
            batch.begin();
            miAuto.draw(batch);
            batch.end();
        }
    }

