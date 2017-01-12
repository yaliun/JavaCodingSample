package com.nts.unittest.bowlinggame;

/*
 * 
 * @author SeokJong.Gwak
 *
 */
public class Game {

	static final int FRAME_MAX_POINTS = 10;
	static final int NUMBER_OF_FRAMES = 10;
	static final int ZERO = 0;
	private int currentRoll = 0;
	private int[] rolls = new int[21];
	
	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}
	
	public int score() {
		return score(NUMBER_OF_FRAMES);
	}

	public int score(int currentFrame) {
		int score = 0;
		int rollIndex = 0;
		
		for (int frame = 0; frame < currentFrame; frame++) {
			if (isStrike(rollIndex)) {
				score += strikePoints(rollIndex);
				rollIndex++;
			}
			else if (isSpare(rollIndex)) {
				score += sparePoints(rollIndex);
				rollIndex += 2;
			} else {
				score += framePoints(rollIndex);
				rollIndex += 2;
			}
		}
		
		return score;
	}
	
	int[] getRolls() {
		return rolls;
	}

	private int framePoints(int rollIndex) {
		return rolls[rollIndex] + rolls[rollIndex + 1];
	}

	private int sparePoints(int rollIndex) {
		return FRAME_MAX_POINTS + rolls[rollIndex + 2];
	}

	private int strikePoints(int rollIndex) {
		return FRAME_MAX_POINTS + rolls[rollIndex + 1] + rolls[rollIndex + 2];
	}

	private boolean isStrike(int rollIndex) {
		return rolls[rollIndex] == FRAME_MAX_POINTS;
	}

	private boolean isSpare(int rollIndex) {
		return framePoints(rollIndex) == FRAME_MAX_POINTS;
	}
	
}
