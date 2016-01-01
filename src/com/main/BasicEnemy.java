package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObj {

	private Handler handler;
	
	public BasicEnemy(int x, int y, Id id, Handler handler) {
		super(x, y, id);
		this.setHandler(handler);
		this.setVelY(8);
		this.setVelX(8);
		
	}

	@Override
	public void tick() {
		
		this.x += velX;
		this.y += velY;
		
		if(this.y <= 0 || this.y >= Game.HEIGHT -32){
			this.velY *= -1;
		}
		if(this.x <= 0 || this.x >= Game.WIDTH -32){
			this.velX *= -1;
		}
		
		this.getHandler().add(new Trail(this.getX(), this.getY(), Id.Trail, Color.red, 16, 16, 0.08f, this.getHandler()));

	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);

	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

}
