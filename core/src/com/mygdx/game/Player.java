package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Player extends Paddle {

    public Player(Vector2 pos) {
        super(pos);
    }

    @Override
    public void update() {
        super.update();
        this.pos.y = Gdx.graphics.getHeight() - Gdx.input.getY() - 30;
    }

}
