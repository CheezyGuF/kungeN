package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {

    //Kan läggas i konstruktorn.
    private Controller controls;
    private FreeCell game;
    private GamePanel panel;
    private JMenuBar menu = createMenu();

    public GameFrame() throws HeadlessException {
        super("Freecell");
        setLayout(new BorderLayout());

        game = new FreeCell();
        controls = new Controller(game);
        panel = new GamePanel(game, controls);
        game.addGameCompletedListener(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setJMenuBar(menu);

        add(panel, BorderLayout.CENTER);

        setSize(800, 600);
        setVisible(true);
    }

    private JMenuBar createMenu() {

        JMenu file = new JMenu("File");
        JMenu about = new JMenu("About");
        final JMenuItem aboutGame = new JMenuItem("About Game");
        final JMenuItem newGame     = new JMenuItem("New Game");
        final JMenuItem restartGame = new JMenuItem("Restart Game");
        final JMenuItem exitGame    = new JMenuItem("Exit Game");

        file.add(newGame);
        file.add(restartGame);
        file.addSeparator();
        file.add(exitGame);
        about.add(aboutGame);

        JMenuBar menu = new JMenuBar();
        menu.add(file);
        menu.add(about);

        final ActionListener MenuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == newGame){
                    int answer = JOptionPane.showConfirmDialog
                            (newGame, "Do you really want to start a new game?", "New game?", JOptionPane.YES_NO_OPTION);
                    if (answer == JOptionPane.YES_OPTION) {
                        game.newGame();
                        panel.fixPanels();
                    }
                }else if(e.getSource() == restartGame){
                    int answer = JOptionPane.showConfirmDialog
                            (restartGame, "Do you really want to restart the game?", "Restart game?", JOptionPane.YES_NO_OPTION);
                    if (answer == JOptionPane.YES_OPTION) {
                        game.restartGame();
                        panel.fixPanels();
                    }
                }else if(e.getSource() == exitGame){
                    int answer = JOptionPane.showConfirmDialog
                            (exitGame, "Do you really want to quit?", "Quit?", JOptionPane.YES_NO_OPTION);
                    if (answer == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }else if(e.getSource() == aboutGame){
                    JOptionPane.showMessageDialog(aboutGame,
                             "Kungen av Cristian Torrusio, Gustaf Brunberg.\n" +
                                    "\n" +
                                    "Vad går spelet ut på?\n" +
                                    "- Spelet går ut på att flytta alla kort ifrån spelplanen (där korten börjar) till de fyra (4) rutorna uppe till höger.\n" +
                                    "\n" +
                                    "Hur gör man?\n" +
                                    "- Man ska få korten uppe till höger i ordningen Ess till Kung, för att lyckas med detta så får man arbeta sig igenom högarna\t\n" +
                                    "  på spelplanen. Kort på spelplanen får endast staplas i stegar (eller som enskilda kort), stegarna byggs ihop av valör men\n" +
                                    "  måste skilja i färg mellan varje valör. Stegarna ska staplas ifrån Kung till Ess.\n" +
                                    "\n" +
                                    "- Rutorna uppe till vänster används som avlastningsrutor och kan göra att man kan flytta flera kort samtidigt.\n" +
                                    "\n" +
                                    "När vinner man?\n" +
                                    "- När man fått alla kort upp till de fyra (4) rutorna uppe till höger.", "About the game", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        };

        newGame.addActionListener(MenuListener);
        restartGame.addActionListener(MenuListener);
        exitGame.addActionListener(MenuListener);
        aboutGame.addActionListener(MenuListener);

        return menu;
    }
}


