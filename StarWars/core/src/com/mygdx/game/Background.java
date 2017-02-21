package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by ((ZLoY)) on 20.02.2017.
 */
public class Background {
    private Texture texture;

    public Background() {
        texture = new Texture("Spaces.jpg");
    }

    public void Render(SpriteBatch batch) {

        batch.draw(texture, 0, 0);
    }
}
