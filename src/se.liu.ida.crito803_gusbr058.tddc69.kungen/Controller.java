package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: gusbr058
 * Date: 2012-10-09
 * Time: 13:08
 * To change this template use File | Settings | File Templates.
 */
public class Controller {
    private FreeCell game;
    private StackHolder origin;
    private StackHolder target;
    private int amount;

    public Controller(FreeCell game) {
        this.game = game;
    }

    public void setFrom(StackHolder origin, int amount) {
        this.origin = origin;
        this.amount = amount;
    }

    public void setTo(GameCard card){
        setTarget(game.findCard(card));
    }

    public void setFrom(GameCard card){
        if(origin != null && target == null) setTo(card);

/*utkommenterad pga "icke OO". designbeslut iom delegering till FreeCell
        StackHolder result = null;
        int amount = 0;
        for (StackHolder sh : game.freeHolders) {
            Iterator iter = sh.iterator();
            int currAmount = 0;
            while(iter.hasNext()){
                currAmount++;
                if(iter.next().equals(card)){
                    result = sh;
                    amount = currAmount;
                }
            }
        }
        for (StackHolder sh : game.gameHolders) {
            Iterator iter = sh.iterator();
            int currAmount = 0;
            while(iter.hasNext()){
                currAmount++;
                if(iter.next().equals(card)){
                    result = sh;
                    amount = currAmount;
                }
            }
        }
*/
        StackHolder result = game.findCard(card);
        amount = result.cardAmount(card);
        setFrom(result, amount);
    }

    public StackHolder getOrigin() {
        return origin;
    }

    public int getAmount() {
        return amount;
    }

    public void setTarget(StackHolder target) {
        this.target = target;
        executeCommand();
    }

    public StackHolder getTarget() {
        return target;
    }

    private void executeCommand(){
        if(target != null && origin != null && amount > 0){
            game.move(amount, origin, target);
            amount = 0;
            target = null;
            origin = null;
        }
    }

}
