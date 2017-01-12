package com.nts.unittest.bowlinggame;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BowlingSimulator {
	private Scanner inputScanner;
	private PrintStream outputStream = new PrintStream(System.out);
	private Game game;
	private FrameState[] frameState = new FrameState[Game.NUMBER_OF_FRAMES + 1];

	public void startGame() {
		initGame();
		playGame();
		printEndGame();
	}


	private void playGame() {
		for (int frame = 1; frame <= Game.NUMBER_OF_FRAMES; frame++) {
			printScore();

			int frameScore = rollAndGetKnockDownPins(Game.ZERO); // first Roll

			if (isStrike(frameScore)) {
				strikeThis(frame);
				continue;
			}

			frameScore += rollAndGetKnockDownPins(frameScore); // second Roll

			if (isSpare(frameScore)) {
				spareThis(frame);
				continue;
			}

			endThis(frame);
		}
	}

	private void endThis(int frame) {
		frameState[frame] = FrameState.DONE;
	}

	private void spareThis(int frame) {
		printSpare();
		frameState[frame] = FrameState.SPARE;

		if (isTenFrame(frame)) {
			spareBonusRoll();
		}
	}

	private void strikeThis(int frame) {
		printStrike();
		frameState[frame] = FrameState.STRIKE;

		if (isTenFrame(frame)) {
			strikeBonusRoll();
		}
	}

	private void initGame() {
		this.game = new Game();
		Arrays.fill(frameState, FrameState.NOTDONE);
	}

	private int rollAndGetKnockDownPins(int frameScore) {
		int pins = nextValidPins(frameScore);
		game.roll(pins);

		return pins;
	}

	private boolean isTenFrame(int frame) {
		return frame == Game.NUMBER_OF_FRAMES;
	}

	private void printEndGame() {
		printScore();
		this.outputStream.println("\tEnd this Game!!");
	}

	private void strikeBonusRoll() {
		int frameScore = rollAndGetKnockDownPins(Game.ZERO); // first bonus roll

		if (isStrike(frameScore)) {
			printStrike();
			frameScore = Game.ZERO;
		}

		rollAndGetKnockDownPins(frameScore); // second bonus roll
	}

	private void spareBonusRoll() {
		int lastKnockDownPins = rollAndGetKnockDownPins(0);

		if (isStrike(lastKnockDownPins)) {
			printStrike();
		}
	}

	private void printScore() {
		outputStream.println(makeScoreString());
	}

	private void printSpare() {
		outputStream.println(makeSpareString());
	}

	private void printStrike() {
		outputStream.println(makeStrikeString());
	}

	private boolean isSpare(int frameScore) {
		return frameScore == Game.FRAME_MAX_POINTS;
	}

	private boolean isStrike(int pins) {
		return pins == Game.FRAME_MAX_POINTS;
	}

	private String makeSpareString() {
		return "\t  Good! Spare!!";
	}

	private String makeStrikeString() {
		return "\t  Wow!! Strike!!";
	}

	private String makeScoreString() {
		int[] rolls = game.getRolls();
		String frameString = "\n\tFrame   1\t2\t3\t4\t5\t6\t7\t8\t9\t10\n";
		String rollString =    "\troll    ";
		String scoreString =   "\tScore   ";

		int rollIndex = 0;
		for (int frame = 1; frame <= Game.NUMBER_OF_FRAMES; frame++) {
			if (frameState[frame] == FrameState.NOTDONE) {
				break;
			} else if (frameState[frame] == FrameState.STRIKE) {
				rollString += strikeString();
				rollIndex++;

				if (isTenFrame(frame)) {
					rollString += bonusRollOfStrikeString(rolls, rollIndex);
					scoreString += frameScore(frame);
					break;
				}

				if (ableCalculateStrike(frame)) {
					scoreString += frameScore(frame);
				}
			} else if (frameState[frame] == FrameState.SPARE) {
				rollString += spareString(rolls, rollIndex);
				rollIndex += 2;

				if (isTenFrame(frame)) {
					rollString += bonusRollOfSpareString(rolls, rollIndex);
					scoreString += frameScore(frame);
					break;
				}

				if (ableCalculateSpare(frame)) {
					scoreString += frameScore(frame);
				}
			} else {
				rollString += frameRollString(rolls, rollIndex);
				rollIndex += 2;

				scoreString += frameScore(frame);
			}
		}

		return frameString + rollString + "\n" + scoreString + "\n";
	}

	private String bonusRollOfSpareString(int[] rolls, int rollIndex) {
		if (isStrike(rolls[rollIndex])) {
			return "X";
		}

		return "" + rolls[rollIndex];
	}

	private String bonusRollOfStrikeString(int[] rolls, int rollIndex) {
		if (areStrikeAllBonusRolls(rolls, rollIndex)) {
			return "X\tX";
		}

		if (isStrike(rolls[rollIndex])) {
			return "X\t" + rolls[rollIndex + 1];
		}

		return rolls[rollIndex] + "\t" + rolls[rollIndex + 1];
	}

	private boolean areStrikeAllBonusRolls(int[] rolls, int rollIndex) {
		return isStrike(rolls[rollIndex]) && isStrike(rolls[rollIndex + 1]);
	}

	private String frameRollString(int[] rolls, int rollIndex) {
		return bonusRollOfSpareString(rolls, rollIndex) + "/"
				+ rolls[rollIndex + 1] + "\t";
	}

	private String spareString(int[] rolls, int rollIndex) {
		return bonusRollOfSpareString(rolls, rollIndex) + "//\t";
	}

	private String strikeString() {
		return "X\t";
	}

	private String frameScore(int frame) {
		return game.score(frame) + "\t";
	}

	private boolean ableCalculateSpare(int frame) {
		return frameState[frame + 1] != FrameState.NOTDONE;
	}

	private boolean ableCalculateStrike(int frame) {
		return frameState[frame + 1] == FrameState.DONE
				|| frameState[frame + 1] == FrameState.SPARE
				|| (frameState[frame + 1] == FrameState.STRIKE && (frame + 1 == 10 || frameState[frame + 2] != FrameState.NOTDONE));
	}

	private int nextValidPins(int frameScore) {
		int pins = -1;

		do {
			printValidPins(frameScore);

			try {
				pins = inputScanner.nextInt();
			} catch (InputMismatchException e) {
				printMismatchInput();
				this.inputScanner = new Scanner(System.in);
			}
		} while (isValidPins(frameScore, pins));

		return pins;
	}

	private void printMismatchInput() {
		outputStream.println("  Wrong input!! please input Integer value!!");
	}

	private void printValidPins(int frameScore) {
		outputStream.print("  Input your knock-down pins(0 ~ "
				+ (Game.FRAME_MAX_POINTS - frameScore) + ") : ");
	}

	private boolean isValidPins(int frameScore, int pins) {
		return pins + frameScore > Game.FRAME_MAX_POINTS || pins < 0;
	}

	public void setInputScanner(Scanner inputScanner) {
		this.inputScanner = inputScanner;
	}

	int score(int currentFrame) {
		return game.score(currentFrame);
	}

}
