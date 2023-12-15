package model;

public class Die {

    private int numSides = 0;
    private double probability;

    public Die(int numSides) {
        this.numSides = numSides;
    }

    public int getNumSides() {
        return this.numSides;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public double probDieCanRollNumber(int roll) {
        if (roll <= this.getNumSides()) {
            return 1.0 / this.getNumSides();
        } else return 0.0;
    }
}
