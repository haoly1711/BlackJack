/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author dancye, 2018
 */
public abstract class Game 
{
    private final String gameName;//the title of the game
    private ArrayList <Player> players;// the players of the game
    private Player dealer;
    
    public Game(String givenName)
    {
        gameName = givenName;
        players = new ArrayList();
    }

    /**
     * @return the gameName
     */
    public String getGameName() 
    {
        return gameName;
    }
    
     /**
     * @return the players of this game
     */
    public ArrayList <Player> getPlayers() 
    {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList <Player> players) 
    {
        this.players = players;
    }
    
     public Player getDealer() {
        return dealer;
    }
    /**
     * Play the game. This might be one method or many method calls depending
     * on your game.
     */
    public abstract void play();
    
    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public abstract void declareWinner();
    
    public void registerPlayer(Player player) {
        if (players.size() < 7) {
            players.add(player);
        }
    }
    
    public Player chooseDealer() {
        if (!players.isEmpty()) {
            dealer = players.get(0); // Simplified selection
            return dealer;
        }
        return null;
    }
    
     public void dealCards() {
        GroupOfCards deck = new GroupOfCards(52);
        // Assume deck is populated with cards
        deck.shuffle();
        for (Player player : players) {
            player.addCard(deck.getCard(0));
            player.addCard(deck.getCard(1));
        }
        if (dealer != null) {
            dealer.addCard(deck.getCard(2));
            dealer.addCard(deck.getCard(3));
        }
    }

    public int checkHand(Player player) {
        int value = 0;
        for (Card card : player.showHand()) {
            value += card.getValue();
        }
        return value;
    }

    public void updateScores() {
        for (Player player : players) {
            int score = checkHand(player);
            player.setScore(score);
        }
    }

    public void showGameOutcome() {
        for (Player player : players) {
            System.out.println(player.getPlayerID() + " has a score of " + player.getScore());
        }
    }
    

   
}//end class
