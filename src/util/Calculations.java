package util;

import model.Die;

public class Calculations {

	Die fourSided = new Die(4);
	Die sixSided = new Die(6);
	Die eightSided = new Die(8);
	Die twelveSided = new Die(12);
	Die twentySided = new Die(20);

	Die[] dice = {fourSided, sixSided, eightSided, twelveSided, twentySided};
	
	/*
	public double prob_four = 1.0/NUM_DICE;
	public double prob_six = 1.0/NUM_DICE;
	public double prob_eight = 1.0/NUM_DICE;
	public double prob_twelve = 1.0/NUM_DICE;
	public double prob_twenty = 1.0/NUM_DICE;
	*/

	public Calculations() {
		int numDice = dice.length;
		for (Die die : dice) {
			die.setProbability(1.0 / numDice);
		}
	}
	
	public void calculateProbability(int roll) {
		double sum = fourSided.getProbability() * fourSided.probDieCanRollNumber(roll) +
				sixSided.getProbability() * sixSided.probDieCanRollNumber(roll) +
				eightSided.getProbability() * eightSided.probDieCanRollNumber(roll) +
				twelveSided.getProbability() * twelveSided.probDieCanRollNumber(roll) +
				twentySided.getProbability() * twentySided.probDieCanRollNumber(roll);

		fourSided.setProbability(fourSided.getProbability() * fourSided.probDieCanRollNumber(roll) / sum);
		sixSided.setProbability(sixSided.getProbability() * sixSided.probDieCanRollNumber(roll) / sum);
		eightSided.setProbability(eightSided.getProbability() * eightSided.probDieCanRollNumber(roll) / sum);
		twelveSided.setProbability(twelveSided.getProbability() * twelveSided.probDieCanRollNumber(roll) / sum);
		twentySided.setProbability(twentySided.getProbability() * twentySided.probDieCanRollNumber(roll) / sum);

	}

	public Die getFourSided() {
		return fourSided;
	}

	public Die getSixSided() {
		return sixSided;
	}

	public Die getEightSided() {
		return eightSided;
	}

	public Die getTwelveSided() {
		return twelveSided;
	}

	public Die getTwentySided() {
		return twentySided;
	}

	public void probRollGivenDie() {

	}
}
