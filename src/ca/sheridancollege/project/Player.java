/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author dancye, 2018
 */
public abstract class Player 
{
    private String playerID; //the unique ID for this player
    private GroupOfCards hand;
    private int score;
    
    /**
     * A constructor that allows you to set the player's unique ID
     * @param name the unique ID to assign to this player.
     */
    public Player(String name)
    {
        playerID= name;
        this.hand = new GroupOfCards(5);
    }
    
    /**
     * @return the playerID
     */
    public String getPlayerID() 
    {
        return playerID;
    }

    /**
     * Ensure that the playerID is unique
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) 
    {
        playerID = givenID;
    }
    
    /**
     * The method to be instantiated when you subclass the Player class
     * with your specific type of Player and filled in with logic to play your game.
     */
    public abstract void play();
    

    public abstract void hit();

    public abstract void stand();

    public ArrayList<Card> showHand() {
        return hand.showCards();
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int checkHand() {
        int value = 0;
        for (Card card : hand.showCards()) {
            value += card.getValue();
        }
        return value;
    }

    public GroupOfCards getHand() {
        return hand;
    }
    
}
