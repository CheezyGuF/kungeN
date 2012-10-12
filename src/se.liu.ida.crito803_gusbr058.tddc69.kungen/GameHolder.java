package se.liu.ida.crito803_gusbr058.tddc69.kungen;

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
        if(isEmpty()){
            addStack(otherStack);
            return true;
        }else{
            GameCard last = peekLast();
            GameCard first = otherStack.peekFirst();
            if(last.color.getSuperColor() != first.color.getSuperColor() &&
               last.number.ordinal() == first.number.ordinal() + 1){
                addStack(otherStack);
                return true;
            }
            return false;
        }
    }

    @Override
    public CardStack getStackWithRules(int amount) {
        if(isStraight(amount)){
            return getStack(amount);
        }else{
            return null;
        }
    }
}
