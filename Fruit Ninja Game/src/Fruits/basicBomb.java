package Fruits;


public class basicBomb extends fruitObject {
	
	public basicBomb (int initX, int maxHeight, double C, double speedFactor) {
		setArguments(initX, 719, maxHeight, C, speedFactor);
		setFruitType(fruitType.BOMB);
		setBomb(true);
	}
}
