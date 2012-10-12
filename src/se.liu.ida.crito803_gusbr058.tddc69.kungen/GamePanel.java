package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-26
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
public class GamePanel extends JPanel implements GameCompletedListener{
    private JPanel finalPanel, freePanel, gamePanel, gameCompletedPanel, currentCenterPanel;
    private FreeCell game;
    //private List<Controller> controllers = new LinkedList<Controller>();
    private Controller controller;

    private HashMap<GameCard, Component> cards = new HashMap<GameCard, Component>();
    private Collection<Container> stacks = new LinkedList<Container>();

    //lägg till 'representationer' av tex gameHolders genom en Factory i griden;

    public GamePanel(FreeCell game, Controller controller) {

        this.setLayout(new BorderLayout());

        this.game = game;
        this.controller = controller;

        for (Object oCard : game.getGameDeck()) {
            GameCard card = (GameCard) oCard;
            cards.put(card, GraphicFactory.toGraphicCard(card, controller));
        }

        finalPanel = createFinalPanel();
        freePanel = createFreePanel();
        gamePanel = createGamePanel();
        gameCompletedPanel = createGameCompletedPanel();
        gamePanel.setPreferredSize(new Dimension(getWidth(), 850));

        JPanel northPanel = new JPanel(new GridLayout(1,2));
        northPanel.setPreferredSize(new Dimension(getWidth(), 200));
        northPanel.add(freePanel);
        northPanel.add(finalPanel);

        add(northPanel, BorderLayout.NORTH);
        currentCenterPanel = gamePanel;
        add(currentCenterPanel, BorderLayout.CENTER);
    }

    private JPanel createGameCompletedPanel() {
        JPanel result = new JPanel();
        result.add(new JLabel("CONGRATULATIONS!!!"));
        result.add(new JLabel("YOU WOOONN!!!"));
        return result;
    }

    private JPanel createFreePanel(){
        JPanel freePanel = new JPanel();
        freePanel.setLayout(new GridLayout(1, game.freeHolders.length, 10, 10));
        freePanel.setBackground(Color.GREEN);

        //Jiddra med fabriker och så
        Container[] containers = new Container[game.freeHolders.length];
        for (int i = 0; i < game.freeHolders.length; i++) {
            FreeHolder freeHolder = game.freeHolders[i];
            containers[i] = GraphicFactory.toGraphicHolder(freeHolder, cards, controller);

            freeHolder.notifyListeners();
            freePanel.add(containers[i]);
        }

        return freePanel;
    }

    private JPanel createFinalPanel(){
        JPanel finalPanel = new JPanel();
        finalPanel.setLayout(new GridLayout(1, game.finalHolders.length, 10, 10));
        finalPanel.setBackground(Color.RED);

        //Jiddra med fabriker och så
        Container[] containers = new Container[game.finalHolders.length];
        for (int i = 0; i < game.finalHolders.length; i++) {
            FinalHolder finalHolder = game.finalHolders[i];
            containers[i] = GraphicFactory.toGraphicHolder(finalHolder, cards, controller);

            finalHolder.notifyListeners();
            finalPanel.add(containers[i]);
        }

        return finalPanel;
    }

    private JPanel createGamePanel(){
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(1, game.gameHolders.length, 10, 10));
        gamePanel.setBackground(Color.YELLOW);

        //Jiddra med fabriker och så
        Container[] containers = new Container[game.gameHolders.length];
        for (int i = 0; i < game.gameHolders.length; i++) {
            GameHolder gameHolder = game.gameHolders[i];
            containers[i] = GraphicFactory.toGraphicHolder(gameHolder, cards, controller);

            gameHolder.notifyListeners();
            gamePanel.add(containers[i]);
        }

        return gamePanel;
    }

    @Override
    public void gameCompleted() {
        changeCenterPanel(gameCompletedPanel);
    }

    public void fixPanels(){
        changeCenterPanel(gamePanel);
    }

    private void changeCenterPanel(JPanel curr){
        remove(currentCenterPanel);
        currentCenterPanel = curr;
        add(currentCenterPanel, BorderLayout.CENTER);
        validate();
        repaint();
    }
}
