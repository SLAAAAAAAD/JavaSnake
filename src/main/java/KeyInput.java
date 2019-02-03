import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public static Map<Integer, Boolean> keyPressMap = new HashMap<>();

    public KeyInput(Handler handler) {
        this.handler = handler;
        this.keyPressMap.put(KeyEvent.VK_UP, false);
        this.keyPressMap.put(KeyEvent.VK_DOWN, false);
        this.keyPressMap.put(KeyEvent.VK_LEFT, false);
        this.keyPressMap.put(KeyEvent.VK_RIGHT, false);
        this.keyPressMap.put(KeyEvent.VK_HOME, false);
        this.keyPressMap.put(KeyEvent.VK_PAGE_UP, false);
        this.keyPressMap.put(KeyEvent.VK_END, false);
        this.keyPressMap.put(KeyEvent.VK_PAGE_DOWN, false);
    }

    public void keyPressed(KeyEvent e) {
        keyPressMap.put(e.getKeyCode(), true);
    }

    public void keyReleased(KeyEvent e) {
        keyPressMap.put(e.getKeyCode(), false);
    }
}
