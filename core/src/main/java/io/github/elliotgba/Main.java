package io.github.elliotgba;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    public void init() {
        InputProcessor inputProcessor = new InputProcessor();
        Gdx.input.setInputProcessor(inputProcessor);

    }

    @Override
    public void create() {
        init();
    }

    @Override
    public void render() {
        Flock.update();
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        Flock.display();
    }
}
