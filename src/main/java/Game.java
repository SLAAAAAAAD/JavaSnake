import geometrical_components.Point;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Game extends Canvas implements Runnable {

    private Thread thread;
    private boolean running = false;

    private Handler handler;
    private Camera camera;

    public static int width = 800;
    public static int height = 800;

    public Game() {
        camera = new Camera(width, height, .05, 50);
        handler = new Handler(camera);
        this.setSize(width, height);
        this.addKeyListener(new KeyInput(handler));
        Window window = new Window(width, height, "Game", this);
        start();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
        PlayerSnake player = new PlayerSnake(new Point(width / 2, height / 2), handler);
        ArrayList<AISnake> baddies = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            baddies.add(new AISnake(new Point(width / 3, height / 3), handler));
        }
        handler.getCamera().setTarget(player);
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        Double amountOfTicks = 60.0;
        Double ns = 1000000000 / amountOfTicks;
        Double delta = 0.0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(10);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        handler.render(g);

        g.dispose();
        bs.show();
    }
}
