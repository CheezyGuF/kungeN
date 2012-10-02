package se.liu.ida.crito803_gusbr058.tddc69.kungen;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-26
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
public class FreeCell {
    FreeHolder[] freeHolders = new FreeHolder[4];
    FinalHolder[] finalHolders = new FinalHolder[4];
    GameHolder[] gameHolders = new GameHolder[8];

    CardStack gameDeck = CardStack.createShuffledDeck();

    //själva spelet

    public FreeCell() {
        placeCards();
    }

    private void placeCards(){
        int counter = 0;
        while(!gameDeck.isEmpty()){
            gameHolders[counter].addStack(gameDeck.getStack(1));
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

        if(target.addStack(movingStack)){
            CardStack.removeStack(movingStack);
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
