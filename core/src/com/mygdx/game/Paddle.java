package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Paddle extends GameObject {

    public Paddle(Vector2 pos) {
        super(pos, 20, 60, new Color(0.8f, 0.8f, 0.9f, 1));
    }

}
