import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GamePanel extends JPanel {

    private final int SCREEN_WIDTH = 800, SCREEN_HEIGHT = 800;

    private JLabel
            fourLabel = new JLabel("Probability of 4-sided die:"),
            sixLabel = new JLabel("Probability of 6-sided die:"),
            eightLabel = new JLabel("Probability of 8-sided die:"),
            tenLabel = new JLabel("Probability of 10-sided die:"),
            twelveLabel = new JLabel("Probability of 12-sided die:"),
            twentyLabel = new JLabel("Probability of 20-sided die:"),
            rollLabel = new JLabel("Enter the roll result here:");

    private JProgressBar
            fourProb = new JProgressBar(),
            sixProb = new JProgressBar(),
            eightProb = new JProgressBar(),
            tenProb = new JProgressBar(),
            twelveProb = new JProgressBar(),
            twentyProb = new JProgressBar();

    private JTextField textField = new JTextField();

    private final JComponent[] components = {fourLabel, fourProb, sixLabel, sixProb,
            eightLabel, eightProb, tenLabel, tenProb, twelveLabel, twelveProb, twentyLabel, twentyProb, rollLabel, textField};

    private JButton button = new JButton("Submit");
    private JLabel validate = new JLabel("ERROR: Enter a number between 1 and 20");
    private JLabel predict = new JLabel("You won");

    public GamePanel() {
        super(null);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(new Color(10, 220, 150));
        this.loadLabelsAndBars();
        this.loadOtherComponents();
    }

    private void loadLabelsAndBars() {
        int labelWidth = SCREEN_WIDTH * 2/5; // 40%
        int barWidth = SCREEN_WIDTH * 2/5; // 40%
        int height = SCREEN_HEIGHT / 20; // 5%
        int labelX = SCREEN_WIDTH / 10; // 10%
        int labelY = SCREEN_HEIGHT / 20; // 5%
        int barX = labelWidth + labelX; // 50%
        int barY = labelY; // 5%
        int incrementY = SCREEN_HEIGHT / 10; // 10%
        for (JComponent component : components) {
            if (component instanceof JLabel label) {
                label.setBounds(labelX, labelY, labelWidth, height);
                labelY += incrementY;
            } else if (component instanceof JProgressBar bar) {
                bar.setBounds(barX, barY, barWidth, height);
                bar.setValue((int) 100.0/6);
                // bar.setStringPainted(true);
                barY += incrementY;
            } else if (component instanceof JTextField field) {
                field.setBounds(barX, barY, barWidth, height);
                barY += incrementY;
            }
            this.add(component);
        }
    }

    private void loadOtherComponents() {
        int buttonX = SCREEN_WIDTH * 4/10; // 40%
        int buttonY = SCREEN_HEIGHT * 3/4; // 75%
        int buttonWidth = SCREEN_WIDTH / 5; // 20%
        int height = SCREEN_HEIGHT / 20; // 5%
        int validateY = SCREEN_HEIGHT * 33/40; // 82.5%
        int predictY = SCREEN_WIDTH * 9/10; // 90%
        int labelX = 0; // 0 %
        button.setBounds(buttonX, buttonY,buttonWidth, height);
        button.setFocusable(false);
        //button.addActionListener(this);
        this.add(button);

        validate.setForeground(Color.RED);
        validate.setBounds(labelX, validateY, SCREEN_WIDTH, height);
        validate.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(validate);
        validate.setVisible(true);

        predict.setForeground(Color.BLACK);
        predict.setBounds(labelX, predictY, SCREEN_WIDTH, height);
        predict.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(predict);
        predict.setVisible(true);
    }
}
