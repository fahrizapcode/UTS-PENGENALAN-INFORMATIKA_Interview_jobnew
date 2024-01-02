package main;

import javax.swing.JFrame;
public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame("Run And Run");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Run and run 2d");
        
        GamePanel gamepanel = new GamePanel();
        window.add(gamepanel);
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamepanel.startGameThread();
    }
}
