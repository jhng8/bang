import greenfoot.*; 
 // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Bullet extends Actor
{
    private int speed = 15;
    
    public void act() 
    {
        move(speed);
        checkCollision();
    }
    
    /**
     * Checks if bullet is touching edge of world or 
     */
    private void checkCollision(){
        if (isAtEdge()) {
               getWorld().removeObject(this); 
            }
            
        else if (isTouching(Enemy.class)) {
            Actor enemy = getOneIntersectingObject(Enemy.class);
            if (enemy != null) {
                    getWorld().removeObject(enemy);
                    getWorld().removeObject(this);
            }
            
        }
    }
        
}