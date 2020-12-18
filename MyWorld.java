import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @Joey Huang
 * @version 1.0
 */
public class MyWorld extends World {
    public int xCoor;
    public int yCoor;

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld() {    
        super(1000, 600, 1);
        reset();
        init();
    }

    /**
     * Create player and enemies
     */
    public void init() {
        Player player = new Player();
        addObject(player,getWidth()/2,getHeight()/2);
        
        Ground ground = new Ground();
        addObject(ground,getWidth()/2,getHeight()-50);
        
        for (int i=0; i<10; i++) {
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Enemy(),0 ,y);
        }
        
        for (int i=0; i<10; i++) {
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Enemy(),1000 ,y);
        }
    }

    /**
     * Reset static variables and remove all actors from world.
     */
    public void reset() {
        int xCoor = 0;
        int yCoor =0;
        Player.alive = true;
        removeObjects(getObjects(Player.class));
        removeObjects(getObjects(Enemy.class));
    }
    
    /**
     * Deletes all actors, creates a black screen, displays You Win text
     */
    public void win() {
    removeObjects(getObjects(Actor.class)); // remove all actors from world
    GreenfootImage bg = getBackground(); 
    bg.setColor(Color.BLACK); 
    bg.fill(); 
    GreenfootImage txtImg = new GreenfootImage("YOU\nWIN", 80, Color.WHITE, Color.BLACK); 
    bg.drawImage(txtImg, (bg.getWidth()-txtImg.getWidth())/2, (bg.getHeight()-txtImg.getHeight())/2); 
    Greenfoot.stop(); // stop the scenario
    }

    /**
     * Deletes all actors, creates a black screen, displays GAME OVER text
     */
    public void lose() {
    removeObjects(getObjects(Actor.class)); // remove all actors from world
    GreenfootImage bg = getBackground(); 
    bg.setColor(Color.BLACK); 
    bg.fill();
    GreenfootImage txtImg = new GreenfootImage("GAME\nOVER", 80, Color.WHITE, Color.BLACK); 
    bg.drawImage(txtImg, (bg.getWidth()-txtImg.getWidth())/2, (bg.getHeight()-txtImg.getHeight())/2); 
    Greenfoot.stop(); // stop the scenario
    }
    
    /**
     * Checks if game is over
     */
    public void act() {
        if (!Player.alive){
            lose(); 
        }
        else if (getObjects(Enemy.class).isEmpty()){
            win();
        }
    }
}
