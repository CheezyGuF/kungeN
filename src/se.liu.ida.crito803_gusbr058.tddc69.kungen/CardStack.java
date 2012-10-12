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
public class CardStack implements Iterable{

    protected List<GameCard> stack = new ArrayList<GameCard>();

    public boolean isStraight(int amount){
        if(amount == 1) return true;
        int index = stack.size() - 1;
        GameCard prev = stack.get(index--);
        for (int i = 1; i < amount; i++) {
            GameCard curr = stack.get(index--);
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
        result.stack = stack.subList(size() - amount, size());
        return result;
    }

    public void clear(){
        stack.clear();
    }

    public int size(){
        return stack.size();
    }

    public boolean contains(GameCard card){
        return stack.contains(card);
    }

    public void addStack(CardStack otherStack){
        stack.addAll(otherStack.stack);
    }

    public static CardStack createCardDeck(){
        ArrayList<GameCard> list = new ArrayList<GameCard>();

        for (CardColor color : CardColor.values()) {
            for (CardNumber number : CardNumber.values()) {
                list.add(new GameCard(number, color));
            }
        }
        CardStack result = new CardStack();
        result.stack = list;
        return result;
    }

    public void shuffle(){
        Collections.shuffle(stack);
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }


    public GameCard peekLast() {
        if(stack.size() == 0) return null;
        return stack.get(stack.size()-1);
    }

    public GameCard peekFirst() {
        if(stack.size() == 0) return null;
        return stack.get(0);
    }

    public Iterator<GameCard> iterator(){
        return stack.iterator();
    }
}
