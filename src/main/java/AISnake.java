import geometrical_components.Point;

import java.awt.*;

public class AISnake extends Snake {
    public AISnake(Point pos, Handler handler){
        super(pos, handler);
        color = Color.red;
    }

    public void tick(){
//        AIPathing();
        super.tick();
    }



    public void render(Graphics g){
        super.render(g);
    }
}