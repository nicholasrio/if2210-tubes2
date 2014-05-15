package model;

public class Player {

    private final String name;
    private int HighScore;

    public Player(String name, int score) {
        this.name = name;
        HighScore = score;
    }

    public void setHighScore(int newScore) {
        if (newScore > HighScore) {
            HighScore = newScore;
        }
    }

    public int getHighScore() {
        return HighScore;
    }

    public String getName() {
        return name;
    }

}
