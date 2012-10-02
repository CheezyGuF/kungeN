package se.liu.ida.crito803_gusbr058.tddc69.kungen;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-21
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
public interface StackHolder {

    CardStack stack = new CardStack();

    public boolean addStack(CardStack newStack);

    public CardStack getStack(int amount);

    public boolean isEmpty();
}
