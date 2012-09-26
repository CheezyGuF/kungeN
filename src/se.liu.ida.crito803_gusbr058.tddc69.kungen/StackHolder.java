package se.liu.ida.crito803_gusbr058.tddc69.kungen;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-21
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
public interface StackHolder {
 /*   private CardStack stack;
    private boolean stackable;
    private boolean alternatingColor;
    private boolean increasingOrder;
    private boolean movable;

    //flytta booleaner o skit till andra holders
    public StackHolder(boolean alternatingColor, boolean stackable, boolean increasingOrder, int limit, boolean movable){
        this.alternatingColor = alternatingColor;
        this.stackable = stackable;
        this.increasingOrder = increasingOrder;
        this.stack = new CardStack(limit);
        this.movable = new movable;
    }*/

    public boolean addStack(CardStack newStack);

    public CardStack removeStack(int start, int stop);

}
