package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-20
 * Time: 17:51
 * To change this template use File | Settings | File Templates.
 */
public class GameCard {
    CardNumber number;
    CardColor color;

    public GameCard(CardNumber number, CardColor color) {
        this.number = number;
        this.color = color;
    }

    public static LinkedList<GameCard> createCardDeck(){
        LinkedList<GameCard> result = new LinkedList<GameCard>();

        for (CardColor color : CardColor.values()) {
            for (CardNumber number : CardNumber.values()) {
                result.add(new GameCard(number, color));
            }
        }
        return result;
    }

    public static LinkedList<GameCard> createShuffledDeck(){
        LinkedList<GameCard> result = createCardDeck();
        Collections.shuffle(result);
        return result;
    }
}
