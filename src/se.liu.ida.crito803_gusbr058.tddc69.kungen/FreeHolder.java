package se.liu.ida.crito803_gusbr058.tddc69.kungen;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-21
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
public class FreeHolder extends StackHolder {
/*
    private boolean stackable; Nej
    private boolean alternatingColor; Behövs inte
    private boolean increasingOrder; Behövs inte
    private boolean movable; Ja

    }*/

    @Override
    public boolean addStackWithRules(CardStack otherStack) {
        if(stack.size() == 1 || otherStack.size() > 1) return false;
        addStack(otherStack);
        return true;
        }

    @Override
    public CardStack getStackWithRules(int amount) {
        return getStack(1);
    }



}
