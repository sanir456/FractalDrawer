import java.awt.Color;

public class Triangle {
    private double xPos;
    private double yPos;
    private double width;
    private double height;
    private Color color;

    public Triangle(double xPos,double yPos, double width, double height)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    // perimeter = 2*a + b
    public double calculatePerimeter()
    {
        return (2.0)*(this.height) + this.width;
    }

    // area = (b*h)/2 where h = sqrt(a^2 - b^2/4)
    public double calculateArea(){
        return (this.width * (Math.sqrt(Math.pow(this.height, 2) -(Math.pow(this.width, 2))/(4.0))))/2.0;
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
