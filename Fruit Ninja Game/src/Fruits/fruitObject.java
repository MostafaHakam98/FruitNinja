package Fruits;

import java.awt.image.BufferedImage;

import Interfaces.GameObject;

public abstract class fruitObject implements GameObject {
	
	public enum fruitType{
		BANANA,
		LEMON,
		MELON,
		ORANGE,
		PEACH,
		BOMB,
		FATAL,
		POMEGRANATE,
		GUAVA,
		PINAEAPPLE
	}
	
	BufferedImage[] images;
	private boolean isSliced = false;
	private boolean isOffScreen = false;
	private boolean isBomb = false;
	private boolean isFatal = false;
	private boolean hasReachedMaxHeight = false;
	private boolean toRight;
	private double C, speedFactor;
	private float x, y;
	private int initX, maxHeight;
	private fruitType type;

	
	public void setArguments (int initX, int y, int maxHeight, double C, double speedFactor) {
		this.x = initX;
		this.y = y;
		this.initX = initX;
		this.maxHeight = maxHeight;
		this.C = C;
		this.speedFactor = speedFactor;
	}
	
	
	public float getXlocation() {
		return x;
	}

	public float getYlocation() {
		return y;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public boolean isSliced() {
		return isSliced;
	}
	
	public boolean hasMovedOffScreen() {
		if(getYlocation() > 720)
			isOffScreen = true;
		return isOffScreen;
	}

	public void slice() {
		isSliced = true;
	}

	public void move () {
		
		/*
		 * maxHeight [500 : 700]
		 * initX [0 : 1280]
		 * C [0.007 : 0.1]
		 * speedFactor [0.2 : 0.4]
		 */
		/*
		double height;
		
		if(initX < 640)
			toRight = true;
		else
			toRight = false;
		
		if(toRight) {
			x += speedFactor;
			height = maxHeight - C * Math.pow((x - 1/Math.sqrt(C) * (initX * Math.sqrt(C) + Math.sqrt(maxHeight))), 2);
		}
		else {
			x -= speedFactor;
			height = maxHeight - C * Math.pow((x - 1/Math.sqrt(C) * (initX * Math.sqrt(C) - Math.sqrt(maxHeight))), 2);
		}
		
		y = 720 -  Math.round(height);*/
		
		if(initX < 640)
			toRight = true;
		else
			toRight = false;
		
		if(isSliced()) {
			speedFactor *= 1.01;
			y += speedFactor/2;
		}
		
		else {
			
			if(x >= 1280)
				initX = 1000;
			
			if(x <= 0)
				initX = 100;
			
			
			if(toRight)
				x += speedFactor/1.5;
			else
				x -= speedFactor/1.5;
			
			if(y <= maxHeight)
				hasReachedMaxHeight = true;
			
			if(!hasReachedMaxHeight)
				y -= speedFactor;
			else if(hasReachedMaxHeight)
				y += speedFactor;
		}	
	}

	public BufferedImage[] getBufferedImages() {
		return images;
	}
	
	public fruitType getFruitType() {
		return type;
	}
	
	public void setFruitType(fruitType type) {
		this.type = type;
	}
	
	public void setSpeedFactor(Double speedFactor) {
		this.speedFactor = speedFactor;
	}

	public boolean isFatal() {
		return isFatal;
	}

	public void setFatal(boolean isFatal) {
		this.isFatal = isFatal;
	}

	public boolean isBomb() {
		return isBomb;
	}

	public void setBomb(boolean isBomb) {
		this.isBomb = isBomb;
	}

	
	public double getC() {
		return C;
	}
}
