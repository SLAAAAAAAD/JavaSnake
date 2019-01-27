import java.awt.*;

public class GameObject {

    protected ID id;

    public GameObject(ID id) {
        this.id = id;
    }

    public void render(Graphics g) {

    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
