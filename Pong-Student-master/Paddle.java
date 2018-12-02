import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paddle extends Actor
{
    //TODO (108): Declare an integer instance constant called WIDTH that is initialized to 10
    //an integer instance constant called WIDTH that is initialized to 10
    private final int WIDTH = 10;
    
    //TODO (109): Declare an integer instance constant called HEIGHT that is initialize to 60
    //an integer instance constant called HEIGHT that is initialize to 60
    private final int HEIGHT = 60;
    
    //TODO (110): Declare a String instance variable called upKey
    //a String instance variable called upKey
    private String upKey;
    
    //TODO (111): Declare a String instance variable called downKey
    //a String instance variable called downKey
    private String downKey;
    
    
    /**
     * TODO (112): Declare a constructor for the Paddle class with
     *             a boolean parameter called isLeft
     *          
     * TODO (113): Inside the constructor, declare a local GreenfootImage variable called paddleImage
     *             that is initialized to a new GreenfootImage object with a width of WIDTH and a height of HEIGHT
     *          
     * TODO (114): If the Paddle is on the left...
     * 
     *      TODO (115): Set the upKey equal to "w"
     *      
     *      TODO (116): Set the downKey equal to "s"
     *      
     *      TODO (117): Set the color of the paddle image to be player one's color
     *               
     * TODO (118): Otherwise...
     * 
     *      TODO (119): Set the upKey equal to "up"
     *      
     *      TODO (120): Set the downKey equal to "down"
     *      
     *      TODO (121): Set the color of the paddle image to be player two's color
     *               
     * TODO (122): Fill a rectangle on the paddleImage that starts at (0,0) and has a width of WIDTH and a height of HEIGHT
     * 
     * TODO (123): Set the image of the Paddle class to paddleImage
     */
    
    /**
     * Paddle is the constructor for this class which sets the functions of the paddles, sets the image of the paddle, as well as the color for thae paddles for
     * each respective player
     * 
     * @param there is a boolean parameter which represents whether the variable isLeft is either true or false
     * @return nothing is returned as there is no return value considering this is the constructor method for this class
     */
    public Paddle(boolean isLeft)
    {
        //a local GreenfootImage variable called paddleImage that is initialized to a new GreenfootImage object with a width of WIDTH and a height of HEIGHT
        GreenfootImage paddleImage = new GreenfootImage(WIDTH,HEIGHT);
        
        //If the Paddle is on the left...
        if(isLeft == true)
        {
            //Set the upKey equal to "w"
            upKey = "w";
            
            // Set the downKey equal to "s"
            downKey = "s";
            
            //Set the color of the paddle image to be player one's color which is Magenta
            paddleImage.setColor(Color.MAGENTA);            
        }
        
        //Otherwise...
        else
        {
            //Set the upKey equal to "up"
            upKey = "up";
            
            //set the upKey equal to "down"
            downKey = "down";
            
            //Set the color of the paddle image to be player two's color which is Cyan
            paddleImage.setColor(Color.CYAN);            
        }
        
        // Fill a rectangle on the paddleImage that starts at (0,0) and has a width of WIDTH and a height of HEIGHT
        paddleImage.fillRect(0,0,WIDTH,HEIGHT);
        
        //Set the image of the Paddle class to paddleImage
        setImage(paddleImage);
    }
    
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //TODO (131): Use a method to check if the player has pressed keyboard keys
        //Make a method all to checkKeyPress
        checkKeyPress();
    }    
    
    /**
     * TODO (126): Declare a method called checkKeyPress that does not
     *             return anything and has no parameters
     *          
     * TODO (127): Inside the method, if the user has pressed down the upKey...
     *      
     *      TODO (128): Set the location to be the current X location and 4 pixels less than the current Y location
     *      
     * TODO (129): If the user has pressed down the downKey...
     * 
     *      TODO (130): Set the location to be the current X location and 4 pixels more than the current Y location
     */
    
    /**
     * checkKeyPress checks which key has been presseed and depending on the outcome, what to do.
     * 
     * @param None there are no parameters
     * @return Nothing is returned
     */
    private void checkKeyPress()
    {
        //if the user has pressed down the upKey...
        if(Greenfoot.isKeyDown (upKey))
        {
            //Set the location to be the current X location and 4 pixels less than the current Y location
            setLocation(getX(),getY()-4);            
        }
        
        // If the user has pressed down the downKey...
        if(Greenfoot.isKeyDown (downKey))
        {
            //Set the location to be the current X location and 4 pixels more than the current Y location
            setLocation(getX(),getY()+4);
        }
    }
}
