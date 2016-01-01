package com.main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas {

	private static final long serialVersionUID = -2111860594941368902L;
	private int width;
	private int height;
	private String title;

	public Window(int width, int height, String title, Game game){
		
		this.setHeight(height);
		this.setWidth(width);
		this.setTitle(title);
		JFrame frame;
		
		frame = new JFrame(this.getTitle());
		frame.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		frame.setMaximumSize(new Dimension(this.getWidth(), this.getHeight()));
		frame.setMinimumSize(new Dimension(this.getWidth(), this.getHeight()));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
		
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
