package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-20
 * Time: 18:05
 * To change this template use File | Settings | File Templates.
 */
public class CardStack {

    //Public tills vidare.
    //ArrayList -> List vid compile error?
    public List<GameCard> list = new ArrayList<GameCard>();

    public boolean isStraight(int amount){
        if(amount == 1) return true;
        int index = list.size() - 1;
        GameCard prev = list.get(index--);
        for (int i = 1; i < amount; i++) {
            GameCard curr = list.get(index--);
            //använd equals istället för !=  ?
            if(curr.color.getSuperColor() == prev.color.getSuperColor() ||
               curr.number.ordinal() != prev.number.ordinal() + 1){
                return false;
            }
            prev = curr;
        }
        return true;
    }

    public CardStack getStack(int amount){
        CardStack result = new CardStack();
        result.list = list.subList(size() - amount, size());
        return result;
    }

    public static void removeStack(CardStack subStack){
        subStack.list.clear();
    }

    public void clear(){
        list.clear();
    }

    public int size(){
        return list.size();
    }

    public void addStack(CardStack otherStack){
        list.addAll(otherStack.list);
    }

    public static CardStack createCardDeck(){
        ArrayList<GameCard> list = new ArrayList<GameCard>();

        for (CardColor color : CardColor.values()) {
            for (CardNumber number : CardNumber.values()) {
                list.add(new GameCard(number, color));
            }
        }
        CardStack result = new CardStack();
        result.list = list;
        return result;
    }
    public static CardStack createShuffledDeck(){
        CardStack result = createCardDeck();
        Collections.shuffle(result.list);
        return result;
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }


    public GameCard peekLast() {
        if(list.size() == 0) return null;
        return list.get(list.size()-1);
    }

    public GameCard peekFirst() {
        if(list.size() == 0) return null;
        return list.get(0);
    }

    public Iterator iterator(){
        return list.iterator();
    }
}
