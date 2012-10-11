package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-21
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
public class GameHolder extends StackHolder {

     @Override
    public boolean addStackWithRules(CardStack otherStack) {
        if(stack.isEmpty()){
            addStackNoRules(otherStack);
            return true;
        }else{
            GameCard last = stack.peekLast();
            GameCard first = otherStack.peekFirst();
            if(last.color.getSuperColor() != first.color.getSuperColor() &&
               last.number.ordinal() == first.number.ordinal() + 1){
                addStackNoRules(otherStack);
                return true;
            }
            return false;
        }
    }

    public void addStackNoRules(CardStack otherStack){
        this.stack.addStack(otherStack);
        notifyListeners();
    }

    @Override
    public CardStack getStack(int amount) {
        if(stack.isStraight(amount)){
            return stack.getStack(amount);
        }else{
            return null;
        }
    }
}
