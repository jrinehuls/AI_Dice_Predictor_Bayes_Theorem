package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class GameFrame extends JFrame {

    GamePanel gamePanel = new GamePanel();

    public GameFrame() {
        try {
            this.setIconImage(ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream("/die.png"))));
        } catch (IOException | NullPointerException e) {
            this.setIconImage(null);
        }
        this.add(gamePanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }

}
