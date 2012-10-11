package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

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
    public Controller controls;
    public JMenuBar menu = createMenu();

    public GameFrame() throws HeadlessException {
        super("Freecell");
        setLayout(new BorderLayout());

        game = new FreeCell();
        controls = new Controller(game);
        panel = new GamePanel(game, controls);
        game.registerGameCompletedListener(panel);
        //panel.registerController(controls);

        setJMenuBar(menu);

        add(panel, BorderLayout.CENTER);

        setSize(1680, 1050);
        setVisible(true);
    }

    private JMenuBar createMenu() {

        JMenu file = new JMenu("File");
        final JMenuItem newGame = new JMenuItem("New Game");
        final JMenuItem restartGame = new JMenuItem("Restart Game");
        final JMenuItem exitGame = new JMenuItem("Exit Game");
        file.add(newGame);
        file.add(restartGame);
        file.addSeparator();
        file.add(exitGame);

        JMenuBar menu = new JMenuBar();
        menu.add(file);

        final ActionListener MenuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == newGame){
                    int answer = JOptionPane.showConfirmDialog
                            (newGame, "Do you really want to start a new game?", "New game?", JOptionPane.YES_NO_OPTION);
                    if (answer == JOptionPane.YES_OPTION) {
                        game.newGame();
                    }
                }else if(e.getSource() == restartGame){
                    int answer = JOptionPane.showConfirmDialog
                            (restartGame, "Do you really want to restart the game?", "Restart game?", JOptionPane.YES_NO_OPTION);
                    if (answer == JOptionPane.YES_OPTION) {
                        game.restartGame();
                    }
                }else if(e.getSource() == exitGame){
                    int answer = JOptionPane.showConfirmDialog
                            (exitGame, "Do you really want to quit?", "Quit?", JOptionPane.YES_NO_OPTION);
                    if (answer == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            }
        };

        newGame.addActionListener(MenuListener);
        restartGame.addActionListener(MenuListener);
        exitGame.addActionListener(MenuListener
        );

        return menu;
    }
}