import sun.plugin2.message.GetAppletMessage;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    public Window(int width, int height, String title, Game sim) {
        JFrame frame = new JFrame(title);

        frame.add(new JPanel(){
            @Override
            public Dimension getPreferredSize(){
                return new Dimension(width, height);
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLocation(600, 100);
        frame.add(sim);
        frame.pack();
        frame.setVisible(true);
    }
}
