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
    JLabel predictlabel;
    JButton submitButton;
    Calculations calc;
    int four;
    int six;
    int eight;
    int ten;
    int twelve;
    int twenty;

    public SubmitController(GamePanel gp) {
        this.calc = new Calculations();
        this.gp = gp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.textLabel = this.gp.getTextLabel();
        this.textField = this.gp.getTextField();
        this.predictlabel = this.gp.getPredictLabel();
        this.submitButton = (JButton) e.getSource();
        four = (int)(100*calc.prob_four);
        int roll;
        try {
            roll = Integer.parseInt(textField.getText());
            if(roll >= 1 && roll <= 20) {
                calc.calculateProbability(roll);
                redo();
                finish();
                this.textLabel.setForeground(Color.BLACK);
                this.textLabel.setText("You entered: " + roll);
            }
            else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            this.textLabel.setText("ERROR: Enter a number between 1 and 20");
            this.textLabel.setForeground(Color.RED);
        }
        this.textField.setText(null);
    }

    public void redo() {
        four = (int) (100*calc.prob_four);
        this.gp.getFourBar().setValue(four);
        six = (int) (100*calc.prob_six);
        this.gp.getSixBar().setValue(six);
        eight = (int) (100*calc.prob_eight);
        this.gp.getEightBar().setValue(eight);
        ten = 0; // (int) (100*calc.prob_twelve);
        this.gp.getTenBar().setValue(ten);
        twelve = (int) (100*calc.prob_twelve);
        this.gp.getTwelveBar().setValue(twelve);
        twenty = (int) (100*calc.prob_twenty);
        this.gp.getTwentyBar().setValue(twenty);
    }

    public void finish() {
        int certainty = 75;
        if(four >= certainty || six >= certainty || eight >= certainty || twelve >= certainty || twenty >= certainty) {
            if(four >= certainty) {
                this.predictlabel.setText("You're using a four sided die");
            }
            if(six >= certainty) {
                this.predictlabel.setText("You're using a six sided die");
            }
            if(eight >= certainty) {
                this.predictlabel.setText("You're using a eight sided die");
            }
            if(twelve >= certainty) {
                this.predictlabel.setText("You're using a twelve sided die");
            }
            if(twenty >= certainty) {
                this.predictlabel.setText("You're using a twenty sided die");
            }
            this.predictlabel.setVisible(true);
            this.textField.setEnabled(false);
            this.submitButton.setEnabled(false);
        }
    }
}
