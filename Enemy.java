import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{    
    public void act() 
    {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        int PlayerX = player.getX();
        int PlayerY = player.getY();
        turnTowards(PlayerX,PlayerY);
        move(2);
        checkContact(Player.class);
    } 
    
    public void checkContact(Class myClass) {
        Player other = (Player) getOneIntersectingObject(myClass);
        if(other != null){
            Player.alive = false;
        }
    }
}