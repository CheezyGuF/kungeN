package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-21
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
public abstract class StackHolder extends CardStack{

    Collection<GraphicStackListener> listeners = new ArrayList<GraphicStackListener>();

    public abstract CardStack getStackWithRules(int amount);

    public abstract boolean addStackWithRules(CardStack newStack);

    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public int cardAmount(GameCard card){
        return size() - stack.indexOf(card);
    }
    public void clear(){
        stack.clear();
        notifyListeners();
    }
    public void notifyListeners(){
        for (GraphicStackListener stackListener : listeners) stackListener.graphicChanged();
    }
    public void addListener(GraphicStackListener listener){
        listeners.add(listener);
    }

    //Tillfällig
    public String toString(){
        StringBuilder result = new StringBuilder();
        if(this instanceof GameHolder) result.append("a GameHolder ");
        else if(this instanceof FreeHolder) result.append("a FreeHolder ");
        else result.append("a FinalHolder ");
        return result.toString();
    }
}
