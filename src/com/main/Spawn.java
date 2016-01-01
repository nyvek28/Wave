package com.main;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private int scoreKeep;
	private Random r;
	
	public Spawn(Handler handler, HUD hud){
		
		this.setHandler(handler);
		this.setHud(hud);
		this.setScoreKeep(0);
		this.setR(new Random());
		
	}
	
	public void tick(){
		
		this.scoreKeep++;
		if(this.getScoreKeep() >= 1000){
			this.setScoreKeep(0);
			this.getHud().setLevel(this.getHud().getLevel() + 1);
			this.getHandler().add(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Id.BasicEnemy, this.getHandler()));
		}
		
		//if(this.getHud().getLevel() == 2){
		//	this.getHandler().add(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Id.BasicEnemy, this.getHandler()));
		//}
		
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

	public int getScoreKeep() {
		return scoreKeep;
	}

	public void setScoreKeep(int scoreKeep) {
		this.scoreKeep = scoreKeep;
	}

	public Random getR() {
		return r;
	}

	public void setR(Random r) {
		this.r = r;
	}
	
}
