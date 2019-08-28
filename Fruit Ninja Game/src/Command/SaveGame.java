package Command;

import System.GameEngine;

public class SaveGame implements Command {
	
    private GameEngine Game;

    public SaveGame(GameEngine Game){
        this.Game = Game;
    }

    @Override
    public void execute() {
        Game.saveGame();
    }
}