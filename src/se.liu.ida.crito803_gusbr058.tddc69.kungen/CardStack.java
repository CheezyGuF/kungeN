package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-20
 * Time: 18:05
 * To change this template use File | Settings | File Templates.
 */
public class CardStack {

    private ArrayList<GameCard> list;
    private int limit;

    public CardStack(int limit) {
        this.limit = limit;
    }
    public CardStack(){
        this.limit = -1;
        //Inte har placeringsreglerna!
    }

    public boolean isStraight(int targetIndex){
        return true;
    }

    public boolean addCard(GameCard card){
        if(limit == -1 || list.size() < limit){
            list.add(card);
            return true;
        }
        return false;
    }

    public boolean removeCard(GameCard card) {
        return true;
    }

    public CardStack removeStack(){
        return null;
    }

    public int size(){
        return list.size();
    }

    //public CardStack

    public boolean addStack(CardStack stack){
        if(limit == -1 || list.size() + stack.size() <= limit){
          //  list.add(stack.);
            return true;
        }
        return false;
    }

}


//Regelmetoder för stegar!