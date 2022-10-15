// FractalDrawer class draws a fractal of a shape indicated by user input 
import java.awt.Color;

import java.util.Scanner;

import java.awt.*;
import java.util.concurrent.*;
 
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ListIterator;

import javax.swing.JApplet;
import javax.swing.JFrame;

import java.util.Random;


public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total area

    public FractalDrawer() {}  // contructor


    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
        Canvas can = new Canvas(1500, 1500);
        
        // random color
        Random rand = new Random();
        float red = rand.nextFloat();
        float green = rand.nextFloat();
        float blue = rand.nextFloat();
        Color randomColor = new Color(red, green, blue);

        if (type.equals("circle")){
            drawCircleFractal(300.0, 350.0, 350.0, randomColor, can, 7);
            return totalArea;
        }
        else if(type.equals("rectangle")){
            drawRectangleFractal(150.0, 150.0, 300.0, 300.0,randomColor,can, 7);
            return totalArea;
        }
        else if(type.equals("triangle")){
            drawTriangleFractal(250.0, 250.0, 500.0, 600.0, randomColor, can,7);
            return totalArea;
        }
        else{
            System.out.println("No this choice!");
            return totalArea;
        }
        
    }


    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        Triangle myTriangle = new Triangle(x, y, width, height);
        myTriangle.setColor(c);
        if(level == 0) {
            can.drawShape(myTriangle);
            this.totalArea = myTriangle.calculateArea();
        }
        else {
            double w_new = 0.5*myTriangle.getWidth();
            double h_new = 0.5*myTriangle.getHeight();
            Triangle myTriangle1 = new Triangle(myTriangle.getXPos()-0.5*myTriangle.getWidth(), myTriangle.getYPos(), w_new, h_new);
            Triangle myTriangle2 = new Triangle(myTriangle.getXPos()+myTriangle.getWidth(), myTriangle.getYPos(), w_new, h_new);
            Triangle myTriangle3 = new Triangle(myTriangle.getXPos()+ 0.5*w_new,myTriangle.getYPos()-myTriangle.getHeight(), w_new, h_new);
            
            Random rand = new Random();
            float red = rand.nextFloat();
            float green = rand.nextFloat();
            float blue = rand.nextFloat();
            Color randomColor = new Color(red, green, blue);
            
            myTriangle1.setColor(randomColor);
            myTriangle2.setColor(randomColor);
            myTriangle3.setColor(randomColor);
            
            can.drawShape(myTriangle);

            this.totalArea += myTriangle.calculateArea();
            this.totalArea += myTriangle1.calculateArea();
            this.totalArea += myTriangle2.calculateArea();
            this.totalArea += myTriangle3.calculateArea();
            
            drawTriangleFractal(w_new, h_new, myTriangle.getXPos()-0.5*myTriangle.getWidth(),myTriangle.getYPos(),randomColor, can, level-1);
            drawTriangleFractal(w_new, h_new, myTriangle.getXPos()+myTriangle.getWidth(), myTriangle.getYPos(),randomColor, can, level-1);
            drawTriangleFractal(w_new, h_new, myTriangle.getXPos()+ 0.5*w_new,myTriangle.getYPos()-myTriangle.getHeight(),randomColor, can, level-1);
        }
    }

    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        Circle myCircle = new Circle(x, y, radius);
        myCircle.setColor(c);
        can.drawShape(myCircle);
        if(level == 0){
            can.drawShape(myCircle);
            this.totalArea = myCircle.calculateArea();
        }
        else{
            double R = myCircle.getRadius();
            double r = R*Math.sqrt(3)/(2+Math.sqrt(3));
            
            double b = r/Math.sqrt(3);
            double a = b*Math.sqrt(3);
            Circle myCircle1 = new Circle(myCircle.getXPos() - a,myCircle.getYPos() + b, r);
            Circle myCircle2 = new Circle(myCircle.getXPos() + a,myCircle.getYPos() + b, r);
            Circle myCircle3 = new Circle(myCircle.getXPos(), myCircle.getYPos()- 2*b, r);
            
            Random rand = new Random();
            float red = rand.nextFloat();
            float green = rand.nextFloat();
            float blue = rand.nextFloat();
            Color randomColor = new Color(red, green, blue);
            
            myCircle1.setColor(randomColor);
            myCircle2.setColor(randomColor);
            myCircle3.setColor(randomColor);
            
            can.drawShape(myCircle1);
            can.drawShape(myCircle2);
            can.drawShape(myCircle3);
            
            drawCircleFractal(r, myCircle.getXPos() - a, myCircle.getYPos() + b,randomColor, can, level-1);
            drawCircleFractal(r, myCircle.getXPos() + a, myCircle.getYPos() + b,randomColor, can, level-1);
            drawCircleFractal(r, myCircle.getXPos(), myCircle.getYPos() - 2*b,randomColor, can, level-1);
            
            this.totalArea += myCircle.calculateArea();
            this.totalArea += myCircle1.calculateArea();
            this.totalArea += myCircle2.calculateArea();
            this.totalArea += myCircle3.calculateArea();
        }
    }


    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        Rectangle myRectangle = new Rectangle(x, y, width, height);
        myRectangle.setColor(c);
        if(level == 0){
            this.totalArea = myRectangle.calculateArea();
        }
        else{
            double w_new = 0.5*myRectangle.getWidth();
            double h_new = 0.5*myRectangle.getHeight();
            double pos_x1 = myRectangle.getXPos() - w_new;
            double pos_x2 = myRectangle.getXPos() - w_new;
            double pos_x3 = myRectangle.getXPos() + myRectangle.getWidth();
            double pos_x4 = myRectangle.getXPos() + myRectangle.getWidth();
            double pos_y1 = myRectangle.getYPos() - h_new;
            double pos_y2 = myRectangle.getYPos() + myRectangle.getHeight();
            double pos_y3 = myRectangle.getYPos() - h_new;
            double pos_y4 = myRectangle.getYPos() + myRectangle.getHeight();
            
            Rectangle myRectangle1 = new Rectangle(pos_x1, pos_y1, w_new, h_new);
            Rectangle myRectangle2 = new Rectangle(pos_x2, pos_y2, w_new, h_new);
            Rectangle myRectangle3 = new Rectangle(pos_x3, pos_y3, w_new, h_new);
            Rectangle myRectangle4 = new Rectangle(pos_x4, pos_y4, w_new, h_new);
            
            Random rand = new Random();
            float red = rand.nextFloat();
            float green = rand.nextFloat();
            float blue = rand.nextFloat();
            Color randomColor = new Color(red, green, blue);
            
            myRectangle1.setColor(randomColor);
            myRectangle2.setColor(randomColor);
            myRectangle3.setColor(randomColor);
            myRectangle4.setColor(randomColor);
            
            can.drawShape(myRectangle);
            drawRectangleFractal(w_new, h_new, pos_x1, pos_y1, randomColor, can, level-1);
            drawRectangleFractal(w_new, h_new, pos_x2, pos_y2, randomColor, can, level-1);
            drawRectangleFractal(w_new, h_new, pos_x3, pos_y3, randomColor, can, level-1);
            drawRectangleFractal(w_new, h_new, pos_x4, pos_y4, randomColor, can, level-1);
            
            this.totalArea += myRectangle.calculateArea();
            this.totalArea += myRectangle1.calculateArea();
            this.totalArea += myRectangle2.calculateArea();
            this.totalArea += myRectangle3.calculateArea();
            this.totalArea += myRectangle4.calculateArea();
        }
    }

    //TODO:
    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Please input your choice from circle, rectangle and triangle: ");
        String type = s.nextLine();
        System.out.println("(NOTE: image might be messied up due to canvas issue, decrease the level number if that occurs!)");
        FractalDrawer fractalDrawer = new FractalDrawer();
        
        double result = fractalDrawer.drawFractal(type);
        System.out.println("The Total Area is: " + result);
        s.close();
       
       
    }
}



class Circle{
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

class Triangle {
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

class Rectangle {
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


class Canvas extends JApplet {

	
	private int height;
	private int width;
	private CopyOnWriteArrayList<Circle> circles;
	private CopyOnWriteArrayList<Triangle> triangles;
	private CopyOnWriteArrayList<Rectangle> rectangles;
	
	public Canvas() {
		JFrame f = new JFrame("Canvas");
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});
		height = 800;
		width = 800;
		f.setSize(width, height);
		f.getContentPane().add(this);
		circles = new CopyOnWriteArrayList<Circle>();
		rectangles = new CopyOnWriteArrayList<Rectangle>();
		triangles = new CopyOnWriteArrayList<Triangle>();
		f.setVisible(true);
	}
	
	public Canvas(int h, int w) {
		JFrame f = new JFrame("Canvas");
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});
		height = h;
		width = w;
		f.setSize(width, height);
		f.getContentPane().add(this);
		circles = new CopyOnWriteArrayList<Circle>();
		rectangles = new CopyOnWriteArrayList<Rectangle>();
		triangles = new CopyOnWriteArrayList<Triangle>();
		f.setVisible(true);
	}
	
	public void paint(Graphics g) {
		Image buffer = createImage(width,height);
		drawToBuffer(buffer.getGraphics());
		g.drawImage(buffer,0,0,null);
	}

	public void drawToBuffer(Graphics g){	
		ListIterator<Circle> circItr = circles.listIterator();
		ListIterator<Rectangle> recItr = rectangles.listIterator();
		ListIterator<Triangle> triItr = triangles.listIterator();

		while (circItr.hasNext()) {
			Circle curCircle = circItr.next();
			g.setColor(curCircle.getColor());
			int curRadius = (int)curCircle.getRadius();
			g.fillOval((int)curCircle.getXPos() - curRadius, (int)curCircle.getYPos()
					- curRadius, 2 * curRadius, 2 * curRadius);

		}

		while (recItr.hasNext()) {
			Rectangle curRectangle = recItr.next();
			g.setColor(curRectangle.getColor());
			g.fillRect((int)curRectangle.getXPos(), (int)curRectangle.getYPos(),
					(int)curRectangle.getWidth(), (int)curRectangle.getHeight());
		}

		while (triItr.hasNext()) {
			Triangle curTriangle = triItr.next();
			g.setColor(curTriangle.getColor());
			Polygon po = new Polygon();
			po.addPoint((int)curTriangle.getXPos(), (int)curTriangle.getYPos());
			po.addPoint((int)(curTriangle.getXPos() + curTriangle.getWidth()), (int)curTriangle
					.getYPos());
			po.addPoint((int)(curTriangle.getXPos() + curTriangle.getWidth() / 2), (int)(curTriangle.getYPos() - curTriangle.getHeight()));
			g.fillPolygon(po);
		}
	}
	
	
	public void drawShape(Circle circ){
		circles.add(circ);
	}
	
	public void drawShape(Rectangle rec){
		rectangles.add(rec);
	}
	
	public void drawShape(Triangle tri){
		triangles.add(tri);
	}
	
	public void clear(){
		circles.clear();
		rectangles.clear();
		triangles.clear();
	}
	

}