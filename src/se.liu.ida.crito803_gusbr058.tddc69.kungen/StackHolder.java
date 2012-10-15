package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.ArrayList;
import java.util.Collection;

public abstract class StackHolder extends CardStack{

    Collection<StackListener> listeners = new ArrayList<StackListener>();

    public abstract CardStack getStackWithRules(int amount);

    public abstract boolean addStackWithRules(CardStack newStack);

    public int cardAmount(GameCard card){
        return size() - stack.indexOf(card);
    }
    @Override
    public void clear(){
        stack.clear();
        notifyListeners();
    }
    public void notifyListeners(){
        for (StackListener stackListener : listeners) stackListener.graphicChanged();
    }
    public void addListener(StackListener listener){
        listeners.add(listener);
    }

}
