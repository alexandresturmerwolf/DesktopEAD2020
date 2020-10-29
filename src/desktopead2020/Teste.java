package desktopead2020;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Teste extends JFrame{    
    
    private static JButton bt = null;
    
    public static void main(String[] args) {
        Teste t = new Teste();
        t.setSize(400, 600);
        t.setTitle("Minha Janelinha");
        bt = new JButton("Meu botão");
        t.add(bt);
        t.pack();
        t.setVisible(true);
    }
}
