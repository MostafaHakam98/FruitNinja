package Interfaces;

import java.awt.image.BufferedImage;

import Fruits.fruitObject.fruitType;

public interface GameObject{
		
	public float getXlocation();


	public float getYlocation();


	public int getMaxHeight();


	public boolean isSliced();
	

	public boolean hasMovedOffScreen();


	public void slice();


	public void move();
	
	
	public boolean isBomb();
	
	
	public boolean isFatal();


	public void setSpeedFactor(Double speedFactor);
	

	public fruitType getFruitType();
	
	
	public BufferedImage [] getBufferedImages();
	
}
