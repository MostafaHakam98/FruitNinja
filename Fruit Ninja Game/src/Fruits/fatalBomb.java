package Fruits;


public class fatalBomb extends fruitObject {
	
	public fatalBomb (int initX, int maxHeight, double C, double speedFactor) {
		setArguments(initX, 719, maxHeight, C, speedFactor);
		setFruitType(fruitType.FATAL);
		setBomb(true);
		setFatal(true);
		
	}	
}
