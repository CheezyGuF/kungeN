package se.liu.ida.crito803_gusbr058.tddc69.kungen;

public class FreeHolder extends StackHolder {
/*
    private boolean stackable; Nej
    private boolean alternatingColor; Behövs inte
    private boolean increasingOrder; Behövs inte
    private boolean movable; Ja

    }*/

    @Override
    public boolean addStackWithRules(CardStack otherStack) {
        if(size() == 1 || otherStack.size() > 1) return false;
        addStack(otherStack);
        return true;
    }

    @Override
    public CardStack getStackWithRules(int amount) {
        return getStack(1);
    }
}
