package io.github.elliotgba;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Flock {

    static SpriteBatch batch = new SpriteBatch();
    static List<Boid> flock = new ArrayList<>();

    public Flock() {

    }

    public static void newBoid(int x, int y) {
        flock.add(new Boid(x, y));
    }

    public static void update() {
        for (Boid b : flock) {
            b.update();
        }
    }

    public static void display() {
        batch.begin();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // clear the screen
        for (Boid b : flock) {
            b.render();
        }

        batch.end();
    }

}
