package com.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 4088146271165387233L;
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running;
	private Handler handler;
	private HUD hud;
	private Spawn spawn;
	
	public Game(){
		
		this.setHandler(new Handler());
		this.setHud(new HUD());
		this.setSpawn(new Spawn(this.getHandler(), this.getHud()));
		this.addKeyListener(new KeyInput(this.getHandler()));
		new Window(Game.WIDTH, Game.HEIGHT, "Wave", this);
		this.getHandler().add(new Player(100, 100, Id.Player, this.getHandler()));
		
	}
	
	public static void main(String args[]){
		
		new Game();
		
	}
	
	public synchronized void start(){
		
		this.setRunning(true);
		this.setThread(new Thread(this));
		this.getThread().start();
		
	}
	
	public synchronized void stop(){
		
		try{
			this.getThread().join();
			this.setRunning(false);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		
		this.requestFocus();
		long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1){
            	tick();
                delta--;
            }
            if(running)
            	render();
            frames++;
                    
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
		
	}
	
	private void tick(){
		
		this.getHandler().tick();
		this.getHud().tick();
		this.getSpawn().tick();
		
	}
	
	@SuppressWarnings("static-access")
	private void render(){
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, this.WIDTH, this.HEIGHT);
		if(this.getHandler() != null){
			this.getHandler().render(g);
		}else{
			System.out.println("Handler is null");
		}
		this.getHud().render(g);
		g.dispose();
		bs.show();
		
	}
	
	public static int clamp(int var, int min, int max){
		
		int resul;
		
		if(var >= max){
			resul = max;
		}else if(var <= min){
			resul = min;
		}else{
			resul = var;
		}
		
		return resul;
		
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public HUD getHud() {
		return hud;
	}

	public void setHud(HUD hud) {
		this.hud = hud;
	}

	public Spawn getSpawn() {
		return spawn;
	}

	public void setSpawn(Spawn spawn) {
		this.spawn = spawn;
	}

}
