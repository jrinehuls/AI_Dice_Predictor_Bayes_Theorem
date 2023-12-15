import javax.swing.*;

public class GameFrame extends JFrame {

    GamePanel gamePanel = new GamePanel();

    public GameFrame() {
        this.add(gamePanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }

}
