/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package states;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author Peronio
 */
public class GameStateManager {
    // Singleton manager variables
    private static final GameStateManager gameStateManagerSingleton = new GameStateManager();
    private ArrayList<GameState> states;
    
    // Game stats ints
    private int currentState;
    public static final int TEST = 0;
    
    // Singleton Methods
    private GameStateManager(){
        states = new ArrayList<GameState>();
        
        states.add(new GameStateTest());        
        
        setState(TEST);
    }
    
    public static GameStateManager getInstance(){
        return gameStateManagerSingleton;
    }
    
    // Manager
    public void setState(int newState){
        currentState = newState;
        states.get(newState).init();
    }
    
    public int getState(){
        return currentState;
    }
    
    public void update(){
        states.get(currentState).update();
    }
    
    public void draw(Graphics2D g){
        states.get(currentState).draw(g);
    }
    
    public void keyPressed(int k){
        states.get(currentState).keyPressed(k);
    }
    
    public void keyReleased(int k){
        states.get(currentState).keyReleased(k);
    }
    
    public void mouseClicked(MouseEvent e){
        states.get(currentState).mouseClicked(e);
    }
    
    public void mousePressed(MouseEvent e){
        states.get(currentState).mousePressed(e);
    }
    
    public void mouseDragged(MouseEvent e){
        states.get(currentState).mouseDragged(e);
    }
    
    public void mouseMoved(MouseEvent e){
        states.get(currentState).mouseMoved(e);
    }
    
}