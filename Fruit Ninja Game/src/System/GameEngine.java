package System;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Factory.FruitCreator;
import GUI.Levels;
import Interfaces.GameObject;
import Levels.Level;
import Levels.Level.levelDifficulty;

public class GameEngine {
		
	private Random random = new Random();
	private Level level;
	private int life = 3;
	private int score = 0;
	private int highscore;
	private List<String> fruitType = new ArrayList<String>();
	private List<GameObject> fruits = new ArrayList<GameObject>();
	private long startTime, endTime;
	private boolean byFatal = false;
	private double specialFactor = 1;
	private FileLoader loader;
	
	public GameEngine() {
		setFruitType();
		loader = FileLoader.getFileLoader();
		startTime = System.nanoTime();
	}
	
	public GameEngine(Level level) {
		this.level = level;
		setFruitType();
		loader = FileLoader.getFileLoader();
		startTime = System.nanoTime();
	}
	
	public String getTime() {
		String time = new String();
		if (!isGameOver())
			endTime = System.nanoTime();
		
		long duration;
		
		if (Levels.flag == 4) {
			duration = 63 - (endTime - startTime) /1000000000;
			if(duration == 0)
				life =0;
		}
		else
			duration = (endTime - startTime) /1000000000 - 3;
		
		if(duration % 60 < 10 && duration / 60 < 10)
			time = "0" + (int) duration/60 + ":0" + (int) duration%60;
		else if(duration % 60 >= 10 && duration / 60 < 10)
			time = "0" + (int) duration/60 + ":" + (int) duration%60;
		else if(duration % 60 < 10 && duration / 60 >= 10)
			time = "0" + (int) duration/60 + ":0" + (int) duration%60;
		else
			time = (int) duration/60 + ":" + (int) duration%60;

		
		return time;
	}
	
	public GameObject createGameObject() {
		FruitCreator creator = new FruitCreator();
		
	    int xPos = random.nextInt(1000) + 100;
	    int maxHeight = 720 - (random.nextInt(300) + 420);
		int index = random.nextInt(fruitType.size());
		double C = (random.nextInt(93) + 7) / 100;
		
	    String randomFruit = fruitType.get(index);
	    
		return creator.createFruit(randomFruit, xPos, maxHeight, C, specialFactor * level.getAccFactor());
	}
	
	
	public void createFruitList() {
		int size = level.getMaxNumOfFuits();
		while (size > 0) {
			fruits.add(createGameObject());
			size--;
		}
	}
	
	public void createFruitList(int i) {
		fruits.set(i, createGameObject());
	}
	
	
	public void sliceObjects(GameObject fruit) {
		if (fruit.isBomb() && !fruit.isSliced()) {
			if (Levels.flag != 4) {
				if (fruit.isFatal()) {
					life = 0;
					setByFatal(true);
				}
				else
					life--;
			}
			
			if(Levels.flag == 4) {
				if(score > 1000)
					score -= 1000;
				else
					score = 0;
			}
		}
		
		if (!fruit.isSliced()) {
			if(fruit.getFruitType() == Fruits.fruitObject.fruitType.PINAEAPPLE)
				score += 300;
			else if(fruit.getFruitType() == Fruits.fruitObject.fruitType.GUAVA) {
				if (life < 3)
					life++;
			}
			else
				score += 100;
		}
		
		if (score > highscore)
			highscore = score;
		
		fruit.slice();
	}
	
	
	public List<GameObject> getFruits(){
		return fruits;
	}
	
	
	public void setFruitType() {
		fruitType.add("B");
		fruitType.add("B");
		fruitType.add("B");
		fruitType.add("B");

		fruitType.add("L");
		fruitType.add("L");
		fruitType.add("L");
		fruitType.add("L");

		fruitType.add("M");
		fruitType.add("M");
		fruitType.add("M");
		fruitType.add("M");

		fruitType.add("O");
		fruitType.add("O");
		fruitType.add("O");
		fruitType.add("O");

		fruitType.add("P");
		fruitType.add("P");
		fruitType.add("P");
		fruitType.add("P");

		fruitType.add("BB");
		fruitType.add("BB");
		fruitType.add("BB");
		fruitType.add("BB");

		fruitType.add("PA");
		fruitType.add("PG");		
		
		if(Levels.flag != 4) {
			fruitType.add("G");
			fruitType.add("FB");
		}
		
		else if(level.getDifficulty() == levelDifficulty.PEACH)
			fruitType.add("FB");
		
		else if(level.getDifficulty() == levelDifficulty.MELON) {
			fruitType.add("FB");
			fruitType.add("FB");
		}
	}
	
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	
	public Level getLevel() {
		return level;
	}
	
	public boolean isGameOver() {
		if(life > 0)
			return false;
		return true;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	
	public int getLife() {
		return life;
	}
	
	public boolean isByFatal() {
		return byFatal;
	}
	
	public void setByFatal (boolean byFatal) {
		this.byFatal = byFatal;
	}
	
	public void setSpecialFactor(double specialFactor) {
		this.specialFactor = specialFactor;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getHighscore() {
		return highscore;
	}

	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}
	
	public void saveGame() {
		
		if(Levels.flag == 4)
			loader.highScoreArcade = highscore;
		
		else if(level.getDifficulty() == levelDifficulty.BANANA)
			loader.highScoreBanana = highscore;
		
		else if(level.getDifficulty() == levelDifficulty.PEACH)
			loader.highScorePeach = highscore;
		
		else if(level.getDifficulty() == levelDifficulty.MELON)
			loader.highScoreMelon = highscore;
		
		loader.saveGame();
	}
	
	public void loadGame() {
		loader.loadGame();
		
		if(Levels.flag == 4)
			highscore = loader.highScoreArcade;
		
		else if(level.getDifficulty() == levelDifficulty.BANANA)
			highscore = loader.highScoreBanana;
		
		else if(level.getDifficulty() == levelDifficulty.PEACH)
			highscore = loader.highScorePeach;
		
		else if(level.getDifficulty() == levelDifficulty.MELON)
			highscore = loader.highScoreMelon;
	}

	public void ResetGame() {	
	}
}
