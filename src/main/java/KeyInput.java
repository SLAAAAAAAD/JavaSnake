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
    }

    // define a map of keyids and preseed/released booleans


    public void keyPressed(KeyEvent e) {
        keyPressMap.put(e.getKeyCode(), true);
//        int key = e.getKeyCode();
//        for (int i = 0; i < handler.objects.size(); i++) {
//            GameObject tempObject = handler.objects.get(i);
//            if (tempObject.getId() == ID.PLAYER) {
//                if (key == KeyEvent.VK_UP) {
//                    keyPressMap.put(key, true);
////                    tempObject.setyMomentum(-1.0);
//                }
//                if (key == KeyEvent.VK_DOWN) {
//                    tempObject.setyMomentum(1.0);
//                }
//                if (key == KeyEvent.VK_LEFT) {
//                    tempObject.setxMomentum(-1.0);
//                }
//                if (key == KeyEvent.VK_RIGHT) {
//                    tempObject.setxMomentum(1.0);
//                }
//            }
//        }
    }

    public void keyReleased(KeyEvent e) {
        keyPressMap.put(e.getKeyCode(), false);
//        int key = e.getKeyCode();
//        for (int i = 0; i < handler.objects.size(); i++) {
//            GameObject tempObject = handler.objects.get(i);
//            if (tempObject.getId() == ID.PLAYER) {
//                if (key == KeyEvent.VK_UP) tempObject.setyMomentum(0.0);
//                if (key == KeyEvent.VK_DOWN) tempObject.setyMomentum(0.0);
//                if (key == KeyEvent.VK_LEFT) tempObject.setxMomentum(0.0);
//                if (key == KeyEvent.VK_RIGHT) tempObject.setxMomentum(0.0);
//            }
//        }
    }
}
