package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-21
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
public abstract class StackHolder{

    List<GraphicStackListener> listeners = new ArrayList<GraphicStackListener>();

    CardStack stack = new CardStack();

    public abstract boolean addStackWithRules(CardStack newStack);

    public abstract CardStack getStack(int amount);

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public Iterator iterator(){
        return stack.iterator();
    }

    public void notifyListeners(){
        for (GraphicStackListener stackListener : listeners) {
            stackListener.graphicChanged();
        }
    }

    public void addListener(GraphicStackListener listener){
        listeners.add(listener);
    }
}
