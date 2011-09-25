import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Sierpinski extends Applet{
	
	 int x = 0;
	 int y = 0;
	 int delay = 0; // milliseconds
	
	public void init() {
		setBackground(Color.BLACK);
	
	}
	
	public void drawPoint(Graphics g, int x, int y ) {
		g.fillOval(x-2,y-2,2,2);
	}
	
	public void update(Graphics g) {
		
		try {
		  
		   Thread.sleep (0);
		   
		} 
		catch (InterruptedException e) {
		   
		   System.exit(0);
		}
	   
		paint(g);
	}
	
	public void paint(Graphics g) {
		
		
		g.setColor(Color.GREEN);
		int width = getWidth(); // Figured out another way to find the Width and Height of the Applet.
		int height = getHeight();
		int pointsDraw;
        // Determine vertices of the triangle.
        int[][] points = new int[][] {
            {10, height - 10}, {width - 10, height - 10}, {width / 2, 10}};

        // Now let us pick a vertex points[k] of the triangle, either
        // points[0], points[1], or points[2].
        int k = (int) (Math.random()*3);
       
        // Next, compute the coordinates and draw a point at the midpoint
        // between (x,y) and (points[k][0], points[k][1]).
       
        x = ((x + points[k][0]) / 2);
        y = ((y + points[k][1]) / 2);
        drawPoint(g, x, y);
  
        
        
        repaint();
        
	}

    // appletViewer() starts the given applet in a new window with the given
    // width and height in pixels (normally specified via HTML attributes).
    public static void appletViewer(Applet applet, int width, int height) {
        Frame frame = new Frame(applet.getClass().getName());
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.add(applet);
        frame.setSize(width, height);
        applet.init();
        applet.start();
        frame.setVisible(true);
    }
    
    

    public static void main(String[] args) {
        appletViewer(new Sierpinski(), 700, 700);
    }
}