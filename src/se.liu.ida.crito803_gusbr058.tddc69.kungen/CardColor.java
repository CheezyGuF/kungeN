package se.liu.ida.crito803_gusbr058.tddc69.kungen;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-20
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 */
public enum CardColor {
    Spades(0),Hearts(1);//,Clubs(2), Diamonds(3);

    CardColor(int index){
    }

    public enum superColor{
        Black, Red;
    }

    public superColor getSuperColor(){
        return (this.ordinal() % 2 == 0 ? superColor.Black : superColor.Red);
    }
}
