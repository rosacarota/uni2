package GUI;

import core.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.jar.JarEntry;

public class GUI extends JFrame {
   private ArrayList<Player> listPlayer;

   public GUI (String title) {
      listPlayer = new ArrayList<>();

      this.setTitle(title);
      this.setSize(600, 400);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      this.setLocationRelativeTo(null);
      this.setResizable(false);

      Container container =
//
//      JPanel panel = new JPanel();
//      this.add(panel);
   }

//   private JPanel buildPanel() {
//      JPanel mainPanel = new JPanel();
//
//      JPanel buttonPanel = new JPanel();
//      buttonPanel.setLayout();
//      JButton jButton = new JButton();
//   }
}
