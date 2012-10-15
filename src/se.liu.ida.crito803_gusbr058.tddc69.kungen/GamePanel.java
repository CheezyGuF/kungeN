package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.awt.*;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements GameCompletedListener{
    private Controller controller;
    private FreeCell game;
    private JPanel finalPanel, freePanel, gamePanel, gameCompletedPanel, currentCenterPanel;

    private HashMap<GameCard, Component> cards = new HashMap<GameCard, Component>();

    public GamePanel(FreeCell game, Controller controller) {

        this.setLayout(new BorderLayout());

        this.game = game;
        this.controller = controller;

        for (GameCard card : game.getGameDeck()) {
            cards.put(card, GraphicFactory.toGraphicCard(card, this.controller));
        }

        finalPanel = createFinalPanel();
        freePanel = createFreePanel();
        gamePanel = createGamePanel();
        gameCompletedPanel = createGameCompletedPanel();

        gamePanel.setPreferredSize(new Dimension(getWidth(), 850));
        currentCenterPanel = gamePanel;

        JPanel northPanel = new JPanel(new GridLayout(1,2));
        northPanel.setPreferredSize(new Dimension(getWidth(), 200));
        northPanel.add(freePanel);
        northPanel.add(finalPanel);

        add(northPanel, BorderLayout.NORTH);
        add(currentCenterPanel, BorderLayout.CENTER);
    }

    @Override
    public void gameCompleted() {
        changeCenterPanel(gameCompletedPanel);
    }
    public void fixPanels(){
        changeCenterPanel(gamePanel);
    }

    private JPanel createFreePanel(){
        JPanel freePanel = new JPanel();

        freePanel.setLayout(new GridLayout(1, game.freeHolders.length, 10, 10));
        //freePanel.setBackground(Color.GREEN);
        freePanel.setBackground(new Color(0,167,0));

        //Jiddra med fabriker och så
        for (StackHolder stackHolder : game.freeHolders) {
            freePanel.add(GraphicFactory.toGraphicHolder(stackHolder, cards, controller));
            stackHolder.notifyListeners();
        }
        return freePanel;
    }
    private JPanel createFinalPanel(){
        JPanel finalPanel = new JPanel();
        finalPanel.setLayout(new GridLayout(1, game.finalHolders.length, 10, 10));
        //finalPanel.setBackground(Color.RED);
        finalPanel.setBackground(new Color(0,167,0));

        //Jiddra med fabriker och så
        for (StackHolder stackHolder : game.finalHolders) {
            finalPanel.add(GraphicFactory.toGraphicHolder(stackHolder, cards, controller));
            stackHolder.notifyListeners();
        }
        return finalPanel;
    }
    private JPanel createGamePanel(){
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(1, game.gameHolders.length, 10, 10));
        //gamePanel.setBackground(Color.YELLOW);
        gamePanel.setBackground(new Color(0,167,0));

        //Jiddra med fabriker och så
        for (StackHolder stackHolder : game.gameHolders) {
            gamePanel.add(GraphicFactory.toGraphicHolder(stackHolder, cards, controller));
            stackHolder.notifyListeners();
        }
        return gamePanel;
    }
    private JPanel createGameCompletedPanel() {
        final JPanel result = new JPanel();
        result.add(new JLabel("CONGRATULATIONS!!!"));
        result.add(new JLabel("YOU WOOONN!!!"));
//        final Collection<LittleCircleWithNiceColors> circles = new LinkedList<LittleCircleWithNiceColors>();
//        for (int i = 0; i < 100; i++) {
//            circles.add(new LittleCircleWithNiceColors((int)(Math.random()*getWidth())));
//        }
//
//        javax.swing.Timer ticker = new Timer(100, new AWTEventMulticasterc);
//        TimerTask timerTask = new TimerTask() {
//
//            @Override
//            public void run() {
//                for (LittleCircleWithNiceColors c : circles) {
//                    c.tick();
//                    c.paint(getGraphics());
//                }
//            }
//        };
//        Timer timer = new Timer();
//        timer.schedule(timerTask, 100);

        return result;
    }

    private void changeCenterPanel(JPanel curr){
        remove(currentCenterPanel);
        currentCenterPanel = curr;
        add(currentCenterPanel, BorderLayout.CENTER);
        validate();
        repaint();
    }
}

class LittleCircleWithNiceColors{
    int x, y = 0;
    double acceleration = 0.982;
    double speed = 0;

    public LittleCircleWithNiceColors(int x) {
        this.x = x;
    }

    public void tick(){
        y += speed;
        speed += acceleration;
    }

    public void paint(Graphics g){
        g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
        g.fillOval(x,y, 25, 25);

    }
}