import java.awt.Color;
import java.awt.Graphics;
public class Mouth
{
    private static final int SMILE_EXTREME = 5;

    private int x, y;
    private int width, height;

    /**
     * Create a mouth whose center is at x, y. As mouth smiles or frowns
     * center's y may move up or down, but sides remain fixed.
     * 
     * @param x location of mouth's center
     * @param y location of mouth's center
     */
    public Mouth( int x, int y )
    {
        // Initialize instance data
        this.x = x;
        this.y = y;
        this.width = 10;
        this.height = 1;
    }

    /**
     * Draw the mouth
     * 
     * @param g is the Graphics context on which mouth should be drawn.
     */    
    public void paint( Graphics g )
    {
        // Calculate x, y, width, and height of square
        // that contains mouth arc
        int x = this.x - this.width;
        int y = this.y - Math.abs(this.height);
        int width = this.width * 2;
        int height = Math.abs(this.height) * 2 + 1;
        // Mouth always goes full 180 degrees
        int sDeg = 0; // right
        int eDeg = 180; // left
        // Direction of mouth depends on sign
        // of smile parameter
        int dir = -1;
        if ( this.height < 0 ) dir = 1;
        // Set color and draw arc
        g.setColor( Color.RED );
        g.drawArc(x, y, width, height, sDeg, eDeg * dir);
    }

    /**
     * Get the height of the mouth (positive is a smile, negative is a frown).
     * The larger the value's absolute value, the more extreme the mouth shape.
     * 
     * @return the size of the smile
     */
    public int getHeight()
    {
        return this.height;
    }

    /**
     * Set the height of the mouth. A positive value is a smile, negative is a frown.
     * The larger the value, the more extreme the mouth's shape.
     * 
     * @param height to set mouth 
     */
    public void setHeight( int height )
    {
        // Make sure value is within legal limits
        if ( Math.abs(height) > SMILE_EXTREME ) return;
        this.height = height;
    }
}