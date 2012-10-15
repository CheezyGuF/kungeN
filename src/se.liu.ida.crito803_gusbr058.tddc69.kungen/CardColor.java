package se.liu.ida.crito803_gusbr058.tddc69.kungen;

public enum CardColor {
    Spades(0),Hearts(1), Clubs(2), Diamonds(3);

    CardColor(int index){
    }

    public enum superColor{
        Black, Red;
    }

    public superColor getSuperColor(){
        return (this.ordinal() % 2 == 0 ? superColor.Black : superColor.Red);
    }
}
