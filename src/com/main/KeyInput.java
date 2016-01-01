package com.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	
	public KeyInput(Handler handler){
		
		this.setHandler(handler);
		
	}
	
	public void keyPressed(KeyEvent e){
		
		int key;
		
		key = e.getKeyCode();
		for (int i = 0; i < this.getHandler().objects.size(); i++){
			GameObj go = this.getHandler().objects.get(i);
			
			if(go.getId() == Id.Player){
				if(key == KeyEvent.VK_W){
					go.setVelY(-8);
				}else if(key == KeyEvent.VK_S){
					go.setVelY(8);
				}else if(key == KeyEvent.VK_A){
					go.setVelX(-8);
				}else if(key == KeyEvent.VK_D){
					go.setVelX(8);
				}
			}
			
			if(go.getId() == Id.Player){
				if(key == KeyEvent.VK_UP){
					go.setVelY(-8);
				}else if(key == KeyEvent.VK_DOWN){
					go.setVelY(8);
				}else if(key == KeyEvent.VK_LEFT){
					go.setVelX(-8);
				}else if(key == KeyEvent.VK_RIGHT){
					go.setVelX(8);
				}
			}
			
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		
		int key;
		
		key = e.getKeyCode();
		for (int i = 0; i < this.getHandler().objects.size(); i++){
			GameObj go = this.getHandler().objects.get(i);
			
			if(go.getId() == Id.Player){
				if(key == KeyEvent.VK_W){
					go.setVelY(0);
				}else if(key == KeyEvent.VK_S){
					go.setVelY(0);
				}else if(key == KeyEvent.VK_A){
					go.setVelX(0);
				}else if(key == KeyEvent.VK_D){
					go.setVelX(0);
				}
			}
			
			if(go.getId() == Id.Player){
				if(key == KeyEvent.VK_UP){
					go.setVelY(0);
				}else if(key == KeyEvent.VK_DOWN){
					go.setVelY(0);
				}else if(key == KeyEvent.VK_LEFT){
					go.setVelX(0);
				}else if(key == KeyEvent.VK_RIGHT){
					go.setVelX(0);
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
