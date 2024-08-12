package io.github.elliotgba;

import com.badlogic.gdx.Input;

public class InputProcessor implements com.badlogic.gdx.InputProcessor {
    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            Flock.newBoid(x, y);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int x, int y, int button) {
        if (button == Input.Buttons.LEFT) {
            Flock.newBoid(x, y);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean mouseMoved(int x, int y) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }

}
