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

    public String toBeautifulString(){
        StringBuilder result = new StringBuilder();
        int num = this.number.ordinal()+1;
        int col = this.color.ordinal();
        switch (num){
            case  1: result.append('A'); break;
            case 11: result.append('J'); break;
            case 12: result.append('D'); break;
            case 13: result.append('K'); break;
            default: result.append(num);
        }
        switch(col){
            case  0: result.append('S'); break;
            case  1: result.append('H'); break;
            case  2: result.append('C'); break;
            default: result.append('D');
        }
        return result.toString();
    }
}
