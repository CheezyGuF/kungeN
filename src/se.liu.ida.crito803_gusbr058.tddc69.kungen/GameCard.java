package se.liu.ida.crito803_gusbr058.tddc69.kungen;

public class GameCard {
    CardNumber number;
    CardColor color;

    public GameCard(CardNumber number, CardColor color) {
        this.number = number;
        this.color = color;
    }

    //Kan få GameCards skrivna som en sträng, om man vill.
    //Ändra ints till enums i casesatsen.
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        int num = this.number.ordinal()+1;
        int col = this.color.ordinal();
        switch(col){
            case  0: result.append('s'); break;
            case  1: result.append('h'); break;
            case  2: result.append('c'); break;
            default: result.append('d');
        }
        switch (num){
            case 11: result.append('j'); break;
            case 12: result.append('q'); break;
            case 13: result.append('k'); break;
            default: result.append(num);
        }
        return result.toString();
    }
}
