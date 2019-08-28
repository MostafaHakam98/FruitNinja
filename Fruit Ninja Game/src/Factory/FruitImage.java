package Factory;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class FruitImage {
	
    private BufferedImage banana;
    private BufferedImage bananaSliced;
	
	private BufferedImage melon;
    private BufferedImage melonSliced;
    
    private BufferedImage peach;
    private BufferedImage peachSliced;

    private BufferedImage orange;
    private BufferedImage orangeSliced;
    
    private BufferedImage lemon;
    private BufferedImage lemonSliced;
    
    private BufferedImage bomb;
    private BufferedImage fatalBomb;

    public FruitImage() {
    	
        try {
            banana = ImageIO.read(new FileInputStream("Images\\Banana.png"));
            bananaSliced = ImageIO.read(new FileInputStream("Images\\Banana Sliced.png"));            
            
            melon = ImageIO.read(new FileInputStream("Images\\Melon.png"));
            melonSliced = ImageIO.read(new FileInputStream("Images\\Melon Sliced.png"));
            
            peach = ImageIO.read(new FileInputStream("Images\\Peach.png"));
            peachSliced = ImageIO.read(new FileInputStream("Images\\Peach Sliced.png"));
            
            orange = ImageIO.read(new FileInputStream("Images\\Orange.png"));
            orangeSliced = ImageIO.read(new FileInputStream("Images\\Orange Sliced.png"));

            lemon = ImageIO.read(new FileInputStream("Images\\Lemon.png"));
            lemonSliced = ImageIO.read(new FileInputStream("Images\\Lemon Sliced.png"));
            
            bomb = ImageIO.read(new FileInputStream("Images\\Bomb.png"));
            
            fatalBomb = ImageIO.read(new FileInputStream("Images\\Fatal Bomb.png"));

        } catch (Exception e) {
        	System.out.println(e);
        }
    }

    public BufferedImage[] getBananaImages(){
    	
        BufferedImage[] Images = new BufferedImage[2];
        
        Images[0] = banana;
        Images[1] = bananaSliced;
        
        return Images;
    }

    public BufferedImage[] getMelonImages(){
        
    	BufferedImage[] Images = new BufferedImage[2];
        
    	Images[0] = melon;
    	Images[1] = melonSliced;
        
        return Images;
    }

    public BufferedImage[] getPeachImages(){
    	
        BufferedImage[] Images = new BufferedImage[2];
        
        Images[0] = peach;
        Images[1] = peachSliced;
        
        return Images;
    }

    public BufferedImage[] getOrangeImages(){
    	
        BufferedImage[] Images = new BufferedImage[2];
        
        Images[0] = orange;
        Images[1] = orangeSliced;
        
        return Images;
    }

    public BufferedImage[] getLemonImages(){
    	
        BufferedImage[] Images = new BufferedImage[2];
        
        Images[0] = lemon;
        Images[1] = lemonSliced;
        
        return Images;
    }
    
    public BufferedImage[] getBombImages() {
    	
    	BufferedImage[] Images = new BufferedImage[2];
    	
    	Images[0] = bomb;
    	Images[1] = bomb;
    	
    	return Images;
    }
    
    public BufferedImage[] getFatalBombImages() {
    	
    	BufferedImage[] Images = new BufferedImage[2];
    	
    	Images[0] = fatalBomb;
    	Images[1] = fatalBomb;
    	
    	return Images;
    }
}
