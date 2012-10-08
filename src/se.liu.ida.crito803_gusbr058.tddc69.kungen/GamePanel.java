package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-26
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
public class GamePanel extends JPanel {
    public JPanel finalPanel, freePanel, gamePanel;
    public JTextArea testArea = new JTextArea();
    private FreeCell game;

    private JPanel createFreePanel(){
        JPanel freePanel = new JPanel();
        freePanel.setLayout(new GridLayout(1, game.freeHolders.length, 10, 10));
        freePanel.setBackground(Color.GREEN);


        //Jiddra med fabriker och så
        for (FreeHolder holder : game.freeHolders){
            add(GraphicFactory.toGraphicHolder(holder));
        }

        return freePanel;
    }

    private JPanel createFinalPanel(){
        JPanel finalPanel = new JPanel();
        finalPanel.setLayout(new GridLayout(1, game.finalHolders.length, 10, 10));
        finalPanel.setBackground(Color.RED);

        //Jiddra med fabriker och så
        for (FinalHolder holder : game.finalHolders) add(GraphicFactory.toGraphicHolder(holder));

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
            containers[i] = GraphicFactory.toGraphicHolder(gameHolder);

            Iterator<GameCard> iter = gameHolder.iterator();
            while(iter.hasNext()) containers[i].add(GraphicFactory.toGraphicCard(iter.next()));
            gamePanel.add(containers[i]);
        }

        return gamePanel;
    }

    //lägg till 'representationer' av tex gameHolders genom en Factory i griden;

    public GamePanel(FreeCell game) {
        this.setLayout(new BorderLayout());

        this.game = game;

        finalPanel = createFinalPanel();
        freePanel = createFreePanel();
        gamePanel = createGamePanel();

//        freePanel.add(hejsan());
//        finalPanel.add(hejsan());
        //gamePanel.add(testArea);

        gamePanel.setPreferredSize(new Dimension(getWidth(), 850));

        JPanel northPanel = new JPanel(new GridLayout(1,2));
        northPanel.setPreferredSize(new Dimension(getWidth(), 200));
        northPanel.add(freePanel);
        northPanel.add(finalPanel);

        //add(testArea, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
    }


}
