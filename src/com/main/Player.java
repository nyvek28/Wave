package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class Player extends GameObj{
	
	private Handler handler;

	public Player(int x, int y, Id id, Handler handler) {
		super(x, y, id);
		this.setHandler(handler);
	}

	@Override
	public void tick() {
		
		this.x += this.velX;
		this.y += this.velY;
		this.y = Game.clamp(y, 0, Game.HEIGHT -52);
		this.x = Game.clamp(x, 0, Game.WIDTH - 32);
		this.collide();
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}
	
	private void collide(){
		for(int i = 0; i < this.getHandler().objects.size(); i++){
			GameObj go = this.getHandler().objects.get(i);
			
			if(go.getId() == Id.BasicEnemy){
				if(this.getBounds().intersects(go.getBounds())){
					HUD.HEALTH -= 2;
					if(HUD.HEALTH <= 0){
						JOptionPane.showMessageDialog(null, "GAME OVER");
						System.exit(0);
					}
				}
			}
			
		}
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	
	
}
