/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /* 
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
 		*/
		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
   			StdDraw.line(x1, y1, x2, y2);
    		return;
		}

		double ax = x1 + (x2 - x1) / 3.0;
		double ay = y1 + (y2 - y1) / 3.0;
		double bx = x1 + 2*(x2 - x1) / 3.0;
		double by = y1 + 2*(y2 - y1) / 3.0;
		double cx = 0.5 * (x1 + x2) - (Math.sqrt(3) / 6.0) * (y2 - y1);
		double cy = (Math.sqrt(3) / 6.0) * (x2 - x1) + 0.5 * (y1 + y2);



		curve(n - 1, x1, y1, ax, ay);   // P -> A
		curve(n - 1, ax, ay, cx, cy);   // A -> C
		curve(n - 1, cx, cy, bx, by);   // C -> B
		curve(n - 1, bx, by, x2, y2);   // B -> Q	
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setXscale(-0.2, 1.2); 
    	StdDraw.setYscale(-0.2, 1.2);
		double ax = 0.1, ay = 0.1;
		double bx = 1.0, by = 0.1;
		double cx = 0.55, cy = 0.1 + 0.9 * 0.866;

		curve(n, ax, ay, cx, cy);
    	curve(n, cx, cy, bx, by); 
    	curve(n, bx, by, ax, ay);

	}
}
