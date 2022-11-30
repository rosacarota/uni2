import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class ClickListener implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("bottoncinooo!");
    }

    @Override
    public void mousePressed(MouseEvent e) {

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
}
public class Bottoncino extends JFrame {
    JButton pulsantino1 = new JButton("Sono pulsantino 1");
    JButton pulsantino2 = new JButton("Sono pulsantino 2");

    public Bottoncino() {
        super("Pulsantini di prova");
        setSize(300,80);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel pannellino = new JPanel();
        pannellino.add(pulsantino1);
        pannellino.add(pulsantino2);
        setContentPane(pannellino);
        show();

        MouseListener m = new ClickListener();
        pulsantino1.addMouseListener(m);
        pulsantino2.addMouseListener(m);
    }
}
