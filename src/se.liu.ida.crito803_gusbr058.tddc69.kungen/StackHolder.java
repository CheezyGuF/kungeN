package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-21
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
public abstract class StackHolder {

    CardStack stack = new CardStack();

    public abstract boolean addStack(CardStack newStack);

    public abstract CardStack getStack(int amount);

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public Iterator iterator(){
        return stack.iterator();
    }
}
