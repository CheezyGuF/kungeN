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

    //ändra public -> private senare?
    public GamePanel panel;
    public FreeCell game;

    public GameFrame() throws HeadlessException {
        super("Freecell");
        this.setLayout(new BorderLayout());

        game = new FreeCell();
        panel = new GamePanel(game);

        add(panel, BorderLayout.CENTER);

        this.setSize(1680, 1050);
        //this.pack();
        this.setVisible(true);
    }
}
