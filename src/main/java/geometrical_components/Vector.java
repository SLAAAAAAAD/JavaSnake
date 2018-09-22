package geometrical_components;

public class Vector {
    private double x;
    private double y;

    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void vectorAdd(Vector p){
        x += p.getX();
        y += p.getY();
    }

    public void translateX(double x){
        this.x += x;
    }

    public void translateY(double y){
        this.y += y;
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
