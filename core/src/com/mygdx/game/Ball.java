package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Ball extends GameObject {

    private float speed;
    private Vector2 direction;
    private GameScreen game;
    private float MaxSpeed = 1200;

    public Ball(Vector2 pos, GameScreen game) {
        super(pos, 12, 12, new Color(0.9f, 0.9f, 0.95f, 1));
        this.speed = 300f;
        this.direction = new Vector2(-1, 2f);
        this.direction.nor();
        this.game = game;
    }

    private boolean checkOverlapping(GameObject other){
         return this.left() < other.right() &&
                this.right() > other.left() &&
                this.top() > other.bottom() &&
                 this.bottom() < other.top();
    }


    public void reset(){
        this.pos.x = (Gdx.graphics.getWidth() / 2) - 6;
        this.pos.y = (Gdx.graphics.getHeight() / 2) - 6;
        this.speed = 500f;
        this.direction = new Vector2(-1, 2f);
        this.direction.nor();
    }

    public void IncreaseSpeed() {
        if (this.speed < MaxSpeed) {
            this.speed *= 1.2f;
        }
    }

    public void update(Player player, AI ai) {
        super.update();
        float dt = Gdx.graphics.getDeltaTime();

        Vector2 movement = direction.cpy().scl(speed * dt);

        this.pos.x += movement.x;
        this.pos.y += movement.y;

        if (checkOverlapping(player)) {
            float colHOP = player.pos.y - pos.y;
            this.direction.y = MathUtils.map(61f, -61f, -1, 1, colHOP);
            this.direction.nor();
            this.direction.x *= -1;
            this.pos.x = player.right();
        } else if (checkOverlapping(ai)) {
            float colHOP = ai.pos.y - pos.y;
            this.direction.y = MathUtils.map(61f, -61f, -1, 1, colHOP);
            this.direction.nor();
            this.direction.x *= -1;
            this.pos.x = ai.left() - width;
        }

        if (bottom() < 0) {
            this.pos.y = 0;
            this.direction.y *= -1;
        } else if (top() > Gdx.graphics.getHeight()) {
            this.pos.y = Gdx.graphics.getHeight() - height;
            this.direction.y *= -1;
        }
        if (left() < 0) {
            reset();
            IncreaseSpeed();
            this.game.incrementAiScore();
        } else if (right() > Gdx.graphics.getWidth()) {
            reset();
            IncreaseSpeed();
            this.game.incrementPlayerScore();
        }
    }

}
