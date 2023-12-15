package util;

public class Calculations {
	
	private final int NUM_DICE = 5;
	public double prob_four = 1.0/NUM_DICE;
	public double prob_six = 1.0/NUM_DICE;
	public double prob_eight = 1.0/NUM_DICE;
	public double prob_twelve = 1.0/NUM_DICE;
	public double prob_twenty = 1.0/NUM_DICE;
	private final int SIDES_FOUR = 4;
	private final int SIDES_SIX = 6;
	private final int SIDES_EIGHT = 8;
	private final int SIDES_TWELVE = 12;
	private final int SIDES_TWENTY = 20;
	private double sum = prob_four/SIDES_FOUR + prob_six/SIDES_SIX + prob_eight/SIDES_EIGHT + prob_twelve/SIDES_TWELVE + prob_twenty/SIDES_TWENTY;

//----------------------------------------------------------------------------------------------------------------------------
	
	public void calculateProbability(int roll) {
		// four
		if(roll <= SIDES_FOUR) {
			sum = prob_four/SIDES_FOUR + prob_six/SIDES_SIX + prob_eight/SIDES_EIGHT + prob_twelve/SIDES_TWELVE + prob_twenty/SIDES_TWENTY;
			prob_four = (prob_four/SIDES_FOUR)/sum;
			prob_six = (prob_six/SIDES_SIX)/sum;
			prob_eight = (prob_eight/SIDES_EIGHT)/sum;
			prob_twelve = (prob_twelve/SIDES_TWELVE)/sum;
			prob_twenty = (prob_twenty/SIDES_TWENTY)/sum;
		}
		// six
		if(roll > SIDES_FOUR && roll <= SIDES_SIX) {
			prob_four = 0;
			sum = prob_six/SIDES_SIX + prob_eight/SIDES_EIGHT + prob_twelve/SIDES_TWELVE + prob_twenty/SIDES_TWENTY;
			prob_six = (prob_six/SIDES_SIX)/sum;
			prob_eight = (prob_eight/SIDES_EIGHT)/sum;
			prob_twelve = (prob_twelve/SIDES_TWELVE)/sum;
			prob_twenty = (prob_twenty/SIDES_TWENTY)/sum;
		}
		// eight
		if(roll > SIDES_SIX && roll <= SIDES_EIGHT) {
			prob_four = 0;
			prob_six = 0;
			sum = prob_eight/SIDES_EIGHT + prob_twelve/SIDES_TWELVE + prob_twenty/SIDES_TWENTY;
			prob_eight = (prob_eight/SIDES_EIGHT)/sum;
			prob_twelve = (prob_twelve/SIDES_TWELVE)/sum;
			prob_twenty = (prob_twenty/SIDES_TWENTY)/sum;
		}
		// twelve
		if(roll > SIDES_EIGHT && roll <= SIDES_TWELVE) {
			prob_four = 0;
			prob_six = 0;
			prob_eight = 0;
			sum = prob_twelve/SIDES_TWELVE + prob_twenty/SIDES_TWENTY;
			prob_twelve = (prob_twelve/SIDES_TWELVE)/sum;
			prob_twenty = (prob_twenty/SIDES_TWENTY)/sum;
		}
		// twenty
		if(roll > SIDES_TWELVE && roll <= SIDES_TWENTY) {
			prob_four = 0;
			prob_six = 0;
			prob_eight = 0;
			prob_twelve = 0;
			sum = prob_twenty/SIDES_TWENTY;
			prob_twenty = (prob_twenty/SIDES_TWENTY)/sum;
		}

	}
}
