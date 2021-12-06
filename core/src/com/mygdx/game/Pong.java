package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Pong extends Game {

    SpriteBatch batch;
    BitmapFont bitmapFont;

    @Override
    public void create () {
        batch = new SpriteBatch();
        bitmapFont = new BitmapFont(Gdx.files.internal(("PongFont.fnt")));
        bitmapFont.setColor(1f, 1f, 1f, 0.5f);
        this.setScreen(new MenuScreen(this));
    }



    @Override
    public void render () {
        super.render();
    }


    @Override
    public void dispose () {
        batch.dispose();
        bitmapFont.dispose();

    }


}
