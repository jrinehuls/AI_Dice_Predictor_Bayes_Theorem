package controller;

import util.Calculations;
import view.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitController implements ActionListener {

    GamePanel gp;
    JTextField textField;
    JLabel textLabel;
    JLabel predictLabel;
    JButton submitButton;
    Calculations calc;
    int four, six, eight, ten, twelve, twenty;

    public SubmitController(GamePanel gp) {
        this.calc = new Calculations();
        this.gp = gp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.textLabel = this.gp.getTextLabel();
        this.textField = this.gp.getTextField();
        this.predictLabel = this.gp.getPredictLabel();
        this.submitButton = (JButton) e.getSource();
        if (!submitButton.getText().equals("Try Again")) {
            int roll;
            try {
                roll = Integer.parseInt(textField.getText());
                if (roll >= 1 && roll <= 20) {
                    calc.calculateProbability(roll);
                    repaint();
                    finish();
                    this.textLabel.setForeground(Color.BLACK);
                    this.textLabel.setText("You entered: " + roll);
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                this.textLabel.setText("ERROR: Enter a number between 1 and 20");
                this.textLabel.setForeground(Color.RED);
            }
            this.textField.setText(null);
        } else {
            this.resetGame();
        }
    }

    public void repaint() {
        four = (int) (100 * calc.getFourSided().getProbability());
        this.gp.getFourBar().setValue(four);
        six = (int) (100 * calc.getSixSided().getProbability());
        this.gp.getSixBar().setValue(six);
        eight = (int) (100 * calc.getEightSided().getProbability());
        this.gp.getEightBar().setValue(eight);
        ten = (int) (100 * calc.getTenSided().getProbability());
        this.gp.getTenBar().setValue(ten);
        twelve = (int) (100 * calc.getTwelveSided().getProbability());
        this.gp.getTwelveBar().setValue(twelve);
        twenty = (int) (100 * calc.getTwentySided().getProbability());
        this.gp.getTwentyBar().setValue(twenty);
    }

    public void finish() {
        int certainty = 75;
        if(four >= certainty || six >= certainty || eight >= certainty || ten >= certainty || twelve >= certainty || twenty >= certainty) {
            if(four >= certainty) {
                this.predictLabel.setText("You're using a four sided die");
            }
            if(six >= certainty) {
                this.predictLabel.setText("You're using a six sided die");
            }
            if(eight >= certainty) {
                this.predictLabel.setText("You're using a eight sided die");
            }
            if(ten >= certainty) {
                this.predictLabel.setText("You're using a ten sided die");
            }
            if(twelve >= certainty) {
                this.predictLabel.setText("You're using a twelve sided die");
            }
            if(twenty >= certainty) {
                this.predictLabel.setText("You're using a twenty sided die");
            }
            this.predictLabel.setVisible(true);
            this.textField.setEnabled(false);
            this.submitButton.setText("Try Again");
        }
    }

    public void resetGame() {
        this.calc = new Calculations();
        this.gp.loadLabelsAndBars();
        this.predictLabel.setVisible(false);
        this.textLabel.setText("");
        this.textField.setEnabled(true);
        this.submitButton.setText("Submit");
    }
}
