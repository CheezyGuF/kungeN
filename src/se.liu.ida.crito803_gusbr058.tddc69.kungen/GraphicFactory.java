package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;

public class GraphicFactory {

    public static Container toGraphicHolder(StackHolder stackHolder, HashMap<GameCard, Component> cards, Controller controller){
        return new GraphicHolder(stackHolder, cards, controller);
    }

    public static Component toGraphicCard(GameCard gameCard, Controller controller){
        return new GraphicCard(gameCard, controller);
    }


    //Factory! Denna är coolt!
    private static class CardLabel extends JLabel implements MarkListener{
        boolean marked = false;
        
        public CardLabel(final GameCard gameCard, final Controller controller) {
            super(gameCard.number + " of " + gameCard.color);
            setPreferredSize(new Dimension(150, 40));
            setBackground(Color.WHITE);
            setForeground(gameCard.color.getSuperColor() == CardColor.superColor.Red ? Color.RED : Color.BLACK);

            setOpaque(true);
            if(controller != null){
                controller.addMarkListener(gameCard, this);
                addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        controller.select(gameCard);
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    //Ta bort ändringen av färg!
                    public void mouseEntered(MouseEvent e) {
                        if (!marked) setBackground(Color.YELLOW);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        if(!marked) setBackground(Color.WHITE);
                    }
                });
            }
        }

        @Override
        public void onMark() {
            marked = true;
            setBackground(Color.ORANGE);
        }

        @Override
        public void onUnmark() {
            marked = false;
            setBackground(Color.WHITE);
        }

    }
    private static class GraphicCard extends JLabel implements MarkListener{
        boolean marked = false;
        ImageIcon selected, unselected;
        int iconWidth, iconHeigth;
        
        public GraphicCard(final GameCard gameCard, final Controller controller) {
            super(toIcon(gameCard, true));
            iconWidth = getIcon().getIconWidth();
            iconHeigth = getIcon().getIconHeight();
            setDisabledIcon(toIcon(gameCard, false));
            setEnabled(false);
            setPreferredSize(new Dimension(iconWidth, iconHeigth));
            fixBounds(0);
            setOpaque(true);
            if(controller != null){
                controller.addMarkListener(gameCard, this);
                addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        controller.select(gameCard);
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    //Ta bort ändringen av färg!
                    public void mouseEntered(MouseEvent e) {
                        if (!marked) setBackground(Color.YELLOW);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        if(!marked) setBackground(Color.WHITE);
                    }
                });
            }
        }
        public void fixBounds(int offset){
            onUnmark();
            setBounds(0, offset, iconWidth, iconHeigth);
        }

        @Override
        public void onMark() {
            marked = true;
            setEnabled(true);
        }

        @Override
        public void onUnmark() {
            marked = false;
            setEnabled(false);
        }

    }

    private static ImageIcon toIcon(GameCard card, boolean selected){
            if(card == null) return new ImageIcon(GraphicFactory.class.getResource("~crito803/Documents/Java/projektKungen/src/pics/b1fv" + (selected?" copy":"") + ".png"));
            return new ImageIcon(GraphicFactory.class.getResource("~crito803/Documents/Java/projektKungen/src/pics/"+ card + (selected?" copy":"")+ ".png"));
    }
    
    //Ny klass
    private static class GraphicHolder extends JPanel implements StackListener{
        StackHolder stackHolder;
        HashMap<GameCard, Component> cards;
        Controller controller;

        JLayeredPane content;
        
        public GraphicHolder(final StackHolder stackHolder, HashMap<GameCard, Component> cards, final Controller controller) {
            super();
            this.controller = controller;
            this.cards = cards;
            this.stackHolder = stackHolder;
            setLayout(new FlowLayout());

            content = new JLayeredPane();
            content.setVisible(true);
            Component aCard = cards.entrySet().iterator().next().getValue();
            content.setPreferredSize(new Dimension(aCard.getWidth(), 1000));
            add(content);
            
            setOpaque(false);
            stackHolder.addListener(this);
            if(controller != null){
                addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        controller.select(stackHolder);
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

                    }
                });
            }
        }

        @Override
        public void graphicChanged() {
            content.removeAll();
            if(stackHolder.isEmpty()){
                content.add(createEmptySlot(stackHolder));
            }else{
                if(stackHolder instanceof GameHolder){
                    int i = 0;
                    for(GameCard card : stackHolder){
                        GraphicCard gc = (GraphicCard) cards.get(card);
                        gc.fixBounds(i*30);
                        content.add(gc, new Integer(i++)); //testa o byta ut "new Integer(i++)" mot bara "i++". de fakkar yyyyrrr!!!
                    }
                }else{
                    GraphicCard gc = (GraphicCard) cards.get(stackHolder.peekLast());
                    gc.fixBounds(0);
                    content.add(gc);
                }
            }
            //uppdatera grafiskt
            this.validate();
            this.repaint();
        }
        
        
        public JLabel createEmptySlot(final StackHolder stackHolder){
            final JLabel result = new JLabel(toIcon(null, true));
            
            result.setDisabledIcon(toIcon(null, false));
            result.setEnabled(false);
            result.setPreferredSize(new Dimension(result.getIcon().getIconWidth(), result.getIcon().getIconHeight()));
            result.setBounds(0, 0, result.getIcon().getIconWidth(), result.getIcon().getIconHeight());
            
            result.setOpaque(true);
            if(controller != null){
                result.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        controller.select(stackHolder);
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    //Ta bort ändringen av färg!
                    public void mouseEntered(MouseEvent e) {
                        result.setEnabled(true);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        result.setEnabled(false);
                    }
                });
            }
            return result;
        }
    }
    

    
    
     private static class OldGraphicHolder extends JPanel implements StackListener{
        StackHolder stackHolder;
        HashMap<GameCard, Component> cards;
        Controller controller;

        public OldGraphicHolder(final StackHolder stackHolder, HashMap<GameCard, Component> cards, final Controller controller) {
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
            if(controller != null){
                addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        controller.select(stackHolder);
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

                    }
                });
            }
        }

        @Override
        //varning för fulhaxx!
        public void graphicChanged() {
            removeAll();
            if(stackHolder.isEmpty()){
                add(createEmptySlot(controller));
            }else{
                if(stackHolder instanceof GameHolder){
                    for(GameCard card : stackHolder) add(cards.get(card));
                }else{
                    add(cards.get(stackHolder.peekLast()));
                }
            }
            //uppdatera grafiskt
            this.validate();
            this.repaint();
        }
        
        private JComponent createEmptySlot(final Controller controller){
            JLabel result = new JLabel("empty slot");
            result.setBackground(Color.CYAN);
            result.setOpaque(true);
            result.setFocusable(false);
            if(controller != null){
                result.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        controller.select(stackHolder);
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });
            }
            return result;
        }
    }
}
