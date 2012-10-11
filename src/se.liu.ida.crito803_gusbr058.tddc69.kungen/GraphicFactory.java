package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-10-01
 * Time: 13:52
 * To change this template use File | Settings | File Templates.
 */
public class GraphicFactory {

   //Factory! Denna är coolt!
    public static JLabel toGraphicCard(final GameCard gameCard, final Controller controller){
        final JLabel result = new JLabel(gameCard.number + " of " + gameCard.color);
        result.setBackground(Color.WHITE);
        result.setForeground(gameCard.color.getSuperColor()==CardColor.superColor.Red? Color.RED:Color.BLACK);

        result.setOpaque(true);
        result.setFocusable(true);
        result.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        result.addMouseListener(new MouseListener() {
            boolean marked = false;

        @Override
            public void mouseClicked(MouseEvent e) {
                controller.setFrom(gameCard);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(marked){
                    result.setBackground(new Color(0,167,0));
                    marked = false;
                }else{
                    result.setBackground(Color.ORANGE);
                    marked = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(!marked) result.setBackground(new Color(0,167,0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(!marked) result.setBackground(Color.WHITE);
            }
        });
        return result;
    }
}
