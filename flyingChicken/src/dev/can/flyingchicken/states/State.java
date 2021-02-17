/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.can.flyingchicken.states;

import dev.can.flyingchicken.Game;
import java.awt.Graphics;

/**
 *
 * @author can
 */
public abstract class State {
    private static State currentState = null;
    public static void setState(State state) { currentState = state; }
    public static State getState() { return currentState; }
    
    protected Game game;
    protected int difficulty;
    
    public State(Game game) {
        this.game = game;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);

    public void setDifficulty(int difficulty) { this.difficulty = difficulty; }
    public int getDifficulty() { return difficulty; }
}
