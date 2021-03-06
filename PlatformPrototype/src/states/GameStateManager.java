/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package states;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import code.Audio;

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
    public static final int GAMESTATE_MENU = 0;
    public static final int GAMESTATE_PREPARE = 1;
    public static final int GAMESTATE_GAME = 2;
    
    public int r;
    
    // Singleton Methods
    private GameStateManager(){
        states = new ArrayList<GameState>();

        // states.add(new GameStateTest());
        states.add(new GameStateMenu());
        states.add(new GameStatePrepare());
        states.add(new GameStateGame());
     
        
        setState(GAMESTATE_MENU);
        r = 0;
        
        Audio.loop("Audio\\Trilhas Finais\\Trilha Final 1 (4).wav", 0);
    }
    
    public static GameStateManager getInstance(){
        return gameStateManagerSingleton;
    }
    
    // Manager
    public void setState(int newState){
        currentState = newState;
        states.get(newState).init();
        
        if(newState == GAMESTATE_PREPARE)
        {
        	Audio.fadeout(0);
//        	try {
//        		Thread.sleep(2000l);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}        	
        }
        if(newState == GAMESTATE_GAME)
        	Audio.loop("Audio\\Trilhas Finais\\Menu Inicial - Final.wav", 1);
    }
    
    public int getState(){
        return currentState;
    }
    
    public void update(long wait){
        states.get(currentState).update(wait);
        
        Audio.update(wait);
    }
    
    public void draw(Graphics2D g){
        states.get(currentState).draw(g);
    }
    
    public void keyPressed(int k){
        System.out.println(r++);
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
