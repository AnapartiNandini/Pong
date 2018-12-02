import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    //TODO (44): Declare an integer instance constant called SIZE that is initialized to 20
    //an integer instance constant called SIZE that is initialized to 20
    private final int SIZE = 20;
    
    //TODO (45): Declare a static integer instance variable (private static int) called velocity initialized to 0
    //a static integer instance variable called velocity initialized to 0
    private static int velocity = 0;

    /**
     * TODO (46): Declare a default constructor for the Ball class
     * 
     * TODO (47): Inside the method, declare a local GreenfootImage variable called ballImage
     *            initialized to a new GrenfootImage object that has a width 
     *            of SIZE and a height of SIZE
     * 
     * TODO (48): Set the color of the ballImage to WHITE
     * 
     * TODO (49): Fill an oval on the ballImage that starts at (0,0) and has a width of SIZE and a height of SIZE
     * 
     * TODO (50): Set the image of the Ball class to the ballImage
     * 
     * TODO (51): Turn the ball a random number of degrees between 0 and 360 (360 not included)
     */
    /**
     * Ball sets the image of the Ball class, as well as sets its color, shape and at which angle it should rotate when it hits the top or bottom of the window, or the paddle
     * 
     * @param None there are no parameters
     * @return Nothing is returned
     */
    public Ball()
    {
       //declare a local GreenfootImage variable called ballImage initialized to a new GrenfootImage object that has a width of SIZE and a height of SIZE 
       GreenfootImage ballImage = new GreenfootImage(SIZE,SIZE);
       
       //Set the color of the ballImage to WHITE
       ballImage.setColor(Color.WHITE);
       
       //Fill an oval on the ballImage that starts at (0,0) and has a width of SIZE and a height of SIZE
       ballImage.fillOval(0,0,SIZE,SIZE);
       
       //Set the image of the Ball class to the ballImage
       setImage(ballImage);
       
       //Turn the ball a random number of degrees between 0 and 360
       turn(Greenfoot.getRandomNumber(360));
    }

    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //TODO (82): Declare a local PlayField variable called field that is initialized to store a reference to the PlayField object
        //a local PlayField variable called field that is initialized to store a reference to the PlayField object
        PlayField field = (PlayField)getWorld();

        //TODO (83): If the game has started (PlayField has a method for checking this)...
        //If the game has started...
        if(field.getStarted() == true)
        {
            //TODO (84): Move the ball at a speed of velocity
            // Move the ball at a speed of velocity
            move(velocity);
            
            //TODO (107): Use a method to check if the ball has collided with something
            //Make a method call to checkCollision()
            checkCollision();
        }       
                
    }

    /**
     * TODO (85): Declare a method called checkCollision that does not
     *          return anything and has no parameters
     *          
     * TODO (86): Inside the method, declare a local Actor variable called hitting
     *            that is initialized to an intersecting object of class Paddle 
     *            (use the getOneIntersectingObject method, which can be found in the Actor documentation)
     * 
     * TODO (87): Declare a local PlayField variable called world that is initialized
     *            to a reference to the PlayField object
     * 
     * TODO (88): Declare a local Score variable called getPoint
     * 
     * TODO (89): If the hitting object is not nothing (i.e. != null)...
     * 
     *      TODO (90): Set the velocity variable equal to negative velocity
     *      
     *      TODO (91): Set the rotation of the ball to the negative equivalent of the current rotation ( -getRotation() )
     *      
     *      TODO (92): Move the ball at the current velocity
     *      
     * TODO (93): If the y location of the Ball is less than or equal to 10...
     * 
     *      TODO (94): Set the rotation of the ball to the negative equivalent of the current rotation
     *      
     * TODO (95): If the y location of the Ball is greater than or equal to 590...
     * 
     *      TODO (96): Set the rotation of the ball to the negative equivalent of the current rotation
     *      
     * TODO (97): If the x location of the Ball is less than or equal to 10...
     * 
     *      TODO (98): Remove this object from the world
     *      
     *      TODO (99): Initialize the getPoint variable to (Score)world.getObjects(Score.class).get(1) (this will get player two's scoreboard)
     *      
     *      TODO (100): Increase the score of the scoreboard that will be getting a point by using the countScore method of getPoint
     *      
     *      TODO (101): Reset the world by using the reset method of world
     *      
     * TODO (102): Otherwise, if the x location of the Ball is greater than or equal to 790...
     * 
     *      TODO (103): Remove this object from the world
     *      
     *      TODO (104): Initialize the getPoint variable to (Score)world.getObjects(Score.class).get(0) (this will get player one's scoreboard)
     *      
     *      TODO (105): Increase the score of the scoreboard that will be getting a point by using the countScore method of getPoint
     *      
     *      TODO (106): Reset the world by using the reset method of world
     */
    /**
     * checkCollision checks whether or not the ball has been hit. Depending on the outcome, it instructs the scenario on what to do next.
     * 
     * @param None there are no paraameters
     * @return Nothing is returned
     */
    public void checkCollision()
    {
        //a local Actor variable called hitting that is initialized to an intersecting object of class Paddle
        Actor hitting = getOneIntersectingObject(Paddle.class);
        
        //a local PlayField variable called world that is initialized to a reference to the PlayField object
        PlayField world = (PlayField)getWorld();
        
        //a local Score variable called getPoint
        Score getPoint;
        
        //If the hitting object is not nothing
        if(hitting != null)
        {
            //Set the velocity variable equal to negative velocity
            velocity = -velocity;
            
            //Set the rotation of the ball to the negative equivalent of the current rotation
            setRotation( -getRotation() );
                        
            //Move the ball at the current velocity
            move(velocity);
        }
        
        //If the y location of the Ball is less than or equal to 10...
        if(getY() <= 10)
        {
            //Set the rotation of the ball to the negative equivalent of the current rotation
            setRotation (-getRotation());            
        }
        
        // If the y location of the Ball is greater than or equal to 590...
        if(getY() >= 590)
        {
            // Set the rotation of the ball to the negative equivalent of the current rotation
            setRotation (-getRotation());
        }
        
        // If the x location of the Ball is less than or equal to 10...
        if(getX() <= 10)
        {
            //Remove this object from the world
            world.removeObject(this);
            
            //Initialize the getPoint variable to get player two's scoreboard
            getPoint = (Score)world.getObjects(Score.class).get(1);
            
            //Increase the score of the scoreboard that will be getting a point by using the countScore method of getPoint
            getPoint.countScore();
            
            //Reset the world
            world.reset();
        }
        
        //Otherwise...
        else if (getX() >= 790)
        {
            //Remove this object from the world
            world.removeObject(this);
            
            //Initialize the getPoint variable to get player one's scoreboard
            getPoint = (Score)world.getObjects(Score.class).get(0);
            
            //Increase the score of the scoreboard that will be getting a point by using the countScore method of getPoint
            getPoint.countScore();
            
            //Reset the world
            world.reset();
        }
    }

    /**
     * TODO (52): Declare a public method called setVelocity that does not
     *            return anything and has an integer parameter called v
     *          
     * TODO (53): Inside the method, set velocity variable to the v parameter
     */
    
    /**
     * setVelocity sets the velocity of the game to the value of "v"
     * 
     * @param There is an integer variable as the parameter which represents a "v" variable
     * @return Nothing is returned
     */
    public void setVelocity(int v)
    {
        velocity = v;
    }
}
