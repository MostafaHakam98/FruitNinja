package Levels;

public abstract class Level {
	
	public enum levelDifficulty {
		BANANA,
		PEACH,
		MELON,
		ARCADE
	}
	
	private int maxNumOfFuits;
	private double accFactor;
	private int life, score;
	private levelDifficulty difficulty;

	public int getMaxNumOfFuits() {
		return maxNumOfFuits;
	}

	public void setMaxNumOfFuits(int maxNumOfFuits) {
		this.maxNumOfFuits = maxNumOfFuits;
	}

	public double getAccFactor() {
		return accFactor;
	}

	public void setAccFactor(double accFactor) {
		this.accFactor = accFactor;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public levelDifficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(levelDifficulty difficulty) {
		this.difficulty = difficulty;
	}
}
