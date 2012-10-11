package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-26
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
public class FreeCell {
    FreeHolder[] freeHolders;
    FinalHolder[] finalHolders;
    GameHolder[] gameHolders;

    CardStack gameDeck;

    //själva spelet

    public FreeCell() {
        freeHolders = new FreeHolder[4];
        finalHolders = new FinalHolder[4];
        gameHolders = new GameHolder[8];
        for (int i = 0; i < freeHolders.length; i++) freeHolders[i] = new FreeHolder();
        for (int i = 0; i < finalHolders.length; i++) finalHolders[i] = new FinalHolder();
        for (int i = 0; i < gameHolders.length; i++) gameHolders[i] = new GameHolder();
        gameDeck = CardStack.createShuffledDeck();
        placeCards();
    }

    private void placeCards(){
        int counter = 0;
        CardStack temp;
        GameCard curr;
        Iterator<GameCard> iter = gameDeck.iterator();
        while(iter.hasNext()){
            temp = new CardStack();
            curr = iter.next();
            temp.list.add(curr);
            System.out.print(curr.toBeautifulString() + "\t");
            gameHolders[counter].addStackNoRules(temp);
            if(counter >= 7){
                System.out.println();
            }
            counter = (counter + 1) % 8;
        }
    }

    public boolean move(int amount, StackHolder origin, StackHolder target){
        //REGLER!!!
        //Kontroll på hur många kort som ska läggas in! lediga rutor mm

        CardStack movingStack = origin.getStack(amount);
        if(movingStack == null) return false;

        if(origin instanceof GameHolder && target instanceof GameHolder){
            int length = movingStack.list.size();
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
            CardStack.removeStack(movingStack);
            //movingStack.clear();
            origin.notifyListeners();
            target.notifyListeners();
            return true;
        }else{
            return false;
        }
    }

    public int freeCells(){
        int result = 0;
        for (int i = 0; i < freeHolders.length; i++) {
            if(freeHolders[i].isEmpty()) result++;
        }
        return result;
    }

    public int freeColumns(){
        int result = 0;
        for (int i = 0; i < gameHolders.length; i++) {
            if(gameHolders[i].isEmpty()) result++;
        }
        return result;
    }
}
