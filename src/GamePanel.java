import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GamePanel extends JPanel {

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
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(new Color(10, 220, 150));
        this.loadLabelsAndBars();
        this.loadOtherComponents();
    }

    private void loadLabelsAndBars() {
        int labelWidth = 150;
        int barWidth = 200;
        int height = 25;
        int labelX = 50;
        int labelY = 25;
        int barX = 225;
        int barY = 25;
        int incrementY = 50;
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
        button.setBounds(200, 375,100, 25);
        button.setFocusable(false);
        //button.addActionListener(this);
        this.add(button);

        validate.setForeground(Color.RED);
        validate.setBounds(0, 410, 500, 25);
        validate.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(validate);
        validate.setVisible(true);

        predict.setForeground(Color.BLACK);
        predict.setBounds(0, 445, 500, 25);
        predict.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(predict);
        predict.setVisible(true);
    }
}