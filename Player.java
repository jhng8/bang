import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A pointer that moves around
 * 
 * @author Joey Huang
 * @version 1.0
 */
public class Player extends Actor
{    
    public final static int XSPEED = 10;
    public static int ySpeed = 0;
    public final static int ACCEL = 2;
    public final static int JUMP = 25;
    public static boolean alive = true;
    public final static int RELOAD = 5;
    public static int wait = 0;
    
    /**
     * Checks if the player moves, if the player is in the air, and reload time
     */
    public void act() {
         checkMovement();
         checkFall();
         if (wait > 0) wait--;
    }
    
    /**
     * Controls movement and shooting
     */
    public void checkMovement() {
        if (Greenfoot.isKeyDown("w") && touchGround()){
            jump();
        }
        if (Greenfoot.isKeyDown("a")){
           moveLeft();
           setImage("player_2_30_left.png");
        }
        if (Greenfoot.isKeyDown("d")){
            moveRight();
            setImage("player_2_30.png");
        }
        if (Greenfoot.mouseClicked(null) && wait == 0){
            shoot();
        }
    }
    
    /**
     * Checks if the player is falling
     */
    public void checkFall() {
        if(touchGround()){
            ySpeed = 0;
        } 
        else {
            fall();
        }
    }
    
    public boolean touchGround(){
        return getY() > 440;
    }

    public void moveRight() {
        setLocation(getX() + XSPEED, getY());
    }
    
    public void moveLeft() {
             setLocation(getX() - XSPEED, getY());
    }
    
    public void jump() {
        ySpeed = -JUMP;
        fall();
    }
    
    public void fall() {
        setLocation(getX(), getY() + ySpeed);
        ySpeed += ACCEL;
    }
    
    /**
     * Creates a new bullet that goes towards the cursor
     */
    public void shoot() {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        int x = mouseInfo.getX();
        int y = mouseInfo.getY();
        Actor bullet = new Bullet(); 
        getWorld().addObject(bullet, getX(), getY()); 
        bullet.turnTowards(x, y); // this makes it face the cursor
        wait = RELOAD;
    }
}
