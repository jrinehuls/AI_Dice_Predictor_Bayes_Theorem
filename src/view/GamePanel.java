package view;

import controller.SubmitController;
import util.Calculations;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final int SCREEN_WIDTH = 500, SCREEN_HEIGHT = 500;

    private final JLabel
            fourLabel = new JLabel("Probability of 4-sided die:"),
            sixLabel = new JLabel("Probability of 6-sided die:"),
            eightLabel = new JLabel("Probability of 8-sided die:"),
            tenLabel = new JLabel("Probability of 10-sided die:"),
            twelveLabel = new JLabel("Probability of 12-sided die:"),
            twentyLabel = new JLabel("Probability of 20-sided die:"),
            rollLabel = new JLabel("Enter the roll result here:");

    private final JProgressBar
            fourBar = new JProgressBar(),
            sixBar = new JProgressBar(),
            eightBar = new JProgressBar(),
            tenBar = new JProgressBar(),
            twelveBar = new JProgressBar(),
            twentyBar = new JProgressBar();

    private final JTextField textField = new JTextField();

    private final JComponent[] components = {fourLabel, fourBar, sixLabel, sixBar,
            eightLabel, eightBar, tenLabel, tenBar, twelveLabel, twelveBar, twentyLabel, twentyBar, rollLabel, textField};

    private final JButton button = new JButton("Submit");
    private final JLabel textLabel = new JLabel();
    private final JLabel predictLabel = new JLabel();

    private final SubmitController sc;

    public GamePanel() {
        super(null);
        sc = new SubmitController(this);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(new Color(10, 220, 150));
        this.loadLabelsAndBars();
        this.loadOtherComponents();

    }

    public void loadLabelsAndBars() {
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
                label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, height * 2/5));
                labelY += incrementY;
            } else if (component instanceof JProgressBar bar) {
                bar.setBounds(barX, barY, barWidth, height);
                bar.setValue((int) 100.0/ Calculations.NUM_DICE);
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
        button.addActionListener(sc);
        this.add(button);

        textLabel.setForeground(Color.RED);
        textLabel.setBounds(labelX, validateY, SCREEN_WIDTH, height);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(textLabel);
        textLabel.setVisible(true);

        predictLabel.setForeground(Color.BLACK);
        predictLabel.setBounds(labelX, predictY, SCREEN_WIDTH, height);
        predictLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(predictLabel);
        predictLabel.setVisible(true);
    }

    public JTextField getTextField() {
        return this.textField;
    }

    public JLabel getTextLabel() {
        return this.textLabel;
    }

    public JLabel getPredictLabel() {
        return this.predictLabel;
    }

    public JProgressBar getFourBar() {
        return this.fourBar;
    }

    public JProgressBar getSixBar() {
        return this.sixBar;
    }

    public JProgressBar getEightBar() {
        return this.eightBar;
    }

    public JProgressBar getTenBar() {
        return this.tenBar;
    }

    public JProgressBar getTwelveBar() {
        return this.twelveBar;
    }

    public JProgressBar getTwentyBar() {
        return this.twentyBar;
    }

}
