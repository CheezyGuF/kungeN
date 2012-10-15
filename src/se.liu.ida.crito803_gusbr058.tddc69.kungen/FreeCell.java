package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.Collection;
import java.util.LinkedList;

public class FreeCell {
    FreeHolder[] freeHolders;
    FinalHolder[] finalHolders;
    GameHolder[] gameHolders;

    CardStack gameDeck;

    Collection<GameCompletedListener> completedListeners;

    //själva spelet
    public FreeCell() {
        completedListeners = new LinkedList<GameCompletedListener>();
        freeHolders  = new FreeHolder[4];
        finalHolders = new FinalHolder[4];
        gameHolders  = new GameHolder[8];
        for (int i = 0; i < freeHolders.length; i++)  freeHolders[i]  = new FreeHolder();
        for (int i = 0; i < finalHolders.length; i++) finalHolders[i] = new FinalHolder();
        for (int i = 0; i < gameHolders.length; i++)  gameHolders[i]  = new GameHolder();
        gameDeck = CardStack.createCardDeck();
        newGame();
    }

    public CardStack getGameDeck(){
        return gameDeck;
    }
    public StackHolder findCard(GameCard card){
        for (StackHolder stackHolder : gameHolders)  if(stackHolder.contains(card)) return stackHolder;
        for (StackHolder stackHolder : finalHolders) if(stackHolder.contains(card)) return stackHolder;
        for (StackHolder stackHolder : freeHolders)  if(stackHolder.contains(card)) return stackHolder;
        return null;
    }
    public boolean move(int amount, StackHolder origin, StackHolder target){
        //REGLER!!!
        //Kontroll på hur många kort som ska läggas in! lediga rutor mm

        CardStack movingStack = origin.getStackWithRules(amount);
        if(movingStack == null) return false;

        if(origin instanceof GameHolder && target instanceof GameHolder){
            int length = movingStack.size();
            int freeCells = freeCells();
            int freeColumns = freeColumns();

            if(target.isEmpty()){
                freeColumns--;
            }

            //(fC + 1) * 2^Cols är funktionen för att räkna ut antalet tillåtna kort att flytta.
            //biggestStack är antalet kort som kan flyttas i en rörelse.
            int biggestStack = (freeCells + 1) * (int) Math.pow(2, freeColumns);

            if(length > biggestStack){
                return false;
            }
        }

        if(target.addStackWithRules(movingStack)){
            movingStack.clear();
            origin.notifyListeners();
            target.notifyListeners();
            if(target instanceof FinalHolder) checkIfCompleted();
            return true;
        }else{
            return false;
        }
    }
    public void checkIfCompleted(){
        if(!allEmpty()) return;
        notifyGameCompletedListeners();
    }
    public void newGame(){
        clearStacks();
        gameDeck.shuffle();
        placeCards();
    }
    public void restartGame(){
        clearStacks();
        placeCards();
    }
    public void addGameCompletedListener(GameCompletedListener listener){
        completedListeners.add(listener);
    }

    private boolean allEmpty(){
        for (StackHolder stackHolder : gameHolders) if(!stackHolder.isEmpty()) return false;
        for (StackHolder stackHolder : freeHolders) if(!stackHolder.isEmpty()) return false;
        return true;
    }
    private int freeCells(){
        int result = 0;
        for (int i = 0; i < freeHolders.length; i++) if(freeHolders[i].isEmpty()) result++;
        return result;
    }
    private int freeColumns(){
        int result = 0;
        for (int i = 0; i < gameHolders.length; i++) if(gameHolders[i].isEmpty()) result++;
        return result;
    }
    private void clearStacks(){
        for (StackHolder stackHolder : gameHolders)  stackHolder.clear();
        for (StackHolder stackHolder : freeHolders)  stackHolder.clear();
        for (StackHolder stackHolder : finalHolders) stackHolder.clear();
    }
    private void placeCards(){
        int counter = 0;
        for (GameCard card : gameDeck) {
            gameHolders[counter].addCard(card);
            counter = (counter + 1) % 8;
        }
        for (StackHolder stackHolder : gameHolders) stackHolder.notifyListeners();
    }
    private void notifyGameCompletedListeners() {
        for (GameCompletedListener listener : completedListeners) {
            listener.gameCompleted();
        }
    }
}
