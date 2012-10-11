package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-10-01
 * Time: 13:52
 * To change this template use File | Settings | File Templates.
 */
public class GraphicFactory {

    public static JPanel toGraphicHolder(StackHolder stackHolder, HashMap<GameCard, Component> cards, Controller controller){
        return new GraphicHolder(stackHolder, cards, controller);
    }

    public static JLabel toGraphicCard(GameCard gameCard, Controller controller){
        return new GraphicCard(gameCard, controller);
    }


    //Factory! Denna är coolt!
    public static class GraphicCard extends JLabel {
        boolean marked = false;

        public GraphicCard(final GameCard gameCard, final Controller controller) {
            super(gameCard.number + " of " + gameCard.color);
            setBackground(Color.WHITE);
            setForeground(gameCard.color.getSuperColor() == CardColor.superColor.Red ? Color.RED : Color.BLACK);

            setOpaque(true);
            setFocusable(true);

            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    controller.setFrom(gameCard);
                    System.out.println(controller.getAmount() + " cards from " + controller.getOrigin().toString());
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    if (marked) {
                        setBackground(new Color(0, 167, 0));
                        marked = false;
                    } else {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            setBackground(Color.ORANGE);
                        } else {
                            setBackground(Color.YELLOW);
                        }

                        marked = true;
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!marked) setBackground(new Color(0, 167, 0));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!marked) setBackground(Color.WHITE);
                }
            });
        }

    }

    //Ny klass
    private static class GraphicHolder extends JPanel implements GraphicStackListener{
        StackHolder stackHolder;
        HashMap<GameCard, Component> cards;
        Controller controller;

        public GraphicHolder(final StackHolder stackHolder, HashMap<GameCard, Component> cards, final Controller controller) {
            super();
            this.controller = controller;
            this.cards = cards;
            this.stackHolder = stackHolder;
            if(stackHolder instanceof GameHolder){
                setLayout(new GridLayout(20,1));
            }else{
                setLayout(new BorderLayout(10, 10));
            }
            setBackground(new Color(0,167,0));
            stackHolder.addListener(this);
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    controller.setTarget(stackHolder);

                    System.out.println("target: " + controller.getTarget());
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
            });
        }

        @Override

        //varning för fulhaxx!
        public void graphicChanged() {
            this.removeAll();
            if(stackHolder instanceof FinalHolder){
                List<GameCard> list = stackHolder.stack.list;
                if(!list.isEmpty()) add(cards.get(list.get(list.size() -1)));
                this.validate();
                this.repaint();
                return;
            }
            boolean empty = true;
            for (GameCard card : stackHolder.stack.list) {
                empty = false;
                this.add(cards.get(card));
            }

            if(empty){
                JLabel helloimfuckingempty = new JLabel("empty slot");
                helloimfuckingempty.setBackground(Color.CYAN);
                helloimfuckingempty.setOpaque(true);
                this.add(helloimfuckingempty);
            }
            this.validate();
            this.repaint();
            //uppdatera grafiskt
        }
    }

}
