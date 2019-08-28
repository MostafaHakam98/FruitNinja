package Factory;

import Fruits.*;
import Interfaces.GameObject;

public class FruitCreator {
	
    public FruitCreator() {
    }

    public GameObject createFruit(String type, int xPos, int maxHeight, double C, double speedFactor){

    	switch (type) {
            case "B": return new Banana (xPos, maxHeight, C, speedFactor);
            case "L": return new Lemon (xPos, maxHeight, C, speedFactor);
            case "M": return new Melon (xPos, maxHeight, C, speedFactor);
            case "O": return new Orange (xPos, maxHeight, C, speedFactor);
            case "P": return new Peach (xPos, maxHeight, C, speedFactor);
            case "G": return new Guava (xPos, maxHeight, C, speedFactor);
            case "PG": return new Pomegranate (xPos, maxHeight, C, speedFactor);
            case "PA": return new Pineapple (xPos, maxHeight, C, speedFactor);
            
            case "BB": return new basicBomb (xPos, maxHeight, C, speedFactor);
            case "FB": return new fatalBomb (xPos, maxHeight, C, speedFactor);
            
            default: return null;
        }
    }
}