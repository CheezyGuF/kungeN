package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-10-01
 * Time: 13:52
 * To change this template use File | Settings | File Templates.
 */
public class GraphicFactory {

    public GraphicFactory() {
    }

    public static JPanel toGraphicHolder(StackHolder stackHolder){
        JPanel result = new JPanel();
        if(stackHolder instanceof GameHolder){
            result.setLayout(new GridLayout(20,1));
        }else{
            result.setLayout(new GridLayout(1, 1));
        }
        result.setBackground(new Color(0,167,0));
        return result;
    }


    //Factory! Denna är coolt!
    public static JLabel toGraphicCard(GameCard gameCard){
        final JLabel result = new JLabel(gameCard.number + " of " + gameCard.color);
        result.setBackground(Color.WHITE);
        result.setForeground(gameCard.color.getSuperColor()==CardColor.superColor.Red? Color.RED:Color.BLACK);

        result.setOpaque(true);
        result.setFocusable(true);
        result.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                result.setBackground(new Color(0,167,0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                result.setBackground(Color.WHITE);
            }
        });
        return result;
    }
}
