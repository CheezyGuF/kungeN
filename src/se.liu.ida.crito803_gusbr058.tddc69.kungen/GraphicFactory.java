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
    public static JLabel toGraphicCard(final GameCard gameCard){// final Controller controller){
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
                //controller.setFrom(gameCard);
                if(e.getButton() == MouseEvent.BUTTON1) System.out.println("hejsan, mouse 1 klickad!");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(marked){
                    result.setBackground(new Color(0,167,0));
                    marked = false;
                }else{
                    if(e.getButton() == MouseEvent.BUTTON1){
                        result.setBackground(Color.ORANGE);
                    }else{
                        result.setBackground(Color.YELLOW);
                    }

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

    public static JPanel toGraphicHolder(StackHolder stackHolder){
        return new GraphicHolder(stackHolder);
    }








    private static class GraphicHolder extends JPanel implements GraphicStackListener, MouseListener {
        StackHolder stackHolder;

        public GraphicHolder(StackHolder stackHolder) {
            super();
            this.stackHolder = stackHolder;
            if(stackHolder instanceof GameHolder){
                setLayout(new GridLayout(20,1));
            }else{
                setLayout(new GridLayout(1, 1));
            }
            setBackground(new Color(0,167,0));
            stackHolder.addListener(this);
        }



        @Override
        public void graphicChanged() {
            //uppdatera grafiskt
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

}
