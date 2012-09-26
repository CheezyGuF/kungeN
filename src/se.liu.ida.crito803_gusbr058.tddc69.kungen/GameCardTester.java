package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-20
 * Time: 17:56
 * To change this template use File | Settings | File Templates.
 */
public class GameCardTester {
    public static void main(String[] args) {
        LinkedList<GameCard> list = GameCard.createShuffledDeck();


        GameFrame gf = new GameFrame();
        StringBuilder builder = new StringBuilder();

        int index = 1;
        for (GameCard card : list) {
            builder.append((index<10?" ":"")+ (index++)+ ": " + card.color.toString() + "\t" + card.number.toString() + "\t" +
                               (card.color.getSuperColor())+ "\n");
        }
        CardStack cs = new CardStack();
        gf.testArea.setText(builder.toString());
    }
}
