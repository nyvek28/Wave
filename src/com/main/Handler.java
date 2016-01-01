package com.main;

import java.awt.Graphics;
import java.util.ArrayList;

public class Handler {

	ArrayList<GameObj> objects = new ArrayList<GameObj>();
	
	public void tick(){
		for(int i = 0; i < objects.size(); i++){
			
			GameObj go = objects.get(i);
			go.tick();
			
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < objects.size(); i++){
			
			GameObj go = objects.get(i);
			go.render(g);
			
		}
	}
	
	public void add(GameObj go){
		this.objects.add(go);
	}
	
	public void remove(GameObj go){
		this.objects.remove(go);
	}
	
}
