package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class Controller {
    private FreeCell game;
    private StackHolder origin;
    private StackHolder target;
    private int amount;
    
    HashMap<GameCard, Collection<MarkListener>> markListeners = new HashMap<GameCard, Collection<MarkListener>>();

    public Controller(FreeCell game) {
        this.game = game;
        origin = null;
        target = null;
        amount = 0;
    }

    public StackHolder getOrigin() {
        return origin;
    }
    public StackHolder getTarget() {
        return target;
    }

    public int getAmount() {
        return amount;
    }
    public void select(GameCard card){
        StackHolder holder = game.findCard(card);
        if(origin == null || origin == holder){
            notifyMarkListeners(origin, false);
            amount = holder.cardAmount(card);
            if(!holder.isStraight(amount)){
                origin = null;
                amount = 0;
            }else{
                origin = holder;
                notifyMarkListeners(origin.getStack(amount), true);
            }
        }else{
            target = holder;
            if(!attemptExecution()){
                select(card);
            }
        }
    }
    public void select(StackHolder holder){
        if(origin != null){
            target = holder;
            attemptExecution();
        }
    }
    public void addMarkListener(GameCard card, MarkListener listener){
        Collection cardListeners = markListeners.get(card);
        if(cardListeners == null){
            cardListeners = new LinkedList<MarkListener>();
            cardListeners.add(listener);
            markListeners.put(card, cardListeners);
        }else{
            cardListeners.add(listener);
        }
    }

    private boolean attemptExecution(){
        boolean didMove = false;
        if(target != null && origin != null && amount > 0){
            didMove = game.move(amount, origin, target);
            if(didMove){
                notifyMarkListeners(target, false);
            }else{
                notifyMarkListeners(origin, false);
            }
            amount = 0;
            origin = null;
            target = null;
        }
        return didMove;
    }
    private void notifyMarkListeners(CardStack stack, boolean marked){
        if(stack == null)return;
        for (GameCard card : stack) {
            notifyMarkListeners(card, marked);
        }
    }
    private void notifyMarkListeners(GameCard card, boolean marked){
        Collection<MarkListener> listeners = markListeners.get(card);
        if(listeners == null) return;
        for (MarkListener markListener : listeners) {
            if(marked){
                markListener.onMark();
            }else{
                markListener.onUnmark();
            }
        }
    }
}
