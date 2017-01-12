package com.nts.unittest.bowlinggame;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class BowlingSimulatorTest {

	private Scanner testInputScanner;
	private BowlingSimulator sut;

	@Before
	public void setUp() {
		sut = new BowlingSimulator();
	}

	@Test
	public void in_game_all_input_0_모든_입력이_0_일때_각각의_프레임에서의_점수계산()
			throws Exception {
		String allPointsZero = "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
		initUserInputString(allPointsZero);

		sut.startGame();

		assertAllFramesRollZero();
	}

	@Test
	public void in_game_all_input_1_모든_입력이_1_일때_각각의_프레임에서의_점수계산()
			throws Exception {
		String allPointsOne = "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1";
		initUserInputString(allPointsOne);

		sut.startGame();

		assertAllFrameRollOnePin();
	}

	@Test
	public void in_game_all_input_1_and_some_wrong_value_모든_입력이_1_인데_오류점수가_섞여있을경우()
			throws Exception {
		String allPointsOne = "1 10 1 11 1 11 -1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1";
		initUserInputString(allPointsOne);

		sut.startGame();

		assertAllFrameRollOnePin();
	}
	
	@Test
	public void in_game_one_spare_스페어_처리를_한번했을때() throws Exception {
		String allPointsOne = "5 5 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
		initUserInputString(allPointsOne);

		sut.startGame();

		assertEquals(13, sut.score(1));
		assertEquals(16, sut.score(2));
		assertEquals(16, sut.score(Game.NUMBER_OF_FRAMES));
	}
	
	@Test
	public void in_game_one_strike_스트라이크를_한번했을때() throws Exception {
		String allPointsOne = "10 3 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
		initUserInputString(allPointsOne);

		sut.startGame();

		assertEquals(17, sut.score(1));
		assertEquals(24, sut.score(2));
		assertEquals(24, sut.score(Game.NUMBER_OF_FRAMES));
	}
	
	@Test
	public void perpect_game_전부_스트라이크() throws Exception {
		String allPointsOne = "10 10 10 10 10 10 10 10 10 10 10 10";
		initUserInputString(allPointsOne);

		sut.startGame();

		assertEquals(300, sut.score(Game.NUMBER_OF_FRAMES));
	}

	private void initUserInputString(String allPointsZero) {
		testInputScanner = new Scanner(allPointsZero);
		sut.setInputScanner(testInputScanner);
	}

	private void assertAllFramesRollZero() {
		for (int frame = 1; frame <= Game.NUMBER_OF_FRAMES; frame++) {
			assertEquals(0, sut.score(frame));
		}
	}

	private void assertAllFrameRollOnePin() {
		for (int frame = 1; frame <= Game.NUMBER_OF_FRAMES; frame++) {
			assertEquals(frame * 2, sut.score(frame));
		}
	}
}
