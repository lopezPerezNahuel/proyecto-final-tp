package com.mijuego;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pantallas.*;


public class MainGame extends Game {
    private SpriteBatch batch;
    public PantallaBase uno;
    public PantallaBase dos;
    public PantallaAutopro autopro;
    public PantallaAutocaca autocaca;
    public PantallaAuto auto;
    public PantallaAnimacionDude dude;
    public PantallaAnimacion animacion;

    @Override
    public void create() {
       batch = new SpriteBatch();
        animacion = new PantallaAnimacion(this);
       setScreen(animacion);
    }

    public SpriteBatch getSB(){
        return batch;
    }

    @Override
    public void dispose(){
        super.dispose();
    }

}



