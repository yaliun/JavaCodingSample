package com.nts.unittest.bowlinggame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/*
 * 
 * @author SeokJong.Gwak
 *
 */
public class GameTest {

	private Game game;

	@Before
	public void setUp() {
		game = new Game();
	}
	
	@Test
	public void should_return_0_when_every_roll_is_gutter() throws Exception {
		rollBalls(0, 20);

		assertEquals(0, this.game.score());
	}

	@Test
	public void every_roll_is_1_point() throws Exception {
		rollBalls(1, 20);

		assertEquals(20, this.game.score());
	}
	
	@Test
	public void spare_one_frame() throws Exception {
		rollSpare(); //spare
		game.roll(3);
		
		rollBalls(0, 17);
		
		assertEquals(16, game.score());
	}
	
	@Test
	public void strike_one_frame() throws Exception {
		rollStrike();
		game.roll(3);
		game.roll(4);
		
		rollBalls(0, 16);
		
		assertEquals(24, game.score());
	}
	
	@Test
	public void first_roll_0_second_roll_10_한개도못친후_스페어처리() throws Exception {
		game.roll(0);
		game.roll(10);
		game.roll(4);
		
		rollBalls(0, 17);
		
		assertEquals(18, game.score());
	}
	
	@Test
	public void strike_one_frame_next_frame_spare_스트라이크친뒤_스페어처리() throws Exception {
		rollStrike();
		rollSpare();
		game.roll(5);
		
		rollBalls(0, 15);
		
		assertEquals(40, game.score());
	}
	
	@Test
	public void perpect_game_전부스트라이크() throws Exception {
		rollBalls(10, 12);
		
		assertEquals(300, game.score());
	}

	private void rollStrike() {
		game.roll(10);
	}

	private void rollSpare() {
		game.roll(5);
		game.roll(5);
	}

	private void rollBalls(int pins, int rolls) {
		for (int i = 0; i < rolls; i++) {
			this.game.roll(pins);
		}
	}
}
