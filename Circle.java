
import java.awt.Color;

public class Circle{
    private double xPos;
    private double yPos;
    private double radius;
    private Color color;

    public Circle(double xPos,double yPos,double redius)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = redius;
    }

    public double calculatePerimeter(){
        return (2.0)*(3.14)*(this.radius);
    }

    public double calculateArea(){
        return (3.14)*(this.radius)*(this.radius);
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void setPos(double xPos,double yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public Color getColor(){
        return this.color;
    }

    public double getXPos(){
        return this.xPos;
    }

    public double getYPos(){
        return this.yPos;
    }

    public double getRadius(){
        return this.radius;
    }

}