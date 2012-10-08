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
    public boolean addStack(CardStack otherStack) {
        if(stack.isEmpty()){
            stack.addStack(otherStack);
            return true;
        }else{
            GameCard last = stack.peekLast();
            GameCard first = otherStack.peekFirst();
            if(last.color.getSuperColor() != first.color.getSuperColor() &&
               last.number.ordinal() == first.number.ordinal() + 1){
                stack.addStack(otherStack);
                return true;
            }
            return false;
        }
    }

    public void addStackNoRules(CardStack otherStack){
        this.stack.addStack(otherStack);
    }

    public void addCard(GameCard card){
        stack.list.add(card);
    }

    @Override
    public CardStack getStack(int amount) {
        //Ctrl tryck på isStraight!!!!!!!
        if(stack.isStraight(amount)){
            return stack.getStack(amount);
        }else{
            return null;
        }
    }


}
