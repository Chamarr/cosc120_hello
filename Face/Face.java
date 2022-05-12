import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
public class Face extends JPanel
{
    // Constants to represent left and right side of face;
    // Makes code more readable and avoids misspellings 
    // (or at least compiler can catch misspellings)
    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    // Declare instance data for the face
    private Eye leftEye, rightEye;
    private Mouth mouth;

    /**
     * No-args constructor puts face at (200,55) 
     */
    public Face()
    {
        this(200, 55);
    }

    /**
     * Instantiate face object centered at point x, y
     * 
     * @param x is the x value of the center of the face
     * @param y is the y value of the center of the face
     */
    public Face(int x, int y)
    {
        // Initialize instance data
        this.leftEye = new Eye(x-20,y-5);
        this.rightEye = new Eye(x+20,y-5);
        this.mouth = new Mouth(x,y+5);
    }

    /**
     * Draws on the provided Graphics context 
     * a white eyeball with a black outline and places 
     * a colored iris in it.
     * 
     * @param g is the Graphics context on which drawing should be made
     */
    @Override
    public void paint( Graphics g )
    {
        // Clear screen
        g.setColor( Color.WHITE );
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        // Draw each component 
        this.leftEye.paint( g );
        this.rightEye.paint( g );
        this.mouth.paint( g );
    }

    /**
     * Retrieve an alias to specified eye
     * 
     * @param which eye to retrieve, specified by constant Face.LEFT or Face.RIGHT
     * @return an alias to the specified eye
     */
    public Eye getEye( int which )
    {
        if ( which == LEFT ) return this.leftEye;
        else if ( which == RIGHT ) return this.rightEye;
        else throw new RuntimeException("Invalid argument ("+which+") to getEye()");
    }

    /**
     * Closes both eyes by specified amount
     * 
     * @param amount eye should close
     */
    public void closeEyes()
    {
        this.closeEye( this.leftEye );
        this.closeEye( this.rightEye );
    }

    /**
     * Opens both eyes by specified amount
     * 
     * @param amount eye should open
     */
    public void openEyes()
    {
        this.openEye( this.leftEye );
        this.openEye( this.rightEye );
    }

    /**
     * Close specified eye by one unit
     * 
     * @param which eye to close
     */
    public void closeEye( Eye which )
    {
        this.changeEyeShape( which, -1 );
    }

    /**
     * Open specified eye by one unit
     * 
     * @param which eye to close
     */
    public void openEye( Eye which )
    {
        this.changeEyeShape( which, 1 );
    }

    /**
     * Move mouth toward a smiling form by a direction of +1
     */
    public void smile()
    {
        this.changeMouthBy( 1 );
    }

    /**
     * Move mouth toward a frowning form by a direction of -1
     */
    public void frown()
    {
        this.changeMouthBy( -1 );
    }

    /**
     * Open specified eye by specified amount
     * <i>Note this is a private method; no external code should invoke it.
     * Rather, external code should invoke openEye() or closeEye() which, in turn,
     * will call this with the appropriate direction parameter.</i>
     * 
     * @param which eye to change
     * @param direction to change eye shape
     */
    private void changeEyeShape( Eye which, int direction )
    {
        // TODO 3: Calculate new height based on 
        // current height and amount to change.
        // Hint: To get the current height, use the accessor method
        //       on the specified eye. Add the direction to move the 
        //       eye to that. If you're still unclear, take a look
        //       at how something similar was done in changeMouthBy()
			int height = which.getHeight() + direction;
        
        // TODO 4: Send message to eye indicating new height
        // Hint: Call the mutator method on the specified eye and pass
        //       the height you calculated in the previous step as an argument.
				which.setHeight( height );
        // Redraw the face
        this.repaint();
    }

    /**
     * Move mouth toward a smiling form by specified direction.
     * <i>Note this is a private method; no external code should invoke it.
     * Rather, external code should invoke smile() or frown() which, in turn,
     * will call this with the appropriate direction parameter.</i>
     * 
     * @param direction
     */
    private void changeMouthBy( int direction )
    {
        // Use accessor to get current state
        int height = this.mouth.getHeight();
        // Modify as appropriate
        height = height + direction;
        // Use mutator to set new state
        this.mouth.setHeight( height );
        // Redraw the face
        this.repaint();
    }
}
