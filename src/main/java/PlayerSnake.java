import geometrical_components.Point;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Map;

public class PlayerSnake extends Snake{

    public PlayerSnake(Point pos, Handler handler){
        super(pos, handler);
        color = Color.blue;
    }

    public void tick(){
        handleKeyInput();
        super.tick();
    }

    private void handleKeyInput() {
        if (KeyInput.keyPressMap != null) {
            Map<Integer, Boolean> keyMap = KeyInput.keyPressMap;

            if (keyMap.get(KeyEvent.VK_LEFT)) {
                speed.translateX(0 - accel);
            }
            if (keyMap.get(KeyEvent.VK_RIGHT)) {
                speed.translateX(accel);
            }
            if (keyMap.get(KeyEvent.VK_UP)) {
                speed.translateY(0 - accel);
            }
            if (keyMap.get(KeyEvent.VK_DOWN)) {
                speed.translateY(accel);
            }
            if (keyMap.get(KeyEvent.VK_HOME)) {
                speed.translateX(0 - accel * Math.sqrt(2) / 2);
                speed.translateY(0 - accel * Math.sqrt(2) / 2);
            }
            if (keyMap.get(KeyEvent.VK_PAGE_UP)) {
                speed.translateX(accel * Math.sqrt(2) / 2);
                speed.translateY(0 - accel * Math.sqrt(2) / 2);
            }
            if (keyMap.get(KeyEvent.VK_END)) {
                speed.translateX(0 - accel * Math.sqrt(2) / 2);
                speed.translateY(accel * Math.sqrt(2) / 2);
            }
            if (keyMap.get(KeyEvent.VK_PAGE_DOWN)) {
                speed.translateX(accel * Math.sqrt(2) / 2);
                speed.translateY(accel * Math.sqrt(2) / 2);
            }
        }
    }

    public void render(Graphics g){
        super.render(g);
    }
}
