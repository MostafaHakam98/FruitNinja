package GUI;

import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.util.BufferedImageUtil;

import Fruits.*;
import Interfaces.GameObject;
import Levels.Level;
import Levels.Level.levelDifficulty;
import Levels.LevelOne;
import Levels.LevelThree;
import Levels.LevelTwo;
import System.GameEngine;

public class Play extends BasicGameState {
	
	public static final float fruitScale = 0.15f;
	
	private GameEngine Engine;
	private Level level;
	
	GameObject fruitZero;
	GameObject fruitOne;
	GameObject fruitTwo;
	GameObject fruitThree;
	GameObject fruitFour;
	GameObject fruitFive;
	GameObject fruitSix;
	
	Image Zero;
	Image One;
	Image Two;
	Image Three;
	Image Four;
	Image Five;
	Image Six;
	Image Seven;
	
	Image banana;
    Image bananaSliced;
	Image melon;
    Image melonSliced;
    Image peach;
    Image peachSliced;
    Image orange;
    Image orangeSliced;
    Image lemon;
    Image lemonSliced;
    Image pine;
    Image pineSliced;
    Image guava;
    Image guavaSliced;
    Image bomb;
    Image bombSliced;
    Image fatalBomb;
    Image fatalBombSliced;
    
    Image bg;
    
    Image pome;
    Image pomeSliced;
    
    Image Kunai;
    Image YouLost;
    Image TimeUp;
	
	int flagZero;
	int flagOne;
	int flagTwo;
	int flagThree;
	int flagFour;
	int flagFive;
	int flagSix;
	
	int flagSpecial;
	int special;
	
	Image lifeOne;
	Image lifeTwo;
	Image lifeThree;	
	
	Image background;
	Image backgroundDarkened;
	Image Nuclear;
	
	Image Life;
	Image points;
	
	String time;
	String score;
	String highScore;
	
	Sound bombSound;
	Sound fatalSound;
	Sound sliceSound;
	
	public Play (int state) {
	}

	//---------------------------------------------------------INITIATE-----------------------------------------------------------------------------//
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		if (Levels.flag == 1)
			level = new LevelOne();
		else if (Levels.flag == 2)
			level = new LevelTwo();
		else if (Levels.flag == 3)
			level = new LevelThree();
		else if (Levels.flag == 4)
			level = new LevelTwo();
		
		Engine = new GameEngine(level);
		Engine.loadGame();
		
		time = new String();
		score = new String();
		highScore = new String();
		
		Life = new Image("Images\\Life.png");
		points = new Image("Images\\300.png");
		
		bombSound = new Sound("Music\\bomb.wav");
		fatalSound = new Sound("Music\\fatalBomb.ogg");
		sliceSound = new Sound("Music\\slice.wav");
		
		special = 0;
		
		if (Levels.flag == 4 && Engine.getLife() > 0)
			Engine.setLife(3);

		try {
		
		 banana = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Banana.png"))));
         bananaSliced = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Banana Sliced.png"))));
         
         melon = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Melon.png"))));
         melonSliced = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Melon Sliced.png"))));
         
         peach = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Peach.png"))));
         peachSliced = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Peach Sliced.png"))));
         
         orange = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Orange.png"))));
         orangeSliced = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Orange Sliced.png"))));

         lemon = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Lemon.png"))));
         lemonSliced = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Lemon Sliced.png"))));
         
         pine = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Pineapple.png"))));
         pineSliced = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\PineappleSliced.png"))));
         
         guava = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Guava.png"))));
         guavaSliced = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\GuavaSliced.png"))));
         
         bomb = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Bomb.png"))));
         bombSliced = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Bomb Sliced.png"))));
         
         pome = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Pomegranate.png"))));
         pomeSliced = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\PomegranateSliced.png"))));
         
         fatalBomb = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Fatal Bomb.png"))));
         fatalBombSliced = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Fatal Bomb.png"))));
         
         Kunai = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Kunai.png"))));
         YouLost = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\You Lost.png"))));
         TimeUp = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\TimeUp.png"))));
         Nuclear = new Image(BufferedImageUtil.getTexture(null, ImageIO.read(new FileInputStream("Images\\Fatal Bomb Sliced.png")))); 
         
		}	
		catch (IOException e) {
			e.printStackTrace();
		}
		
		flagZero = 1;
		flagOne = 1;
		flagTwo = 1;
		flagThree = 1;
		flagFour = 1;
		flagFive = 1;
		flagSix = 1;
		
		flagSpecial = 0;
				
		if (level.getDifficulty() == Level.levelDifficulty.BANANA) {
			
			background = new Image("Images\\backgroundBanana.png");
			backgroundDarkened = new Image("Images\\backgroundBananaDarkened.png");

			Engine.createFruitList();
			
			fruitZero = Engine.getFruits().get(0);
			fruitOne = Engine.getFruits().get(1);
			fruitTwo = Engine.getFruits().get(2);
		}
		
		else if (level.getDifficulty() == Level.levelDifficulty.PEACH) {
			
			if (Levels.flag == 4) {
				background = new Image("Images\\backgroundPG.png");
				backgroundDarkened = new Image("Images\\backgroundPGDarkened.png");
			}
			
			else {
				background = new Image("Images\\backgroundPeach.png");
				backgroundDarkened = new Image("Images\\backgroundPeachDarkened.png");
			}
			
			Engine.createFruitList();

			fruitZero = Engine.getFruits().get(0);
			fruitOne = Engine.getFruits().get(1);
			fruitTwo = Engine.getFruits().get(2);
			fruitThree = Engine.getFruits().get(3);
			fruitFour = Engine.getFruits().get(4);
		}
		
		else if (level.getDifficulty() == Level.levelDifficulty.MELON) {
			
			background = new Image("Images\\backgroundMelon.png");
			backgroundDarkened = new Image("Images\\backgroundMelonDarkened.png");
			
			Engine.createFruitList();
			
			fruitZero = Engine.getFruits().get(0);
			fruitOne = Engine.getFruits().get(1);
			fruitTwo = Engine.getFruits().get(2);
			fruitThree = Engine.getFruits().get(3);
			fruitFour = Engine.getFruits().get(4);
			fruitFive = Engine.getFruits().get(5);
			fruitSix = Engine.getFruits().get(6);			
		}
		
		bg = background;
	}

	//---------------------------------------------------------RENDER-----------------------------------------------------------------------------//
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		bg.draw(0, 0, 0.7f);
		
		int xPos = Mouse.getX();
		int yPos = 720 - Mouse.getY();
				
		if (level.getDifficulty() == Level.levelDifficulty.BANANA) {
			
			if (flagZero == 1) {
				if (fruitZero instanceof Banana)
					Zero = banana;
				else if (fruitZero instanceof Melon)
					Zero = melon;
				else if (fruitZero instanceof Peach)
					Zero = peach;
				else if (fruitZero instanceof Pomegranate)
					Zero = pome;
				else if (fruitZero instanceof Lemon)
					Zero = lemon;
				else if (fruitZero instanceof Orange)
					Zero = orange;
				else if (fruitZero instanceof basicBomb)
					Zero = bomb;
				else if (fruitZero instanceof fatalBomb)
					Zero = fatalBomb;
				else if (fruitZero instanceof Pineapple)
					Zero = pine;
				else if (fruitZero instanceof Guava)
					Zero = guava;
			}
			
			else if (flagZero == 2) {
				if (fruitZero instanceof Banana)
					Zero = bananaSliced;
				else if (fruitZero instanceof Melon)
					Zero = melonSliced;
				else if (fruitZero instanceof Peach)
					Zero = peachSliced;
				else if (fruitZero instanceof Lemon)
					Zero = lemonSliced;
				else if (fruitZero instanceof Orange)
					Zero = orangeSliced;
				else if (fruitZero instanceof basicBomb)
					Zero = bombSliced;
				else if (fruitZero instanceof fatalBomb)
					Zero = fatalBombSliced;
				else if (fruitZero instanceof Pomegranate)
					Zero = pomeSliced;
				else if (fruitZero instanceof Pineapple)
					Zero = pineSliced;
				else if (fruitZero instanceof Guava)
					Zero = guavaSliced;
			}
			
			if (flagOne == 1) {
				if (fruitOne instanceof Banana)
					One = banana;
				else if (fruitOne instanceof Melon)
					One = melon;
				else if (fruitOne instanceof Peach)
					One = peach;
				else if (fruitOne instanceof Lemon)
					One = lemon;
				else if (fruitOne instanceof Orange)
					One = orange;
				else if (fruitOne instanceof basicBomb)
					One = bomb;
				else if (fruitOne instanceof fatalBomb)
					One = fatalBomb;
				else if (fruitOne instanceof Pomegranate)
					One = pome;
				else if (fruitOne instanceof Pineapple)
					One = pine;
				else if (fruitOne instanceof Guava)
					One = guava;
			}
			
			else if (flagOne == 2) {
				if (fruitOne instanceof Banana)
					One = bananaSliced;
				else if (fruitOne instanceof Melon)
					One = melonSliced;
				else if (fruitOne instanceof Peach)
					One = peachSliced;
				else if (fruitOne instanceof Lemon)
					One = lemonSliced;
				else if (fruitOne instanceof Orange)
					One = orangeSliced;
				else if (fruitOne instanceof basicBomb)
					One = bombSliced;
				else if (fruitOne instanceof fatalBomb)
					One = fatalBombSliced;
				else if (fruitOne instanceof Pomegranate)
					One = pomeSliced;
				else if (fruitOne instanceof Pineapple)
					One = pineSliced;
				else if (fruitOne instanceof Guava)
					One = guavaSliced;
			}
			
			if (flagTwo == 1) {
				if (fruitTwo instanceof Banana)
					Two = banana;
				else if (fruitTwo instanceof Melon)
					Two = melon;
				else if (fruitTwo instanceof Peach)
					Two = peach;
				else if (fruitTwo instanceof Lemon)
					Two = lemon;
				else if (fruitTwo instanceof Orange)
					Two = orange;
				else if (fruitTwo instanceof basicBomb)
					Two = bomb;
				else if (fruitTwo instanceof fatalBomb)
					Two = fatalBomb;
				else if (fruitTwo instanceof Pomegranate)
					Two = pome;
				else if (fruitTwo instanceof Pineapple)
					Two = pine;
				else if (fruitOne instanceof Guava)
					Two = guava;
			}
			
			else if (flagTwo == 2) {
				if (fruitTwo instanceof Banana)
					Two = bananaSliced;
				else if (fruitTwo instanceof Melon)
					Two = melonSliced;
				else if (fruitTwo instanceof Peach)
					Two = peachSliced;
				else if (fruitTwo instanceof Lemon)
					Two = lemonSliced;
				else if (fruitTwo instanceof Orange)
					Two = orangeSliced;
				else if (fruitTwo instanceof basicBomb)
					Two = bombSliced;
				else if (fruitTwo instanceof fatalBomb)
					Two = fatalBombSliced;
				else if (fruitTwo instanceof Pomegranate)
					Two = pomeSliced;
				else if (fruitTwo instanceof Pineapple)
					Two = pineSliced;
				else if (fruitOne instanceof Guava)
					Two = guavaSliced;
			}
			
			flagZero = 0;
			flagOne = 0;
			flagTwo = 0;
			
			Zero.draw(fruitZero.getXlocation(), fruitZero.getYlocation(), fruitScale);
			One.draw(fruitOne.getXlocation(), fruitOne.getYlocation(), fruitScale);
			Two.draw(fruitTwo.getXlocation(), fruitTwo.getYlocation(), fruitScale);
			
			if(Engine.getLife() == 3) {
				lifeOne = banana;
				lifeTwo = banana;
				lifeThree = banana;
			}
			
			else if(Engine.getLife() == 2) {
				lifeOne = bananaSliced;
				lifeTwo = banana;
				lifeThree = banana;
			}
			
			else if(Engine.getLife() == 1) {
				lifeOne = bananaSliced;
				lifeTwo = bananaSliced;
				lifeThree = banana;
			}
			
			else if(Engine.getLife() == 0) {
				lifeOne = bananaSliced;
				lifeTwo = bananaSliced;
				lifeThree = bananaSliced;
			}
		}
		
		else if (level.getDifficulty() == Level.levelDifficulty.PEACH) {
			
			if (flagZero == 1) {
				if (fruitZero instanceof Banana)
					Zero = banana;
				else if (fruitZero instanceof Melon)
					Zero = melon;
				else if (fruitZero instanceof Peach)
					Zero = peach;
				else if (fruitZero instanceof Pomegranate)
					Zero = pome;
				else if (fruitZero instanceof Lemon)
					Zero = lemon;
				else if (fruitZero instanceof Orange)
					Zero = orange;
				else if (fruitZero instanceof basicBomb)
					Zero = bomb;
				else if (fruitZero instanceof fatalBomb)
					Zero = fatalBomb;
				else if (fruitZero instanceof Pineapple)
					Zero = pine;
				else if (fruitZero instanceof Guava)
					Zero = guava;
			}
			
			else if (flagZero == 2) {
				if (fruitZero instanceof Banana)
					Zero = bananaSliced;
				else if (fruitZero instanceof Melon)
					Zero = melonSliced;
				else if (fruitZero instanceof Peach)
					Zero = peachSliced;
				else if (fruitZero instanceof Lemon)
					Zero = lemonSliced;
				else if (fruitZero instanceof Orange)
					Zero = orangeSliced;
				else if (fruitZero instanceof basicBomb)
					Zero = bombSliced;
				else if (fruitZero instanceof fatalBomb)
					Zero = fatalBombSliced;
				else if (fruitZero instanceof Pomegranate)
					Zero = pomeSliced;
				else if (fruitZero instanceof Pineapple)
					Zero = pineSliced;
				else if (fruitZero instanceof Guava)
					Zero = guavaSliced;
			}
			
			if (flagOne == 1) {
				if (fruitOne instanceof Banana)
					One = banana;
				else if (fruitOne instanceof Melon)
					One = melon;
				else if (fruitOne instanceof Peach)
					One = peach;
				else if (fruitOne instanceof Lemon)
					One = lemon;
				else if (fruitOne instanceof Orange)
					One = orange;
				else if (fruitOne instanceof basicBomb)
					One = bomb;
				else if (fruitOne instanceof fatalBomb)
					One = fatalBomb;
				else if (fruitOne instanceof Pomegranate)
					One = pome;
				else if (fruitOne instanceof Pineapple)
					One = pine;
				else if (fruitOne instanceof Guava)
					One = guava;
			}
			
			else if (flagOne == 2) {
				if (fruitOne instanceof Banana)
					One = bananaSliced;
				else if (fruitOne instanceof Melon)
					One = melonSliced;
				else if (fruitOne instanceof Peach)
					One = peachSliced;
				else if (fruitOne instanceof Lemon)
					One = lemonSliced;
				else if (fruitOne instanceof Orange)
					One = orangeSliced;
				else if (fruitOne instanceof basicBomb)
					One = bombSliced;
				else if (fruitOne instanceof fatalBomb)
					One = fatalBombSliced;
				else if (fruitOne instanceof Pomegranate)
					One = pomeSliced;
				else if (fruitOne instanceof Pineapple)
					One = pineSliced;
				else if (fruitOne instanceof Guava)
					One = guavaSliced;
			}
			
			if (flagTwo == 1) {
				if (fruitTwo instanceof Banana)
					Two = banana;
				else if (fruitTwo instanceof Melon)
					Two = melon;
				else if (fruitTwo instanceof Peach)
					Two = peach;
				else if (fruitTwo instanceof Lemon)
					Two = lemon;
				else if (fruitTwo instanceof Orange)
					Two = orange;
				else if (fruitTwo instanceof basicBomb)
					Two = bomb;
				else if (fruitTwo instanceof fatalBomb)
					Two = fatalBomb;
				else if (fruitTwo instanceof Pomegranate)
					Two = pome;
				else if (fruitTwo instanceof Pineapple)
					Two = pine;
				else if (fruitTwo instanceof Guava)
					Two = guava;
			}
			
			else if (flagTwo == 2) {
				if (fruitTwo instanceof Banana)
					Two = bananaSliced;
				else if (fruitTwo instanceof Melon)
					Two = melonSliced;
				else if (fruitTwo instanceof Peach)
					Two = peachSliced;
				else if (fruitTwo instanceof Lemon)
					Two = lemonSliced;
				else if (fruitTwo instanceof Orange)
					Two = orangeSliced;
				else if (fruitTwo instanceof basicBomb)
					Two = bombSliced;
				else if (fruitTwo instanceof fatalBomb)
					Two = fatalBombSliced;
				else if (fruitTwo instanceof Pomegranate)
					Two = pomeSliced;
				else if (fruitTwo instanceof Pineapple)
					Two = pineSliced;
				else if (fruitTwo instanceof Guava)
					Two = guavaSliced;
			}
			
			if (flagThree == 1) {
				if (fruitThree instanceof Banana)
					Three = banana;
				else if (fruitThree instanceof Melon)
					Three = melon;
				else if (fruitThree instanceof Peach)
					Three = peach;
				else if (fruitThree instanceof Lemon)
					Three = lemon;
				else if (fruitThree instanceof Orange)
					Three = orange;
				else if (fruitThree instanceof basicBomb)
					Three = bomb;
				else if (fruitThree instanceof fatalBomb)
					Three = fatalBomb;
				else if (fruitThree instanceof Pomegranate)
					Three = pome;
				else if (fruitThree instanceof Pineapple)
					Three = pine;
				else if (fruitThree instanceof Guava)
					Three = guava;
			}
			
			else if (flagThree == 2) {
				if (fruitThree instanceof Banana)
					Three = bananaSliced;
				else if (fruitThree instanceof Melon)
					Three = melonSliced;
				else if (fruitThree instanceof Peach)
					Three = peachSliced;
				else if (fruitThree instanceof Lemon)
					Three = lemonSliced;
				else if (fruitThree instanceof Orange)
					Three = orangeSliced;
				else if (fruitThree instanceof basicBomb)
					Three = bombSliced;
				else if (fruitThree instanceof fatalBomb)
					Three = fatalBombSliced;
				else if (fruitThree instanceof Pomegranate)
					Three = pomeSliced;
				else if (fruitThree instanceof Pineapple)
					Three = pineSliced;
				else if (fruitThree instanceof Guava)
					Three = guavaSliced;
			}
			if (flagFour == 1) {
				if (fruitFour instanceof Banana)
					Four = banana;
				else if (fruitFour instanceof Melon)
					Four = melon;
				else if (fruitFour instanceof Peach)
					Four = peach;
				else if (fruitFour instanceof Lemon)
					Four = lemon;
				else if (fruitFour instanceof Orange)
					Four = orange;
				else if (fruitFour instanceof basicBomb)
					Four = bomb;
				else if (fruitFour instanceof fatalBomb)
					Four = fatalBomb;
				else if (fruitFour instanceof Pomegranate)
					Four = pome;
				else if (fruitFour instanceof Pineapple)
					Four = pine;
				else if (fruitFour instanceof Guava)
					Four = guava;
			}
				
			else if (flagFour == 2) {
				if (fruitFour instanceof Banana)
					Four = bananaSliced;
				else if (fruitFour instanceof Melon)
					Four = melonSliced;
				else if (fruitFour instanceof Peach)
					Four = peachSliced;
				else if (fruitFour instanceof Lemon)
					Four = lemonSliced;
				else if (fruitFour instanceof Orange)
					Four = orangeSliced;
				else if (fruitFour instanceof basicBomb)
					Four = bombSliced;
				else if (fruitFour instanceof fatalBomb)
					Four = fatalBombSliced;
				else if (fruitFour instanceof Pomegranate)
					Four = pomeSliced;
				else if (fruitFour instanceof Pineapple)
					Four = pineSliced;
				else if (fruitFour instanceof Guava)
					Four = guavaSliced;
			}
		
			flagZero = 0;
			flagOne = 0;
			flagTwo = 0;
			flagThree = 0;
			flagFour = 0;
			
			Zero.draw(fruitZero.getXlocation(), fruitZero.getYlocation(), fruitScale);
			One.draw(fruitOne.getXlocation(), fruitOne.getYlocation(), fruitScale);
			Two.draw(fruitTwo.getXlocation(), fruitTwo.getYlocation(), fruitScale);
			Three.draw(fruitThree.getXlocation(), fruitThree.getYlocation(), fruitScale);
			Four.draw(fruitFour.getXlocation(), fruitFour.getYlocation(), fruitScale);
			
			if(Engine.getLife() == 3) {
				lifeOne = peach;
				lifeTwo = peach;
				lifeThree = peach;
			}
			
			else if(Engine.getLife() == 2) {
				lifeOne = peachSliced;
				lifeTwo = peach;
				lifeThree = peach;
			}
			
			else if(Engine.getLife() == 1) {
				lifeOne = peachSliced;
				lifeTwo = peachSliced;
				lifeThree = peach;
			}
			
			else if(Engine.getLife() == 0) {
				lifeOne = peachSliced;
				lifeTwo = peachSliced;
				lifeThree = peachSliced;
			}
		}
		
		else if (level.getDifficulty() == Level.levelDifficulty.MELON) {

			if (flagZero == 1) {
				if (fruitZero instanceof Banana)
					Zero = banana;
				else if (fruitZero instanceof Melon)
					Zero = melon;
				else if (fruitZero instanceof Peach)
					Zero = peach;
				else if (fruitZero instanceof Pomegranate)
					Zero = pome;
				else if (fruitZero instanceof Lemon)
					Zero = lemon;
				else if (fruitZero instanceof Orange)
					Zero = orange;
				else if (fruitZero instanceof basicBomb)
					Zero = bomb;
				else if (fruitZero instanceof fatalBomb)
					Zero = fatalBomb;
				else if (fruitZero instanceof Pineapple)
					Zero = pine;
				else if (fruitZero instanceof Guava)
					Zero = guava;
			}
			
			else if (flagZero == 2) {
				if (fruitZero instanceof Banana)
					Zero = bananaSliced;
				else if (fruitZero instanceof Melon)
					Zero = melonSliced;
				else if (fruitZero instanceof Peach)
					Zero = peachSliced;
				else if (fruitZero instanceof Lemon)
					Zero = lemonSliced;
				else if (fruitZero instanceof Orange)
					Zero = orangeSliced;
				else if (fruitZero instanceof basicBomb)
					Zero = bombSliced;
				else if (fruitZero instanceof fatalBomb)
					Zero = fatalBombSliced;
				else if (fruitZero instanceof Pomegranate)
					Zero = pomeSliced;
				else if (fruitZero instanceof Pineapple)
					Zero = pineSliced;
				else if (fruitZero instanceof Guava)
					Zero = guavaSliced;
			}
			
			if (flagOne == 1) {
				if (fruitOne instanceof Banana)
					One = banana;
				else if (fruitOne instanceof Melon)
					One = melon;
				else if (fruitOne instanceof Peach)
					One = peach;
				else if (fruitOne instanceof Lemon)
					One = lemon;
				else if (fruitOne instanceof Orange)
					One = orange;
				else if (fruitOne instanceof basicBomb)
					One = bomb;
				else if (fruitOne instanceof fatalBomb)
					One = fatalBomb;
				else if (fruitOne instanceof Pomegranate)
					One = pome;
				else if (fruitOne instanceof Pineapple)
					One = pine;
				else if (fruitOne instanceof Guava)
					One = guava;
			}
			
			else if (flagOne == 2) {
				if (fruitOne instanceof Banana)
					One = bananaSliced;
				else if (fruitOne instanceof Melon)
					One = melonSliced;
				else if (fruitOne instanceof Peach)
					One = peachSliced;
				else if (fruitOne instanceof Lemon)
					One = lemonSliced;
				else if (fruitOne instanceof Orange)
					One = orangeSliced;
				else if (fruitOne instanceof basicBomb)
					One = bombSliced;
				else if (fruitOne instanceof fatalBomb)
					One = fatalBombSliced;
				else if (fruitOne instanceof Pomegranate)
					One = pomeSliced;
				else if (fruitOne instanceof Pineapple)
					One = pineSliced;
				else if (fruitOne instanceof Guava)
					One = guavaSliced;
			}
			
			if (flagTwo == 1) {
				if (fruitTwo instanceof Banana)
					Two = banana;
				else if (fruitTwo instanceof Melon)
					Two = melon;
				else if (fruitTwo instanceof Peach)
					Two = peach;
				else if (fruitTwo instanceof Lemon)
					Two = lemon;
				else if (fruitTwo instanceof Orange)
					Two = orange;
				else if (fruitTwo instanceof basicBomb)
					Two = bomb;
				else if (fruitTwo instanceof fatalBomb)
					Two = fatalBomb;
				else if (fruitTwo instanceof Pomegranate)
					Two = pome;
				else if (fruitTwo instanceof Pineapple)
					Two = pine;
				else if (fruitTwo instanceof Guava)
					Two = guava;
			}
			
			else if (flagTwo == 2) {
				if (fruitTwo instanceof Banana)
					Two = bananaSliced;
				else if (fruitTwo instanceof Melon)
					Two = melonSliced;
				else if (fruitTwo instanceof Peach)
					Two = peachSliced;
				else if (fruitTwo instanceof Lemon)
					Two = lemonSliced;
				else if (fruitTwo instanceof Orange)
					Two = orangeSliced;
				else if (fruitTwo instanceof basicBomb)
					Two = bombSliced;
				else if (fruitTwo instanceof fatalBomb)
					Two = fatalBombSliced;
				else if (fruitTwo instanceof Pomegranate)
					Two = pomeSliced;
				else if (fruitTwo instanceof Pineapple)
					Two = pineSliced;
				else if (fruitTwo instanceof Guava)
					Two = guavaSliced;
			}
			
			if (flagThree == 1) {
				if (fruitThree instanceof Banana)
					Three = banana;
				else if (fruitThree instanceof Melon)
					Three = melon;
				else if (fruitThree instanceof Peach)
					Three = peach;
				else if (fruitThree instanceof Lemon)
					Three = lemon;
				else if (fruitThree instanceof Orange)
					Three = orange;
				else if (fruitThree instanceof basicBomb)
					Three = bomb;
				else if (fruitThree instanceof fatalBomb)
					Three = fatalBomb;
				else if (fruitThree instanceof Pomegranate)
					Three = pome;
				else if (fruitThree instanceof Pineapple)
					Three = pine;
				else if (fruitThree instanceof Guava)
					Three = guava;
			}
			
			else if (flagThree == 2) {
				if (fruitThree instanceof Banana)
					Three = bananaSliced;
				else if (fruitThree instanceof Melon)
					Three = melonSliced;
				else if (fruitThree instanceof Peach)
					Three = peachSliced;
				else if (fruitThree instanceof Lemon)
					Three = lemonSliced;
				else if (fruitThree instanceof Orange)
					Three = orangeSliced;
				else if (fruitThree instanceof basicBomb)
					Three = bombSliced;
				else if (fruitThree instanceof fatalBomb)
					Three = fatalBombSliced;
				else if (fruitThree instanceof Pomegranate)
					Three = pomeSliced;
				else if (fruitThree instanceof Pineapple)
					Three = pineSliced;
				else if (fruitThree instanceof Guava)
					Three = guavaSliced;
			}
			if (flagFour == 1) {
				if (fruitFour instanceof Banana)
					Four = banana;
				else if (fruitFour instanceof Melon)
					Four = melon;
				else if (fruitFour instanceof Peach)
					Four = peach;
				else if (fruitFour instanceof Lemon)
					Four = lemon;
				else if (fruitFour instanceof Orange)
					Four = orange;
				else if (fruitFour instanceof basicBomb)
					Four = bomb;
				else if (fruitFour instanceof fatalBomb)
					Four = fatalBomb;
				else if (fruitFour instanceof Pomegranate)
					Four = pome;
				else if (fruitFour instanceof Pineapple)
					Four = pine;
				else if (fruitFour instanceof Guava)
					Four = guava;
			}
				
			else if (flagFour == 2) {
				if (fruitFour instanceof Banana)
					Four = bananaSliced;
				else if (fruitFour instanceof Melon)
					Four = melonSliced;
				else if (fruitFour instanceof Peach)
					Four = peachSliced;
				else if (fruitFour instanceof Lemon)
					Four = lemonSliced;
				else if (fruitFour instanceof Orange)
					Four = orangeSliced;
				else if (fruitFour instanceof basicBomb)
					Four = bombSliced;
				else if (fruitFour instanceof fatalBomb)
					Four = fatalBombSliced;
				else if (fruitFour instanceof Pomegranate)
					Four = pomeSliced;
				else if (fruitFour instanceof Pineapple)
					Four = pineSliced;
				else if (fruitFour instanceof Guava)
					Four = guavaSliced;
			}
			
			if (flagFive == 1) {
				if (fruitFive instanceof Banana)
					Five = banana;
				else if (fruitFive instanceof Melon)
					Five = melon;
				else if (fruitFive instanceof Peach)
					Five = peach;
				else if (fruitFive instanceof Lemon)
					Five = lemon;
				else if (fruitFive instanceof Orange)
					Five = orange;
				else if (fruitFive instanceof basicBomb)
					Five = bomb;
				else if (fruitFive instanceof fatalBomb)
					Five = fatalBomb;
				else if (fruitFive instanceof Pomegranate)
					Five = pome;
				else if (fruitFive instanceof Pineapple)
					Five = pine;
				else if (fruitFive instanceof Guava)
					Five = guava;
			}
			
			else if (flagFive == 2) {
				if (fruitFive instanceof Banana)
					Five = bananaSliced;
				else if (fruitFive instanceof Melon)
					Five = melonSliced;
				else if (fruitFive instanceof Peach)
					Five = peachSliced;
				else if (fruitFive instanceof Lemon)
					Five = lemonSliced;
				else if (fruitFive instanceof Orange)
					Five = orangeSliced;
				else if (fruitFive instanceof basicBomb)
					Five = bombSliced;
				else if (fruitFive instanceof fatalBomb)
					Five = fatalBombSliced;
				else if (fruitFive instanceof Pomegranate)
					Five = pomeSliced;
				else if (fruitFive instanceof Pineapple)
					Five = pineSliced;
				else if (fruitFive instanceof Guava)
					Five = guavaSliced;
			}

			if (flagSix == 1) {
				if (fruitSix instanceof Banana)
					Six = banana;
				else if (fruitSix instanceof Melon)
					Six = melon;
				else if (fruitSix instanceof Peach)
					Six = peach;
				else if (fruitSix instanceof Lemon)
					Six = lemon;
				else if (fruitSix instanceof Orange)
					Six = orange;
				else if (fruitSix instanceof basicBomb)
					Six = bomb;
				else if (fruitSix instanceof fatalBomb)
					Six = fatalBomb;
				else if (fruitSix instanceof Pomegranate)
					Six = pome;
				else if (fruitSix instanceof Pineapple)
					Six = pine;
				else if (fruitSix instanceof Guava)
					Six = guava;
			}
			
			else if (flagSix == 2) {
				if (fruitSix instanceof Banana)
					Six = bananaSliced;
				else if (fruitSix instanceof Melon)
					Six = melonSliced;
				else if (fruitSix instanceof Peach)
					Six = peachSliced;
				else if (fruitSix instanceof Lemon)
					Six = lemonSliced;
				else if (fruitSix instanceof Orange)
					Six = orangeSliced;
				else if (fruitSix instanceof basicBomb)
					Six = bombSliced;
				else if (fruitSix instanceof fatalBomb)
					Six = fatalBombSliced;
				else if (fruitSix instanceof Pomegranate)
					Six = pomeSliced;
				else if (fruitSix instanceof Pineapple)
					Six = pineSliced;
				else if (fruitSix instanceof Guava)
					Six = guavaSliced;
			}
			
			flagZero = 0;
			flagOne = 0;
			flagTwo = 0;
			flagThree = 0;
			flagFour = 0;
			flagFive = 0;
			flagSix = 0;
			
			Zero.draw(fruitZero.getXlocation(), fruitZero.getYlocation(), fruitScale);
			One.draw(fruitOne.getXlocation(), fruitOne.getYlocation(), fruitScale);
			Two.draw(fruitTwo.getXlocation(), fruitTwo.getYlocation(), fruitScale);
			Three.draw(fruitThree.getXlocation(), fruitThree.getYlocation(), fruitScale);
			Four.draw(fruitFour.getXlocation(), fruitFour.getYlocation(), fruitScale);
			Five.draw(fruitFive.getXlocation(), fruitFive.getYlocation(), fruitScale);
			Six.draw(fruitSix.getXlocation(), fruitSix.getYlocation(), fruitScale);
			
			if(Engine.getLife() == 3) {
				lifeOne = melon;
				lifeTwo = melon;
				lifeThree = melon;
			}
			
			else if(Engine.getLife() == 2) {
				lifeOne = melonSliced;
				lifeTwo = melon;
				lifeThree = melon;
			}
			
			else if(Engine.getLife() == 1) {
				lifeOne = melonSliced;
				lifeTwo = melonSliced;
				lifeThree = melon;
			}
			
			else if(Engine.getLife() == 0) {
				lifeOne = melonSliced;
				lifeTwo = melonSliced;
				lifeThree = melonSliced;
			}
		}
		
		if(flagSpecial == 1) {
			special += 1;
			bg = backgroundDarkened;
			
			if (special < 2500) {
				
				if(level.getDifficulty() == levelDifficulty.BANANA) {
					fruitZero.setSpeedFactor(0.01);
					fruitOne.setSpeedFactor(0.01);
					fruitTwo.setSpeedFactor(0.01);
				}
				
				else if (level.getDifficulty() == levelDifficulty.PEACH) {
					fruitZero.setSpeedFactor(0.01);
					fruitOne.setSpeedFactor(0.01);
					fruitTwo.setSpeedFactor(0.01);
					fruitThree.setSpeedFactor(0.01);
					fruitFour.setSpeedFactor(0.01);
				}
				
				else if (level.getDifficulty() == levelDifficulty.MELON) {
					fruitZero.setSpeedFactor(0.01);
					fruitOne.setSpeedFactor(0.01);
					fruitTwo.setSpeedFactor(0.01);
					fruitThree.setSpeedFactor(0.01);
					fruitFour.setSpeedFactor(0.01);
					fruitFive.setSpeedFactor(0.01);
					fruitSix.setSpeedFactor(0.01);
				}
			}
			
			else {
				if(level.getDifficulty() == levelDifficulty.BANANA) {
					fruitZero.setSpeedFactor(level.getAccFactor());
					fruitOne.setSpeedFactor(level.getAccFactor());
					fruitTwo.setSpeedFactor(level.getAccFactor());
				}
				
				else if (level.getDifficulty() == levelDifficulty.PEACH) {
					fruitZero.setSpeedFactor(level.getAccFactor());
					fruitOne.setSpeedFactor(level.getAccFactor());
					fruitTwo.setSpeedFactor(level.getAccFactor());
					fruitThree.setSpeedFactor(level.getAccFactor());
					fruitFour.setSpeedFactor(level.getAccFactor());
				}
				
				else if (level.getDifficulty() == levelDifficulty.MELON) {
					fruitZero.setSpeedFactor(level.getAccFactor());
					fruitOne.setSpeedFactor(level.getAccFactor());
					fruitTwo.setSpeedFactor(level.getAccFactor());
					fruitThree.setSpeedFactor(level.getAccFactor());
					fruitFour.setSpeedFactor(level.getAccFactor());
					fruitFive.setSpeedFactor(level.getAccFactor());
					fruitSix.setSpeedFactor(level.getAccFactor());
				}
				special = 0;
				flagSpecial = 0;
				bg = background;
			}
		}
		
		else if(flagSpecial == 2) {
			points.draw();
			
			special += 1;
			bg = backgroundDarkened;
			
			if (special < 700) {
				
				if(level.getDifficulty() == levelDifficulty.BANANA) {
					fruitZero.setSpeedFactor(0.1);
					fruitOne.setSpeedFactor(0.1);
					fruitTwo.setSpeedFactor(0.1);
				}
				
				else if (level.getDifficulty() == levelDifficulty.PEACH) {
					fruitZero.setSpeedFactor(0.1);
					fruitOne.setSpeedFactor(0.1);
					fruitTwo.setSpeedFactor(0.1);
					fruitThree.setSpeedFactor(0.1);
					fruitFour.setSpeedFactor(0.1);
				}
				
				else if (level.getDifficulty() == levelDifficulty.MELON) {
					fruitZero.setSpeedFactor(0.1);
					fruitOne.setSpeedFactor(0.1);
					fruitTwo.setSpeedFactor(0.1);
					fruitThree.setSpeedFactor(0.1);
					fruitFour.setSpeedFactor(0.1);
					fruitFive.setSpeedFactor(0.1);
					fruitSix.setSpeedFactor(0.1);
				}
			}
			
			else {
				if(level.getDifficulty() == levelDifficulty.BANANA) {
					fruitZero.setSpeedFactor(level.getAccFactor());
					fruitOne.setSpeedFactor(level.getAccFactor());
					fruitTwo.setSpeedFactor(level.getAccFactor());
				}
				
				else if (level.getDifficulty() == levelDifficulty.PEACH) {
					fruitZero.setSpeedFactor(level.getAccFactor());
					fruitOne.setSpeedFactor(level.getAccFactor());
					fruitTwo.setSpeedFactor(level.getAccFactor());
					fruitThree.setSpeedFactor(level.getAccFactor());
					fruitFour.setSpeedFactor(level.getAccFactor());
				}
				
				else if (level.getDifficulty() == levelDifficulty.MELON) {
					fruitZero.setSpeedFactor(level.getAccFactor());
					fruitOne.setSpeedFactor(level.getAccFactor());
					fruitTwo.setSpeedFactor(level.getAccFactor());
					fruitThree.setSpeedFactor(level.getAccFactor());
					fruitFour.setSpeedFactor(level.getAccFactor());
					fruitFive.setSpeedFactor(level.getAccFactor());
					fruitSix.setSpeedFactor(level.getAccFactor());
				}
				special = 0;
				flagSpecial = 0;
				bg = background;
			}
		}
		
		else if (flagSpecial == 3) {
			Life.draw();
			
			special += 1;
			bg = backgroundDarkened;
			
			if (special < 700) {
				
				if(level.getDifficulty() == levelDifficulty.BANANA) {
					fruitZero.setSpeedFactor(0.1);
					fruitOne.setSpeedFactor(0.1);
					fruitTwo.setSpeedFactor(0.1);
				}
				
				else if (level.getDifficulty() == levelDifficulty.PEACH) {
					fruitZero.setSpeedFactor(0.1);
					fruitOne.setSpeedFactor(0.1);
					fruitTwo.setSpeedFactor(0.1);
					fruitThree.setSpeedFactor(0.1);
					fruitFour.setSpeedFactor(0.1);
				}
				
				else if (level.getDifficulty() == levelDifficulty.MELON) {
					fruitZero.setSpeedFactor(0.1);
					fruitOne.setSpeedFactor(0.1);
					fruitTwo.setSpeedFactor(0.1);
					fruitThree.setSpeedFactor(0.1);
					fruitFour.setSpeedFactor(0.1);
					fruitFive.setSpeedFactor(0.1);
					fruitSix.setSpeedFactor(0.1);
				}
			}
			
			else {
				if(level.getDifficulty() == levelDifficulty.BANANA) {
					fruitZero.setSpeedFactor(level.getAccFactor());
					fruitOne.setSpeedFactor(level.getAccFactor());
					fruitTwo.setSpeedFactor(level.getAccFactor());
				}
				
				else if (level.getDifficulty() == levelDifficulty.PEACH) {
					fruitZero.setSpeedFactor(level.getAccFactor());
					fruitOne.setSpeedFactor(level.getAccFactor());
					fruitTwo.setSpeedFactor(level.getAccFactor());
					fruitThree.setSpeedFactor(level.getAccFactor());
					fruitFour.setSpeedFactor(level.getAccFactor());
				}
				
				else if (level.getDifficulty() == levelDifficulty.MELON) {
					fruitZero.setSpeedFactor(level.getAccFactor());
					fruitOne.setSpeedFactor(level.getAccFactor());
					fruitTwo.setSpeedFactor(level.getAccFactor());
					fruitThree.setSpeedFactor(level.getAccFactor());
					fruitFour.setSpeedFactor(level.getAccFactor());
					fruitFive.setSpeedFactor(level.getAccFactor());
					fruitSix.setSpeedFactor(level.getAccFactor());
				}
				special = 0;
				flagSpecial = 0;
				bg = background;
			}
		}
		
				
		if(Engine.isGameOver() == true) {
			if(Levels.flag == 4)
				TimeUp.draw();
			else {
				if(Engine.isByFatal())
					Nuclear.draw(0, 0, 0.67f);
				YouLost.draw(0, 0, 1f);
			}	
		}
		if (Levels.flag != 4) {
			lifeOne.draw(50, 40, 0.1f);
			lifeTwo.draw(140, 40, 0.1f);
			lifeThree.draw(230, 40, 0.1f);
		}
				
		Kunai.draw(xPos, yPos, 0.5f);
		
		g.drawString(time, 550, 10);
		g.drawString(score, 1100, 10);
		g.drawString(highScore, 1100, 30);
		g.setColor(Color.white);
	}

	//---------------------------------------------------------Update-----------------------------------------------------------------------------//	
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		int xPos = Mouse.getX();
		int yPos = 720 - Mouse.getY();
		
		if (Levels.flag == 4)
			time  = "Remaining : " + Engine.getTime() + " seconds";
		else
			time  = "Time: " + Engine.getTime() + " seconds";

		score = "Score: " + Engine.getScore() + " ";
		highScore = "HighScore: " + Engine.getHighscore() + " ";
		
		if(Engine.isGameOver() == true) {
			
			if(Mouse.isButtonDown(0)) {
				Engine.saveGame();
				if(Levels.flag == 4) {
					sbg.getState(Game.ArcadeMenu).init(gc, sbg);
					sbg.enterState(Game.ArcadeMenu, new FadeOutTransition(), new FadeInTransition());
				}
				else {
					sbg.getState(Game.Levels).init(gc, sbg);
					sbg.enterState(Game.Levels, new FadeOutTransition(), new FadeInTransition());
				}
			}
		}
		
		else {
			
			if (level.getDifficulty() == Level.levelDifficulty.BANANA) {
				
				fruitZero.move();
				fruitOne.move();
				fruitTwo.move();
				
				/*  
				 * 
				 * OFF Screen Actions
				 * 
				 */
				
				if(fruitZero.hasMovedOffScreen()) {
					if(!fruitZero.isSliced() && !(fruitZero instanceof basicBomb) && !(fruitZero instanceof fatalBomb)) {
						Engine.setLife(Engine.getLife() - 1);
					}
					Engine.createFruitList(0);
					fruitZero = Engine.getFruits().get(0);
					flagZero = 1;
				}
				
				if(fruitOne.hasMovedOffScreen()) {
					if(!fruitOne.isSliced() && !(fruitOne instanceof basicBomb) && !(fruitOne instanceof fatalBomb)) {
						Engine.setLife(Engine.getLife() - 1);
					}
					Engine.createFruitList(1);
					fruitOne = Engine.getFruits().get(1);
					flagOne = 1;
				}
				
				if(fruitTwo.hasMovedOffScreen()) {
					if(!fruitTwo.isSliced() && !(fruitTwo instanceof basicBomb) && !(fruitTwo instanceof fatalBomb)) {
						Engine.setLife(Engine.getLife() - 1);
					}
					Engine.createFruitList(2);
					fruitTwo = Engine.getFruits().get(2);
					flagTwo = 1;
				}
				
				/*  
				 * 
				 * Slicing Objects
				 * 
				 */

				if(xPos > fruitZero.getXlocation() && xPos < fruitZero.getXlocation() + 100 && yPos > fruitZero.getYlocation() && yPos < fruitZero.getYlocation() + 100) {
					if(fruitZero instanceof Pomegranate && !(fruitZero.isSliced()))
						flagSpecial = 1;
					if(fruitZero instanceof Pineapple && !(fruitZero.isSliced()))
						flagSpecial = 2;
					if(fruitZero instanceof Guava && !(fruitZero.isSliced()))
						flagSpecial = 3;
					Engine.sliceObjects(fruitZero);
					flagZero = 2;
				}
				
				if(xPos > fruitOne.getXlocation() && xPos < fruitOne.getXlocation() + 100 && yPos > fruitOne.getYlocation() && yPos < fruitOne.getYlocation() + 100) {
					if(fruitOne instanceof Pomegranate && !(fruitOne.isSliced()))
						flagSpecial = 1;
					if(fruitOne instanceof Pineapple && !(fruitOne.isSliced()))
						flagSpecial = 2;
					if(fruitOne instanceof Guava && !(fruitOne.isSliced()))
						flagSpecial = 3;
					Engine.sliceObjects(fruitOne);
					flagOne = 2;
				}
				
				if(xPos > fruitTwo.getXlocation() && xPos < fruitTwo.getXlocation() + 100 && yPos > fruitTwo.getYlocation() && yPos < fruitTwo.getYlocation() + 100) {
					if(fruitTwo instanceof Pomegranate && !(fruitTwo.isSliced()))
						flagSpecial = 1;
					if(fruitTwo instanceof Pineapple && !(fruitTwo.isSliced()))
						flagSpecial = 2;
					if(fruitTwo instanceof Guava && !(fruitTwo.isSliced()))
						flagSpecial = 3;
					Engine.sliceObjects(fruitTwo);
					flagTwo = 2;
				}
			}
			
			else if (level.getDifficulty() == Level.levelDifficulty.PEACH) {
				
				fruitZero.move();
				fruitOne.move();
				fruitTwo.move();
				fruitThree.move();
				fruitFour.move();
				
				/*  
				 * 
				 * OFF Screen Actions
				 * 
				 */
				
				if(fruitZero.hasMovedOffScreen()) {
					if(!fruitZero.isSliced() && !(fruitZero instanceof basicBomb) && !(fruitZero instanceof fatalBomb))
						Engine.setLife(Engine.getLife() - 1);
					Engine.createFruitList(0);
					fruitZero = Engine.getFruits().get(0);
					flagZero = 1;
				}
				
				if(fruitOne.hasMovedOffScreen()) {
					if(!fruitOne.isSliced() && !(fruitOne instanceof basicBomb) && !(fruitOne instanceof fatalBomb))
						Engine.setLife(Engine.getLife() - 1);
					Engine.createFruitList(1);
					fruitOne = Engine.getFruits().get(1);
					flagOne = 1;
				}
				
				if(fruitTwo.hasMovedOffScreen()) {
					if(!fruitTwo.isSliced() && !(fruitTwo instanceof basicBomb) && !(fruitTwo instanceof fatalBomb))
						Engine.setLife(Engine.getLife() - 1);
					Engine.createFruitList(2);
					fruitTwo = Engine.getFruits().get(2);
					flagTwo = 1;
				}
				
				if(fruitThree.hasMovedOffScreen()) {
					if(!fruitThree.isSliced()  && !(fruitThree instanceof basicBomb) && !(fruitThree instanceof fatalBomb))
						Engine.setLife(Engine.getLife() - 1);
					Engine.createFruitList(3);
					fruitThree = Engine.getFruits().get(3);
					flagThree = 1;
				}
				
				if(fruitFour.hasMovedOffScreen()) {
					if(!fruitFour.isSliced() && !(fruitFour instanceof basicBomb) && !(fruitFour instanceof fatalBomb))
						Engine.setLife(Engine.getLife() - 1);
					Engine.createFruitList(4);
					fruitFour = Engine.getFruits().get(4);
					flagFour = 1;
				}	
				
				/*  
				 * 
				 * Slicing Objects
				 * 
				 */
				
				if(xPos > fruitZero.getXlocation() && xPos < fruitZero.getXlocation() + 100 && yPos > fruitZero.getYlocation() && yPos < fruitZero.getYlocation() + 100) {
					if(fruitZero instanceof Pomegranate && !(fruitZero.isSliced()))
						flagSpecial = 1;
					if(fruitZero instanceof Pineapple && !(fruitZero.isSliced()))
						flagSpecial = 2;
					if(fruitZero instanceof Guava && !(fruitZero.isSliced()))
						flagSpecial = 3;
					Engine.sliceObjects(fruitZero);
					flagZero = 2;
				}
				
				if(xPos > fruitOne.getXlocation() && xPos < fruitOne.getXlocation() + 100 && yPos > fruitOne.getYlocation() && yPos < fruitOne.getYlocation() + 100) {
					if(fruitOne instanceof Pomegranate && !(fruitOne.isSliced()))
						flagSpecial = 1;
					if(fruitOne instanceof Pineapple && !(fruitOne.isSliced()))
						flagSpecial = 2;
					if(fruitOne instanceof Guava && !(fruitOne.isSliced()))
						flagSpecial = 3;
					Engine.sliceObjects(fruitOne);
					flagOne = 2;
				}
				
				if(xPos > fruitTwo.getXlocation() && xPos < fruitTwo.getXlocation() + 100 && yPos > fruitTwo.getYlocation() && yPos < fruitTwo.getYlocation() + 100) {
					if(fruitTwo instanceof Pomegranate && !(fruitTwo.isSliced()))
						flagSpecial = 1;
					if(fruitTwo instanceof Pineapple && !(fruitTwo.isSliced()))
						flagSpecial = 2;
					if(fruitTwo instanceof Guava && !(fruitTwo.isSliced()))
						flagSpecial = 3;
					Engine.sliceObjects(fruitTwo);
					flagTwo = 2;
				}
				
				if(xPos > fruitThree.getXlocation() && xPos < fruitThree.getXlocation() + 100 && yPos > fruitThree.getYlocation() && yPos < fruitThree.getYlocation() + 100) {
					if(fruitThree instanceof Pomegranate && !(fruitThree.isSliced()))
						flagSpecial = 1;
					if(fruitThree instanceof Pineapple && !(fruitThree.isSliced()))
						flagSpecial = 2;
					if(fruitThree instanceof Guava && !(fruitThree.isSliced()))
						flagSpecial = 3;
					Engine.sliceObjects(fruitThree);
					flagThree = 2;
				}
				
				if(xPos > fruitFour.getXlocation() && xPos < fruitFour.getXlocation() + 100 && yPos > fruitFour.getYlocation() && yPos < fruitFour.getYlocation() + 100) {
					if(fruitFour instanceof Pomegranate && !(fruitFour.isSliced()))
						flagSpecial = 1;
					if(fruitFour instanceof Pineapple && !(fruitFour.isSliced()))
						flagSpecial = 2;
					if(fruitFour instanceof Guava && !(fruitFour.isSliced()))
						flagSpecial = 3;
					Engine.sliceObjects(fruitFour);
					flagFour = 2;
				}
			}
			
			else if (level.getDifficulty() == Level.levelDifficulty.MELON) {
				
				fruitZero.move();
				fruitOne.move();
				fruitTwo.move();
				fruitThree.move();
				fruitFour.move();
				fruitFive.move();
				fruitSix.move();
				
				/*  
				 * 
				 * OFF Screen Actions
				 * 
				 */
				
				if(fruitZero.hasMovedOffScreen()) {
					if(!fruitZero.isSliced() && !(fruitZero instanceof basicBomb) && !(fruitZero instanceof fatalBomb))
						Engine.setLife(Engine.getLife() - 1);
					Engine.createFruitList(0);
					fruitZero = Engine.getFruits().get(0);
					flagZero = 1;
				}
				
				if(fruitOne.hasMovedOffScreen()) {
					if(!fruitOne.isSliced() && !(fruitOne instanceof basicBomb) && !(fruitOne instanceof fatalBomb))
						Engine.setLife(Engine.getLife() - 1);
					Engine.createFruitList(1);
					fruitOne = Engine.getFruits().get(1);
					flagOne = 1;
				}
				
				if(fruitTwo.hasMovedOffScreen()) {
					if(!fruitTwo.isSliced() && !(fruitTwo instanceof basicBomb) && !(fruitTwo instanceof fatalBomb))
						Engine.setLife(Engine.getLife() - 1);
					Engine.createFruitList(2);
					fruitTwo = Engine.getFruits().get(2);
					flagTwo = 1;
				}
				
				if(fruitThree.hasMovedOffScreen()) {
					if(!fruitThree.isSliced()  && !(fruitThree instanceof basicBomb) && !(fruitThree instanceof fatalBomb))
						Engine.setLife(Engine.getLife() - 1);
					Engine.createFruitList(3);
					fruitThree = Engine.getFruits().get(3);
					flagThree = 1;
				}
				
				if(fruitFour.hasMovedOffScreen()) {
					if(!fruitFour.isSliced() && !(fruitFour instanceof basicBomb) && !(fruitFour instanceof fatalBomb))
						Engine.setLife(Engine.getLife() - 1);
					Engine.createFruitList(4);
					fruitFour = Engine.getFruits().get(4);
					flagFour = 1;
				}	
				
				if(fruitFive.hasMovedOffScreen()) {
					if(!fruitFive.isSliced() && !(fruitFive instanceof basicBomb) && !(fruitFive instanceof fatalBomb))
						Engine.setLife(Engine.getLife() - 1);
					Engine.createFruitList(5);
					fruitFive = Engine.getFruits().get(5);
					flagFive = 1;
				}
				
				if(fruitSix.hasMovedOffScreen()) {
					if(!fruitSix.isSliced() && !(fruitSix instanceof basicBomb) && !(fruitSix instanceof fatalBomb))
						Engine.setLife(Engine.getLife() - 1);
					Engine.createFruitList(6);
					fruitSix = Engine.getFruits().get(6);
					flagSix = 1;
				}

				/*  
				 * 
				 * Slicing Objects
				 * 
				 */
				
				if(xPos > fruitZero.getXlocation() && xPos < fruitZero.getXlocation() + 100 && yPos > fruitZero.getYlocation() && yPos < fruitZero.getYlocation() + 100) {
					if(fruitZero instanceof Pomegranate && !(fruitZero.isSliced()))
						flagSpecial = 1;
					if(fruitZero instanceof Pineapple && !(fruitZero.isSliced()))
						flagSpecial = 2;
					if(fruitZero instanceof Guava && !(fruitZero.isSliced()))
						flagSpecial = 3;
					Engine.sliceObjects(fruitZero);
					flagZero = 2;
				}
				
				if(xPos > fruitOne.getXlocation() && xPos < fruitOne.getXlocation() + 100 && yPos > fruitOne.getYlocation() && yPos < fruitOne.getYlocation() + 100) {
					if(fruitOne instanceof Pomegranate && !(fruitOne.isSliced()))
						flagSpecial = 1;
					if(fruitOne instanceof Pineapple && !(fruitOne.isSliced()))
						flagSpecial = 2;
					if(fruitOne instanceof Guava && !(fruitOne.isSliced()))
						flagSpecial = 3;
					Engine.sliceObjects(fruitOne);
					flagOne = 2;
				}
				
				if(xPos > fruitTwo.getXlocation() && xPos < fruitTwo.getXlocation() + 100 && yPos > fruitTwo.getYlocation() && yPos < fruitTwo.getYlocation() + 100) {
					if(fruitTwo instanceof Pomegranate && !(fruitTwo.isSliced()))
						flagSpecial = 1;
					if(fruitTwo instanceof Pineapple && !(fruitTwo.isSliced()))
						flagSpecial = 2;
					if(fruitTwo instanceof Guava && !(fruitTwo.isSliced()))
						flagSpecial = 3;
					Engine.sliceObjects(fruitTwo);
					flagTwo = 2;
				}
				
				if(xPos > fruitThree.getXlocation() && xPos < fruitThree.getXlocation() + 100 && yPos > fruitThree.getYlocation() && yPos < fruitThree.getYlocation() + 100) {
					if(fruitThree instanceof Pomegranate && !(fruitThree.isSliced()))
						flagSpecial = 1;
					if(fruitThree instanceof Pineapple && !(fruitThree.isSliced()))
						flagSpecial = 2;
					if(fruitThree instanceof Guava && !(fruitThree.isSliced()))
						flagSpecial = 3;
					Engine.sliceObjects(fruitThree);
					flagThree = 2;
				}
				
				if(xPos > fruitFour.getXlocation() && xPos < fruitFour.getXlocation() + 100 && yPos > fruitFour.getYlocation() && yPos < fruitFour.getYlocation() + 100) {
					if(fruitFour instanceof Pomegranate && !(fruitFour.isSliced()))
						flagSpecial = 1;
					if(fruitFour instanceof Pineapple && !(fruitFour.isSliced()))
						flagSpecial = 2;
					if(fruitFour instanceof Guava && !(fruitFour.isSliced()))
						flagSpecial = 3;
					Engine.sliceObjects(fruitFour);
					flagFour = 2;
				}
				
				if(xPos > fruitFive.getXlocation() && xPos < fruitFive.getXlocation() + 100 && yPos > fruitFive.getYlocation() && yPos < fruitThree.getYlocation() + 100) {
					if(fruitFive instanceof Pomegranate && !(fruitFive.isSliced()))
						flagSpecial = 1;
					if(fruitFive instanceof Pineapple && !(fruitFive.isSliced()))
						flagSpecial = 2;
					if(fruitFive instanceof Guava && !(fruitFive.isSliced()))
						flagSpecial = 3;
					Engine.sliceObjects(fruitFive);
					flagFive = 2;
				}
				
				if(xPos > fruitSix.getXlocation() && xPos < fruitSix.getXlocation() +100 && yPos > fruitSix.getYlocation() && yPos < fruitFour.getYlocation() + 100) {
					if(fruitSix instanceof Pomegranate && !(fruitSix.isSliced()))
						flagSpecial = 1;
					if(fruitSix instanceof Pineapple && !(fruitSix.isSliced()))
						flagSpecial = 2;
					if(fruitSix instanceof Guava && !(fruitSix.isSliced()))
						flagSpecial = 3;
					Engine.sliceObjects(fruitSix);
					flagSix = 2;
				}
			}
		}
	}

	//---------------------------------------------------------GETID-----------------------------------------------------------------------------//
	
	@Override
	public int getID() {
		return 2;
	}
}