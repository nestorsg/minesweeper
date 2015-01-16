package ui;

import model.Game;
import model.GameObserver;

public class GameDisplay implements GameObserver {
    
    private final Game game;

    public GameDisplay(Game game) {
        this.game = game;
        this.game.add(this);
    }

    @Override
    public void notifyTimeChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
