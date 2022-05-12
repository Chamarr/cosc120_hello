import java.awt.Color;
import java.awt.Graphics;
public class Eye
{
    // Declare and initialize static attributes
    public static final int MAX_OPEN = 10;
    public static final int MIN_OPEN = 1;

    // Declare instance data 
    private int x, y; // Center of eye
    private int width; // Distance from center to side
    private int height; // Distance from center to top
    private double irisReduction; // Iris size relative to eye
    private Color color;

    /**
     * Initialize this eye at specified location
     * 
     * @param x is the x coordinate for the eye's center 
     * @param y is the y coordinate for the eye's center 
     */
    public Eye( int x, int y )
    {
        this.x = x;
        this.y = y;
        this.width = 5;
        this.height = 5;
        this.irisReduction = .9;
        this.color = new Color(150, 100, 0);
    }
    
    /**
     * Get height of eye
     * 
     * @return int
     */
    public int getHeight()
    {
        // TODO 1: Return the height attribute for this object instead of 0.
        return this.height;
    }

    /**
     * Change eye height to specified value
     * 
     * @param value to set height of eye
     */
    public void setHeight(int value)
    {
        // Make sure new value is within range
        if ( value > Eye.MAX_OPEN ) 
            value = Eye.MAX_OPEN;
        if ( value < Eye.MIN_OPEN ) 
            value = Eye.MIN_OPEN;
        
        // TODO 2: Adjust height of oval that represents eye by specified amount.
        // HINT: This is a straightforward assignment operation. Assign the value
        //       to the object's height attribute.
				this.height = value;
    }

    /**
     * Draw this eye
     * 
     * @param g is the Graphics context on which eye should be drawn.
     */
    public void paint( Graphics g )
    {
        // Calculate parameters for drawing methods based on
        // state of object (instance data) values.
        // All this math is tedius, but doing it up front makes it easier 
        // to debug and, although the method is perhaps a bit longer, it 
        // is clearer exacly how each parameter is calculated.

        // For usability, eye's location is specified by center point. However,
        // to draw an oval, Java wants to know the box that would contain the
        // oval. Therefore, calculate the top left corner (x, y) of that box
        // and the width and height of that box (width and height) based on the
        // instance data of the centerpoint and width and height of eye
        int x = this.x - this.width;
        int y = this.y - this.height;
        int width = this.width * 2;
        int height = this.height * 2;

        // Parameters to draw the iris are calculated similarly to that of the
        // eyeball, with an appropriate reduction in size applied.
        int irisWidth = (int)(this.width * this.irisReduction);
        int irisHeight = (int)(this.height * this.irisReduction);
        if ( irisHeight < 0 ) irisHeight = 0;
        int irisX = this.x - irisWidth ;
        int irisY = this.y - irisHeight ;

        // Draw eyeball and outline it in black
        g.setColor( Color.WHITE );
        g.fillOval(x, y, width, height);
        g.setColor( Color.BLACK );
        g.drawOval(x, y, width, height);

        // Draw iris on top of eyeball
        g.setColor( this.color );
        g.fillOval( irisX, irisY, irisWidth*2, irisHeight*2 );
    }
}