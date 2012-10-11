package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-21
 * Time: 19:56
 * To change this template use File | Settings | File Templates.
 */
public class FinalHolder extends StackHolder {
    /*
    private boolean stackable; Ja
    private boolean alternatingColor; Nej
    private boolean increasingOrder; Ja, Ess - Kung
    private boolean movable; NEJ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    */

    public boolean addStackWithRules(CardStack oneCard) {
        if(oneCard.size() > 1) return false;
        if(stack.isEmpty()){
            if(oneCard.peekFirst().number.equals(CardNumber.A)){
                stack.addStack(oneCard);
                return true;
            }else{
                return false;
            }
        }else{
            GameCard last = stack.peekLast();
            GameCard first = oneCard.peekFirst();
            System.out.println("putting " + first.toBeautifulString() + " on " + last.toBeautifulString());
            if(last.color.equals(first.color) &&
               last.number.ordinal() == first.number.ordinal() - 1){
                stack.addStack(oneCard);
                return true;
            }else{
                return false;
            }
        }
    }

    //Den här behövs inte!
    public CardStack getStack(int amount) {
        return null;
    }


}
