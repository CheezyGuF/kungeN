package se.liu.ida.crito803_gusbr058.tddc69.kungen;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-21
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
public class FreeHolder implements StackHolder {
/*
    private boolean stackable; Nej
    private boolean alternatingColor; Behövs inte
    private boolean increasingOrder; Behövs inte
    private boolean movable; Ja

    }*/

    @Override
    public boolean addStack(CardStack otherStack) {
        if(stack.size() == 1 || otherStack.size() > 1) return false;
        stack.addStack(otherStack);
        return true;
        }

    @Override
    public CardStack getStack(int amount) {
        return stack.getStack(1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
