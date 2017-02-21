package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by ((ZLoY)) on 21.02.2017.
 */
public class Hero {
    private Texture texture;
    private float speed;
    private Vector2 position;//positionX, positionY

    public Hero() {
        texture = new Texture("ship80x60.tga");
        speed = 8.0f;
        position = new Vector2(100, 100);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            position.y += speed;
            if(position.y > Gdx.graphics.getHeight()) {
                position.y = -texture.getHeight();
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            position.y -= speed;
            if(position.y < -texture.getHeight()) {
                position.y = Gdx.graphics.getHeight();
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            position.x += speed;
            if(position.x > Gdx.graphics.getWidth() - 70) {
                position.x = Gdx.graphics.getWidth() - 70;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            position.x -= speed;
            if(position.x < 0) {
                position.x = 0;
            }
        }
    }
}
