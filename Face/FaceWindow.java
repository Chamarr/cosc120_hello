import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FaceWindow implements ActionListener
{
    // buttons to increase or decrease smile
    private static JButton smileButton ;
    private static JButton frownButton ;
    private static JButton openLeftButton ;
    private static JButton closeLeftButton ;
    private static JButton openRightButton ;
    private static JButton closeRightButton ;
    private static JButton openBothButton ;
    private static JButton closeBothButton ;

    // Face
    private static Face face;

    public static void main( String[] args )
    {
        // Declare and instantiate the window
        JFrame window = new JFrame();
        window.setSize( 400, 200 );
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Instantiate Face and add it to window
        FaceWindow.face = new Face();
        window.add( FaceWindow.face );
        // Create control panel and add it to window
        JPanel controls = createControlPanel();
        window.add( controls, BorderLayout.NORTH );
        // Show the window
        window.setVisible( true );
    }

    /**
     * Create a simple control panel to neatly house the buttons
     */
    public static JPanel createControlPanel()
    {
        // Declare and instantiate an object to handle button clicks
        ActionListener handler = new FaceWindow();

        // Create JPanel to hold controls; configure it for 
        // two rows of four buttons each
        JPanel controls = new JPanel();
        controls.setLayout( new GridLayout(2, 4));

        // Instantiate buttons
        // Note the order of initialization doesn't matter, it's the order
        // in which they're added to the control panel that controls layout.
        FaceWindow.smileButton = new JButton("Smile"); 
        FaceWindow.frownButton = new JButton("Frown"); 
        FaceWindow.openLeftButton = new JButton("L Eye +"); 
        FaceWindow.closeLeftButton = new JButton("L Eye -"); 
        FaceWindow.openRightButton = new JButton("R Eye +"); 
        FaceWindow.closeRightButton = new JButton("R Eye -"); 
        FaceWindow.openBothButton = new JButton("Eyes +"); 
        FaceWindow.closeBothButton = new JButton("Eyes -"); 

        // Assign click handler to each button
        FaceWindow.smileButton.addActionListener( handler );
        FaceWindow.frownButton.addActionListener( handler );
        FaceWindow.openLeftButton.addActionListener( handler );
        FaceWindow.openRightButton.addActionListener( handler );
        FaceWindow.closeLeftButton.addActionListener( handler );
        FaceWindow.closeRightButton.addActionListener( handler );
        FaceWindow.openBothButton.addActionListener( handler );
        FaceWindow.closeBothButton.addActionListener( handler );

        // Add buttons to control panel
        controls.add( FaceWindow.smileButton );
        controls.add( FaceWindow.frownButton );
        controls.add( FaceWindow.openLeftButton );
        controls.add( FaceWindow.closeLeftButton );
        controls.add( FaceWindow.openBothButton );
        controls.add( FaceWindow.closeBothButton );
        controls.add( FaceWindow.openRightButton );
        controls.add( FaceWindow.closeRightButton );    

        return controls;
    }

    /**
     * Handle clicks from control buttons
     * 
     * @param click 
     */
    @Override
    public void actionPerformed( ActionEvent click )
    {
        // Simplify readability by creating aliases to the eyes
        Eye leftEye = FaceWindow.face.getEye(Face.LEFT);
        Eye rightEye = FaceWindow.face.getEye(Face.RIGHT);

        // Send appropriate message to face, 
        // depending on which button was clicked
        if ( click.getSource() == FaceWindow.smileButton )
            FaceWindow.face.smile();
        if ( click.getSource() == FaceWindow.frownButton )
            FaceWindow.face.frown();
        if ( click.getSource() == FaceWindow.openLeftButton )
            FaceWindow.face.openEye(leftEye);
        if ( click.getSource() == FaceWindow.openRightButton )
            FaceWindow.face.openEye(rightEye);
        if ( click.getSource() == FaceWindow.openBothButton )
            FaceWindow.face.openEyes();
        if ( click.getSource() == FaceWindow.closeLeftButton )
            FaceWindow.face.closeEye(leftEye);
        if ( click.getSource() == FaceWindow.closeRightButton )
            FaceWindow.face.closeEye(rightEye);
        if ( click.getSource() == FaceWindow.closeBothButton )
            FaceWindow.face.closeEyes();
    }
}