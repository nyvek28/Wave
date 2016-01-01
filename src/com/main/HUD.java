package com.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	public static int HEALTH;
	public int score;
	public int level;
	
	public HUD(){
		
		HUD.setHEALTH(100);
		this.setLevel(1);
		this.setScore(0);
		
	}
	
	public void tick(){
		HEALTH = Game.clamp(HEALTH, 0, 100);
		
		this.score++;
	}
	
	public void render(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 12);
		g.setColor(Color.green);
		g.fillRect(15, 15, HEALTH*2, 12);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 12);
		g.drawString("Score: "+this.getScore(), 15, 44);
		g.drawString("Level: "+this.getLevel(), 15, 60);
	}

	public static int getHEALTH() {
		return HEALTH;
	}

	public static void setHEALTH(int hEALTH) {
		HEALTH = hEALTH;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}
