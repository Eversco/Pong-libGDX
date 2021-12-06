package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class AI extends Paddle{

    private float speed = 80f;

    public AI(Vector2 pos) {
        super(pos);
    }

    public void update(Ball ball, Player player) {
        super.update();
        Vector2 target = new Vector2(Gdx.graphics.getWidth() - 100, ball.center().y);
        float playerCenterVertical = player.pos.y + 30;



        if (ball.center().x > (Gdx.graphics.getWidth() / 2)){
            this.speed = 100f;
        } else {
            this.speed = 50f;
        }

        if (playerCenterVertical > 400) {
            pos.lerp(target, speed * Gdx.graphics.getDeltaTime());
        } else if (playerCenterVertical < 200) {
            pos.lerp(target.sub(0, 60), speed * Gdx.graphics.getDeltaTime());
        } else {
            pos.lerp(target.sub(0, 30), speed * Gdx.graphics.getDeltaTime());
        }

    }
}
