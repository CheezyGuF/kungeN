package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-26
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
public class GamePanel extends JPanel {
    public JPanel finalPanel = createFinalPanel();
    public JPanel freePanel = createFreePanel();
    public JPanel gamePanel = createGamePanel();
    public JTextArea testArea = new JTextArea();
    private FreeCell game;

    private JPanel createFreePanel(){
        JPanel freePanel = new JPanel();
        freePanel.setLayout(new GridLayout(1, 4, 10, 10));
        freePanel.setBackground(Color.GREEN);

        //Jiddra med fabriker och så

        return freePanel;
    }

    private JPanel createFinalPanel(){
        JPanel finalPanel = new JPanel();
        finalPanel.setLayout(new GridLayout(1, 4, 10, 10));
        finalPanel.setBackground(Color.RED);

        //Jiddra med fabriker och så

        return finalPanel;
    }

    private JPanel createGamePanel(){
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(1, 8, 10, 10));
        gamePanel.setBackground(Color.YELLOW);

        //Jiddra med fabriker och så

        return gamePanel;
    }

    //lägg till 'representationer' av tex gameHolders genom en Factory i griden;

    public GamePanel(FreeCell game) {
        this.setLayout(new BorderLayout());

        this.game = game;

        freePanel.add(hejsan());
        finalPanel.add(hejsan());
        gamePanel.add(testArea);
        gamePanel.setPreferredSize(new Dimension(getWidth(), 850));

        JPanel northPanel = new JPanel(new GridLayout(1,2));
        northPanel.setPreferredSize(new Dimension(getWidth(), 200));
        northPanel.add(freePanel);
        northPanel.add(finalPanel);

        add(testArea, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
    }





    JLabel hejsan(){
        return new JLabel("HEJSAN!!!!11! :)");
    }

}
