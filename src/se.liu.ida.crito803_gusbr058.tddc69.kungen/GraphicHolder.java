package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * User: gusbr058
 * Date: 2012-10-09
 * Time: 12:00
 * To change this template use File | Settings | File Templates.
 */
public class GraphicHolder extends JPanel implements StackListener, MouseListener {
    StackHolder stackHolder;

    public GraphicHolder(StackHolder stackHolder) {
        super();
        this.stackHolder = stackHolder;
        if(stackHolder instanceof GameHolder){
            setLayout(new GridLayout(20,1));
        }else{
            setLayout(new GridLayout(1, 1));
        }
        setBackground(new Color(0,167,0));
        stackHolder.addListener(this);
    }



    @Override
    public void stackChanged() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
}
