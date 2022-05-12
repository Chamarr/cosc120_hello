First, run the program to get familiar with what it does and what it should do.
The "main" method is in FaceWindow. Compile FaceWindow.java and run its main method.
A window opens with several buttons across the top and a slightly smiling face.
If you click the Smile button a few times, the face's smile increases; click the 
Frown button and the smile fades and eventually becomes a frown. The other buttons
have no effect. L Eye + should open the left eye, L Eye - should close the left eye;
you can infer what the other buttons should do.

Now review the class diagram to get an idea of how the classes relate.
The diagram indicates that the FaceWindow class has dependencies; specifically
FaceWindow depends on the Eye and Face classes. Also, the Face class depends 
on the Eye and Mouth class. This makes sense; you can't draw a face without eyes 
or a mouth, and you can't put a face in a window if you don't have a face. As you will 
see when you look at the code in FaceWindow, to simplify the code, FaceWindow gets 
references to each eye. That is why FaceWindow also depends on the Eye class.

Look at the source code for FaceWindow. The first thing you might notice is that
it imports a lot of unfamiliar classes. These classes support the graphics behind
the program. You certainly can google the documentation for them (Google "javadoc JButton"
for the documentation on javax.swing.JButton, for example) but all the code related
to the graphics is in place so you don't need to work with these classes. The class
defines several static attributes, most of which are JButtons. These will be the buttons
that appear in the window. There also is a static attribute of type Face. Although
we will need to create an instance of FaceWindow to handle events (that's the way Java's
graphics framework works), we don't need separate attributes to represent the buttons
or face in that instance, so it's safe to make them all static in this case.

Diving deeper into FaceWindow, you find the main(String[]) method. The inline comments
hopefully explain what's going on here. The gist of it is, we're setting up and displaying
the window. The createControlPanel() method could have been put in the main method; it's
only called once. However, making it a separate method makes main(String[]) more readable.
All this method does is instantiate all the JButton attributes, assign to them the object
which will handle clicks on the buttons, and finally add the buttons to the control
panel.

The last method in FaceWindow is actionPerformed(ActionEvent). This method is called 
whenever one of the JButtons is clicked. It simply checks to see which JButton was 
clicked by comparing the source of the click to each of the JButton objects, then
sends the appropriate message to the face.

Now look at the Face class. You'll make some modifications here, but wait till you review all
the code. in all the classes. The class defines constants that indicate left or right. 
These are used when some other class wants to get a reference to one or the other eye.
We'll see it used in the getEye(int) method shortly. The class also defines some instance
attributes: two Eye objects (leftEye, rightEye) and a Mouth object (mouth). These are 
the objects that will be used to draw the face.

Face has two constructors: The no-args constructor draws the face in the middle of the
window (this is the constructor used in FaceWindow); it simply calls the parameterized
constructor, which can put the face anywhere. Notice that only one constructor performs
initialization, the no-args constructor calls the parameterized one. This isn't required
but is good practice as it reduces the places where initialization occurs (and therefore
reduces the places where bugs can occur). When you look at the parameterized constructor
you see that it instantiates the two eyes and the mouth. 

Face's paint(Graphics) method draws the face by clearing the screen then telling each
of the face's components (two eyes and a mouth) to paint themselves. Notice that the 
face object doesn't track the state of the individual components; each object knows where
it should be drawn and how to draw itself. This is an example of encapsulation: The data 
required to draw a mouth is "tied" to the methods that draw the mouth and put in their
own data type (or class). When we look at the Eye and Mouth class we'll see the other
aspect of encapsulation, which is that the actual data is hidden from the "outside" and
can only be manipulated through accessor and mutator methods.

The next interesting method is getEye(int). This method returns a reference to the specified
eye, which is to say, it returns the actual object (the eye itself) ... not a copy of it.
The expected parameter is an int and one of the two Face constants (LEFT or RIGHT) should be
provided. Why not skip the constants and use a String, such as "left" or "right"? That 
would work, but if the user were to misspell the String, the compiler wouldn't know and
the code simply wouldn't work. By using constants, if the user misspells Face.LEFT as Face.LFT
the compiler will object and alert the user to the likely location of their error.

Next are several methods, all of which simply call other methods in the same class: closeEyes()
calls closeEye(Eye) for the left and right eyes, for example; closeEye(Eye) in turn calls
changeEyeShape(Eye, int). The same series of method calls exist for openEyes() and 
openEye(Eye). The business logic for all these methods is very similar: Set an eye's shape
to a new value. That is the method you will implement in the class. But ... not yet!

Briefly review the smile() and frown() functions; they, too, call the same "business logic" 
method: changeMouthBy(int). If you study how those three methods work, and understand
the implementation in changeMouthBy(int), you'll be well on your way to understanding
how to implement changeEyeShape(Eye, int).

Finally, take a look at the Eye class. It has several attributes, most of which are 
initialized by the constructor and then can't be changed. However, there are two methods
declared and partially implemented for the eye's height: The accessor, getHeight(), 
and the mutator, setHeight(int). You need to complete these implementations.

Once you are done, add a constructor to the Eye class that allow one to specify a different
color as well as the x and y location of the eye. Remember, try to keep your initialization
logic in just one constructor.

In summary:
1. Run the program
2. Understand the relationships among classes depicted by the class diagram
3. Review the code to understand how the classes work, specifically FaceWindow, Face, and Eye
4. Complete TODO 1 and TODO 2 in Eye.java
5. Complete TODO 3 and TODO 4 in Face.java
6. Add constructors to Eye.java to allow for more variety in the way the eye is displayed
