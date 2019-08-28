package Command;

import System.GameEngine;;

public class LoadGame implements Command {
	
    private GameEngine Game;

    public LoadGame(GameEngine Game){
    	this.Game = Game;
    }

    @Override
    public void execute() {
        Game.loadGame();
    }
}
