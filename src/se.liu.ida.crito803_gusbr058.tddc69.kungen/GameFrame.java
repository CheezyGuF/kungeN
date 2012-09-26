package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: crito803
 * Date: 2012-09-25
 * Time: 10:41
 * To change this template use File | Settings | File Templates.
 */
public class GameFrame extends JFrame {



    public JPanel finalPanel = new JPanel();
    public JPanel freePanel = new JPanel();
    public JPanel gamePanel = new JPanel();

    public JTextArea testArea = new JTextArea();


    JLabel hejsan(){
        return new JLabel("HEJSAN!!!!11! :)");
    }

    public GameFrame() throws HeadlessException {
        super("Freecell");

        freePanel.setLayout(new GridLayout(1, 4, 10, 10));
        finalPanel.setLayout(new GridLayout(1, 4, 10, 10));
        gamePanel.setLayout(new GridLayout(1, 8, 10, 10));

        freePanel.setBackground(Color.GREEN);
        finalPanel.setBackground(Color.RED);
        gamePanel.setBackground(Color.YELLOW);

        freePanel.add(hejsan());
        finalPanel.add(hejsan());
        gamePanel.add(testArea);
        gamePanel.setPreferredSize(new Dimension(getWidth(), 850));

        JPanel northPanel = new JPanel(new GridLayout(1,2));
        northPanel.setPreferredSize(new Dimension(getWidth(), 200));
        northPanel.add(freePanel);
        northPanel.add(finalPanel);

        this.setLayout(new BorderLayout());

        add(northPanel, BorderLayout.NORTH);

        add(gamePanel, BorderLayout.CENTER);

        this.setSize(1680, 1050);

        //this.pack();
        this.setVisible(true);
    }
}
