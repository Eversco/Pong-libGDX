package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.mygdx.game.MenuScreen.SCREEN_H;
import static com.mygdx.game.MenuScreen.SCREEN_W;

public class GameScreen implements Screen {

    final Pong game;


    Player player;
    AI ai;
    Ball ball;

    int PlayerScore = 0;
    int AiScore = 0;

    OrthographicCamera camera;

    public GameScreen(final Pong game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_W, SCREEN_H);

        player = new Player(new Vector2(100, (Gdx.graphics.getHeight() / 2)));
        ai = new AI(new Vector2(Gdx.graphics.getWidth() - 100, (Gdx.graphics.getHeight() / 2)));
        ball = new Ball(new Vector2((Gdx.graphics.getWidth() / 2) - 6, (Gdx.graphics.getHeight() / 2) - 6), this);
    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        player.update();
        ai.update(ball, player);
        ball.update(player, ai);

        if (PlayerScore >= 5 ) {
            game.setScreen((new GameOver(game, true)));

        } else if (AiScore >= 5) {
            game.setScreen((new GameOver(game, false)));
        }

        ScreenUtils.clear(0.1f, 0.1f, 0.15f, 1);
        game.batch.begin();
        player.draw(game.batch);
        ai.draw(game.batch);
        ball.draw(game.batch);
        game.batch.end();

        game.batch.begin();
        game.bitmapFont.draw(game.batch, Integer.toString(PlayerScore), Gdx.graphics.getWidth() / 4, 300);
        game.bitmapFont.draw(game.batch, Integer.toString(AiScore), 3 * (Gdx.graphics.getWidth() / 4), 300);
        game.batch.end();
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


    public void incrementPlayerScore() {
        PlayerScore++;
    }

    public void incrementAiScore() {
        AiScore++;
    }

}
