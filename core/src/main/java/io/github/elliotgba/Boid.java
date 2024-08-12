package io.github.elliotgba;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;

public class Boid {

    private ShapeRenderer shape;
    private Polygon polygon;
    private float x;
    private float y;
    private int width = 20;
    private int height = 20;
    private int rotation;
    private int speed = 5;

    public Boid(int x, int y) {
        this.x =(float) x - width/2;
        this.y =(float) 680 - y - height/2; // subtract screen height because libgdx coordinates are inverted
        this.shape = new ShapeRenderer();

        float[] vertices = {
            0, 0,                      // bottom-left
            width / 2f, height,        // top
            width, 0                   // bottom-right
        };

        // Create the polygon using the vertices
        this.polygon = new Polygon(vertices);
        this.polygon.setPosition(this.x, this.y);

        // apply a random rotation between 0 and 360 degrees
        rotation = MathUtils.random(0, 360);
        this.polygon.setRotation(rotation);
    }

    public void render() {
        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.setColor(Color.RED);

        shape.polygon(polygon.getTransformedVertices());
        shape.end();
    }

    public void update() {
        newRotation();
        calculateMove();
    }

    public void move(float deltaX, float deltaY) {
        x += deltaX;
        y += deltaY;

        polygon.translate(deltaX, deltaY);
    }

    public void calculateMove() {
        float radians = MathUtils.degRad * rotation;
        // calculate change in x and y based on current rotation
        float deltaX = MathUtils.cos(radians) * speed;
        float deltaY = MathUtils.sin(radians) * speed;

        move(deltaX, deltaY);
    }

    public void newRotation() {
        int rotationChange = MathUtils.random(0, 5);
        rotation += rotationChange;
    }


    public Polygon getPolygon() {
        return polygon;
    }

    public void dispose() {
        shape.dispose();
    }
}
