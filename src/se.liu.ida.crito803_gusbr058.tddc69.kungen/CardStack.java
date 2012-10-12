package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-20
 * Time: 18:05
 * To change this template use File | Settings | File Templates.
 */
public class CardStack implements Iterable<GameCard> {

    protected List<GameCard> stack = new ArrayList<GameCard>();

    public CardStack getStack(int amount){
        CardStack result = new CardStack();
        result.stack = stack.subList(size() - amount, size());
        return result;
    }
    public GameCard peekLast() {
        if(isEmpty()) return null;
        return stack.get(size()-1);
    }
    public GameCard peekFirst() {
        if(isEmpty()) return null;
        return stack.get(0);
    }
    public Iterator<GameCard> iterator(){
        return stack.iterator();
    }

    public boolean isStraight(int amount){
        if(amount == 1) return true;
        int index = size() - 1;
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
    public boolean contains(GameCard card){
        return stack.contains(card);
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public int size(){
        return stack.size();
    }
    public static CardStack createCardDeck(){
        CardStack result = new CardStack();
        for (CardColor color : CardColor.values()) {
            for (CardNumber number : CardNumber.values()) {
                result.addCard(new GameCard(number, color));
            }
        }
        return result;
    }
    public void clear(){
        stack.clear();
    }
    public void addStack(CardStack otherStack){
        stack.addAll(otherStack.stack);
    }
    public void addCard(GameCard card){
        stack.add(card);
    }
    public void shuffle(){
        Collections.shuffle(stack);
    }
}
