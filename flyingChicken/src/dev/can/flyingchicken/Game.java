/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.can.flyingchicken;

import dev.can.flyingchicken.display.Display;
import dev.can.flyingchicken.gfx.Assets;
import dev.can.flyingchicken.input.KeyManager;
import dev.can.flyingchicken.input.MouseManager;
import dev.can.flyingchicken.states.LevelState;
import dev.can.flyingchicken.states.MenuState;
import dev.can.flyingchicken.states.State;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author can
 */
public class Game implements Runnable {
    private Display display;
    private Thread thread;
    private boolean running = false;
    
    public int width, height;
    public String title;
    
    private BufferStrategy bs;
    private Graphics g;
    
    // States
    public State levelState;
    public State menuState;
    
    // Input
    private KeyManager keyManager;
    private MouseManager mouseManager;
    
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }
    
    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        
        levelState = new LevelState(this);
        menuState = new MenuState(this);
        State.setState(menuState);
    }
    
    private void tick() {
        keyManager.tick();
        
        if (State.getState() != null)
            State.getState().tick();
    }
    
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();
        
        // Clear Screen!
        g.clearRect(0, 0, width, height);
        
        // Draw Here!
        if (State.getState() != null)
            State.getState().render(g);
        // End Drawing!
        
        bs.show();
        g.dispose();
    }
    
    public void run() {
        init();
        
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            
            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        
        stop();
    }
    
    public KeyManager getKeyManager() { return keyManager; }
    public MouseManager getMouseManager() { return mouseManager; }

    public LevelState getLevelState() { return (LevelState) levelState; }

    public void setWidth(int width) { this.width = width; }
    public int getWidth() { return width; }

    public void setInit() { init(); }
    
    public void setHeight(int height) { this.height = height; }
    public int getHeight() { return height; }
    
    public synchronized void start() {
        if (running)
            return;
        
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop() {
        if (!running)
            return;
        
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
