package util;

import model.Die;

public class Calculations {

	static Die fourSided = new Die(4);
	static Die sixSided = new Die(6);
	static Die eightSided = new Die(8);
	static Die tenSided = new Die(10);
	static Die twelveSided = new Die(12);
	static Die twentySided = new Die(20);

	static Die[] dice = { fourSided, sixSided, eightSided, tenSided, twelveSided, twentySided };

	public static final int NUM_DICE = dice.length;

	public Calculations() {
		this.resetProbabilities();
	}
	
	public void calculateProbability(int roll) {
		double fourJointProb = fourSided.getJointProbability(roll);
		double sixJointProb = sixSided.getJointProbability(roll);
		double eightJointProb = eightSided.getJointProbability(roll);
		double tenJointProb = tenSided.getJointProbability(roll);
		double twelveJointProb = twelveSided.getJointProbability(roll);
		double twentyJointProb = twentySided.getJointProbability(roll);
		double sum = fourJointProb + sixJointProb + eightJointProb + tenJointProb + twelveJointProb + twentyJointProb;

		fourSided.setProbability(fourJointProb / sum);
		sixSided.setProbability(sixJointProb / sum);
		eightSided.setProbability(eightJointProb / sum);
		tenSided.setProbability(tenJointProb / sum);
		twelveSided.setProbability(twelveJointProb / sum);
		twentySided.setProbability(twentyJointProb / sum);

	}

	public void resetProbabilities() {
		for (Die die : dice) {
			die.setProbability(1.0 / NUM_DICE);
		}
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

	public Die getTenSided() {
		return tenSided;
	}

	public Die getTwelveSided() {
		return twelveSided;
	}

	public Die getTwentySided() {
		return twentySided;
	}

}
