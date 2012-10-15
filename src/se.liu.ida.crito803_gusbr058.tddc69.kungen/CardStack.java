package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.*;

public class CardStack implements Iterable<GameCard> {

    protected List<GameCard> stack = new LinkedList<GameCard>();

    public CardStack getStack(int amount){
        CardStack result = new CardStack();
        assert(amount >= 0);
        assert(size() >= 0);
        assert(amount <= size());
        
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
    public Iterator<GameCard> descendingIterator(){
        return ((LinkedList)stack).descendingIterator();
    }

    public boolean isStraight(int amount){
        if(amount > size()) return false;
        if(amount == 1) return true;
        
        Iterator<GameCard> iter = descendingIterator();
        GameCard curr = iter.next();
        GameCard prev;
        while(--amount > 0){
            prev = curr;
            curr = iter.next();
            if(curr.color.getSuperColor() == prev.color.getSuperColor() ||
               curr.number.ordinal() != prev.number.ordinal() + 1){
               return false;
            }
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
