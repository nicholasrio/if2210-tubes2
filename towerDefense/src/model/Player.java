/**
 *
 * @author 
 * Darwin Prasetio (13512015)
 * Chrestella Stephanie (13512005)
 * Jan Wira Gotama Putra (13512015)
 * Eric (13512021)
 * Willy(13512070)
 * Melvin Fonda (13512085)
 */

package model;

public class Player {

    private final String name;
    private int HighScore;
    
    /** 
     * Default constructor 
     */
    public Player(String name, int score) {
        this.name = name;
        HighScore = score;
    }

    /** 
     * Set this player highscore 
     */
    public void setHighScore(int newScore) {
        if (newScore > HighScore) {
            HighScore = newScore;
        }
    }

    /** 
     * Get player's highscore 
     */
    public int getHighScore() {
        return HighScore;
    }

    /** 
     * Get player's name 
     */
    public String getName() {
        return name;
    }

}
