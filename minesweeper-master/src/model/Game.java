package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    
    private final Board board;
    private final Level level;
    private final List<GameObserver> observers;
    private int seconds;
    
    public Game(Board board, Level level) {
        this.board = board;
        this.level = level;
        this.observers = new ArrayList<>();
        this.seconds = 0;
        createTimer();
    }

    public void add(GameObserver observer) {
        observers.add(observer);
    }

    public boolean remove(GameObserver observer) {
        return observers.remove(observer);
    }

    private void createTimer() {
        Timer timer = new Timer();
        timer.schedule(everySecond(), 0, 1000);
    }

    private TimerTask everySecond() {
        return new TimerTask() {

            @Override
            public void run() {
                incrementSeconds();
            }

        };
    }
    
    private void incrementSeconds() {
        seconds++;
        for (GameObserver gameObserver : observers) 
            gameObserver.notifyTimeChanged();
    }

    public enum Level {
        Easy, Medium, Hard, Professional
    }
    

}
