package example;

import javax.swing.*;
import java.text.Normalizer;

public class Window {
    private JButton pressButton;

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("HELLO");
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }
}
