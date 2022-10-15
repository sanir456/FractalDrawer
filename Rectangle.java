
import java.awt.Color;

public class Rectangle {
    private double xPos;
    private double yPos;   
    private double width;
    private double height;
    private Color color;
    
    public Rectangle(double xPos,double yPos, double width, double height)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    public double calculatePerimeter()
    {
        return (2.0)*(this.height) + (2.0)*(this.width);
    }

    public double calculateArea()
    {
        return this.width * this.width;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public void setPos(double xPos, double yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public Color getColor()
    {
        return this.color;
    }
    
    public double getXPos()
    {
        return this.xPos;
    }

    public double getYPos()
    {
        return this.yPos;
    }

    public double getHeight()
    {
        return this.height;
    }

    public double getWidth()
    {
        return this.width;
    }

}
