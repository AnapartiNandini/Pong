/**
 * TODO (132): Fill out an appropriate assignment comment block
 */


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayField extends World
{
    //TODO (1): Declare a boolean instance variable called startGame that is initialized to false
    //a boolean instance variable called startGame that is initialized to false
    private boolean startGame = false;
    
    //TODO (2): Declare a Ball instance variable called theBall
    //a Ball instance variable called theBall
    private Ball theBall;
    
    //TODO (3): Declare a Score instance variable called player1Score
    //a Score instance variable called player1Score
    private Score player1Score;
    
    //TODO (4): Declare a Score instance variable called player2Score
    //a Score instance variable called player2Score
    private Score player2Score;
    
    /**
     * TODO (5): Declare a default constructor for PlayField
     *  
     * TODO (6): Use the superclass' constructor to create a world
     *           with 800 by 600 cells with a cell size of 1x1 pixels
     *           
     * TODO (15): Make a method call to the initializePlayingField method
     */
    
    /**
     * PlayField is the default constructor method for this world class. It sets up the world so that hte user is able to directly play the game without having to 
     * manually setting up the world.
     * 
     * @param None There are no parameters
     * @return Nothing is returned  
     */
    public PlayField()
    {
        //creates a world with 800 by 600 cells with a cell size of 1x1 pixels
        super(800,600,1);
        
        //method call to the initializePlayingField method
        initializePlayingField();
    }
    
    /**
     * TODO (7): Declare a method called initializePlayingField that
     *           does not return anything and has no parameters
     * 
     * TODO (8): Set the color of the background of the world to BLACK
     * 
     * TODO (9): Fill a rectangle on the background starting at (0,0) and having a width of the width of the world and a height of the height of the world
     * 
     * TODO (10): Set the color of the background to GRAY (You may change this later)
     * 
     * TODO (11): Fill a rectangle on the background starting at (halfway across the screen, 0) and having a width of 4 and a height of the height of the world
     * 
     * TODO (14): Make a method call to addPlayersAndObjects
     * 
     * TODO (12): Show text stating that the player should "press the space bar to begin play" at an x location of 200 and a y location of 550
     */
    
    /**
     * initializePlayingField sets up the "look" of the scenario
     * 
     * @param None has no parameters
     * @return Nothing is returned
     */
    private void initializePlayingField()
    {
        //the color of the background is set to black         
        getBackground().setColor(Color.BLACK);
        
        //Fill a rectangle on the background starting at (0,0) and having a width of the width of the world and a height of the height of the world
        getBackground().fillRect( 0, 0, getWidth(), getHeight() );
        
        //the color of the background is set to grey
        getBackground().setColor(Color.GRAY);
        
        //Fill a rectangle on the background starting at (halfway across the screen, 0) and having a width of 4 and a height of the height of the world
        getBackground().fillRect(getWidth()/2 , 0, 4, getHeight());
        
        //a method call to addPlayersAndObjects
        addPlayersAndObjects();
        
        //Show text stating that the player should "press the space bar to begin play" at an x location of 200 and a y location of 550
        showText("press the space bar to begin play",200,550);

    }
    
    /**
     * TODO (13): Declare a method called addPlayersAndObjects that
     *           does not return anything and has no parameters
     *
     * TODO (54): Initialize the theBall variable to a new Ball object
     * 
     * TODO (40): Initialize the player1Score variable to a new Score object with an appropriate parameter value
     * 
     * TODO (41): Initialize the player2Score variable to a new Score object with an appropriate parameter value
     * 
     * TODO (55): Add the theBall object in the middle of the world
     * 
     * TODO (124): Add a new Paddle for player one using an appropriate parameter value at a x location of 10 and a y location of the middle of the height of the world
     * 
     * TODO (125): Add a new Paddle for player two using an appropriate parameter value at a x location of 10 pixels less than the width of the world and a y location of the middle of the height of the world
     * 
     * TODO (42): Add the player1Score object at an x location of 200 and a y location of 50
     * 
     * TODO (43): Add the player2Score object at an x location of 200 pixels less than the width of the world and a y location of 50
     */
    
    /**
     * addPlayersAndObjects sets up the scenario with all the the user controlled objects
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void addPlayersAndObjects()
    {
       //theball variable is initialized to a new Ball object
       theBall = new Ball();
       
       //player1Score variable is intialized to a new Score object with a parameter of true
       player1Score = new Score(true);
       
       //player2Score variable is intialized to a new Score object with a parameter of false
       player2Score = new Score(false);
       
       //theBall variable is added to the center of the world
       addObject(theBall,getWidth()/2,getHeight()/2);
       
       //a new Paddle object with a prameter of true is added to the world at 10 pixles on the x-axis and in the center of the y-axis
       addObject(new Paddle(true),10,getHeight()/2);
       
       //a new Paddle object with a parameter of false 
       addObject(new Paddle(false),getWidth() -10, getHeight()/2);
       
       //player1Score variable is added to the world at 200 pixles on the x-axis and 50 pixles on the y-axis
       addObject(player1Score, 200,50);
       
       //player2Score variable is added to the world at 200 pixles less than the width of the world and 50 pixles on the y-axis
       addObject(player2Score, getWidth() - 200, 50);
    }
    
    /**
     * TODO (61): Declare the act method for the PlayField class
     * 
     * TODO (62): If the game has not started...
     * (
     *      TODO (63): Use a method to check if the space bar key has been pressed 
     * 
     * TODO (80): Otherwise...
     * 
     *      TODO (81): Use a method to check if a player has won
     */
    
    /**
     * Act - does whatever the PlayField has to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //if the game has not started...
        if (startGame == false)
        {
            //check if the space bar key has been pressed
            checkKeyPress();
        }
        
        //otherwise...
        else
        {
            //check if a player has won
            checkWin();
        }
    }
    
    /**
     * TODO (56): Declare a method called checkKeyPress that does not
     *          return anything and has no parameters
     *          
     * TODO (57): Inside the method, you need to check if the space key has been pressed
     * 
     *      TODO (58): If the space bar has been pressed, the game has now started. Change the variable that stores that info
     *      
     *      TODO (59): Remove the text that tells the player to press the space bar to begin. You can do this by displaying an empty string, "", at the same location
     *      
     *      TODO (60): Set the velocity of theBall to be 5 pixels
     */
    
    /**
     * checkKeyPress checks whether or not the space key has been pressed and if so, start the game, show no text, and change the velocity of theBall variable to be 5 pixles
     * 
     * @param None there are no parameters
     * @return Nothing is returned
     */
    private void checkKeyPress()
    {
        //if the space key has been pressed...
        if(Greenfoot.isKeyDown("space"))
        {
            //the game has started
            startGame = true;
            
            //removes the text that tells the player to press the space bar to begin
            showText ("",200,550);
            
            //the velocity of theBall is set to 5 pixles
            theBall.setVelocity(5);
        }
    }
    
    /**
     * TODO (64): Declare a public method called reset that does not return
     *            anything and has no parameters
     *            
     * TODO (65): Set the theBall variable to a new Ball object
     * 
     * TODO (66): Add theBall in the middle of the world
     * 
     * TODO (67): Set the velocity of theBall to 0
     * 
     * TODO (68): Use the show text method to display that the user should Press the space bar to begin at an x location of 200 and a y location of 550
     * 
     * TODO (69): Set the startGame variable to false
     */
    
    /**
     * reset, resets the scenario to it original "look" with the required objects, texts and concludes that that game has not yet started.
     * 
     * @param None there are no paramters
     * @return Nothing is returned
     */
    public void reset()
    {
        //theBall is initialized to a new Ball object 
        theBall = new Ball();
        
        //theBall variable is added to the cener of the world
        addObject(theBall,getWidth()/2,getHeight()/2);
        
        //the velocity of theBall variable is set to 0
        theBall.setVelocity(0);
        
        //show the text "Press space Bar to Begin" at 200 pixles on the x-axis and 500 pixles on the y-axis
        showText("Press space Bar to Begin", 200,550);
        
        //the game has not yet started
        startGame = false;
        
    }
    /**
     * TODO (70): Declare a method called checkWin that does not
     *            return anything and has no parameters
     *          
     * TODO (71): Declare a local GreenfootImage variable called player1Win that
     *            is initialized to a new GreenfootImage object with "Player 1 Wins!" as the text, 
     *            45 as the font size, player one's color as the text color, and BLACK as the background color
     *          
     * TODO (72): Declare a local GreenfootImage variable called player2Win that
     *            is initialized to a new GreenfootImage object with "Player 2 Wins!" as the text, 
     *            45 as the font size, player two's color as the text color, and BLACK as the background color
     *          
     * TODO (73): Declare a local integer variable called player1Total that is 
     *            initialized to the score of player one's scoreboard (use the getScore method)
     *          
     * TODO (74): Declare a local integer variable called player2Total that is
     *            initialized to the score of player two's scoreboard
     *          
     * TODO (75): The game is won if one of the players has a score of 7 or more. Write two conditional statements that will check this, one for each player
     * 
     *      TODO (76): In both conditional statements from the previous TODO, remove all objects (use null as the parameter for the removeObjects method)
     *      
     *      TODO (77): In both conditional statements, set the color of the background to BLACK
     *      
     *      TODO (78): In both conditional statements, fill a rectangle on the background that starts at (0,0) and has a width of the width of the world and a height of the height of the world
     *      
     *      TODO (79): In both conditional statements, draw an image on the background that will show which player won in the exact center of the world (you should have GreenfootImage variables for this)
     */
    
    /**
     * checkWin checks which player won and what to display if a player wins as well as update the score board
     * 
     * @param None there are no parameters
     * @return Nothing is returned
     */
    private void checkWin()
    {
       //Declare a local GreenfootImage variable called player1Win is initialized to a new GreenfootImage object with "Player 1 Wins!" as the text, 45 as the font size, player one's color as the text color, and BLACK as the background color
       GreenfootImage player1Win = new GreenfootImage("Player 1 Wins!", 45,Color.MAGENTA, Color.BLACK);
       
       //Declare a local GreenfootImage variable called player2Win that is initialized to a new GreenfootImage object with "Player 2 Wins!" as the text, 45 as the font size, player two's color as the text color, and BLACK as the background color
       GreenfootImage player2Win = new GreenfootImage("Player 2 Wins!", 45, Color.CYAN, Color.BLACK);
       
       //the integer variable player1Total is intialized to the score of player1Score
       int player1Total = player1Score.getScore();
       
       //the integer variable player12Total is intialized to the score of player2Score
       int player2Total = player2Score.getScore();
       
       //if player one's total score is above 7...
       if(player1Total >= 7)
       {
           //remove all objects
           removeObjects(null);
           
           //set the color of the background to black
           getBackground().setColor(Color.BLACK);
           
           //fill a rectangle on the background that starts at (0,0) and has a width of the width of the world and a height of the height of the world
           getBackground().fillRect(0,0, getWidth(),getHeight());
           
           //draw an image on the background that will show which player won in the exact center of the world
           getBackground().drawImage(player1Win,getWidth()/2,getHeight()/2);           
       }
       
       if(player2Total >= 7)
       {
           //remove all objects
           removeObjects(null);
           
           //set the color of the background to black
           getBackground().setColor(Color.BLACK);
           
           //fill a rectangle on the background that starts at (0,0) and has a width of the width of the world and a height of the height of the world
           getBackground().fillRect(0,0, getWidth(),getHeight());
           
           //draw an image on the background that will show which player won in the exact center of the world
           getBackground().drawImage(player2Win,getWidth()/2,getHeight()/2);           
       }
    }
    
    /**
     * TODO (16): Declare a public method called getStarted that returns
     *            a boolean and has no parameters
     *          
     * TODO (17): Inside the method, return the variable that states whether the game has started or not
     */
    /**
     * getStarted starts the game
     * 
     * @param None there are no parameters
     * @return returns a boolean variable which represents the variable startGame and whether or not it is true or false
     */
    public boolean getStarted()
    {
        //returns the boolean variable startGame
        return startGame;
    }
}
