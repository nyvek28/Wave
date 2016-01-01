package com.main;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private int scoreKeep;
	
	public Spawn(Handler handler, HUD hud){
		
		this.setHandler(handler);
		this.setHud(hud);
		this.setScoreKeep(0);
		
	}
	
	public void tick(){
		
		this.scoreKeep++;
		if(this.getScoreKeep() >= 1000){
			this.setScoreKeep(0);
			this.getHud().setLevel(this.getHud().getLevel() + 1);
		}
		
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
	
}
