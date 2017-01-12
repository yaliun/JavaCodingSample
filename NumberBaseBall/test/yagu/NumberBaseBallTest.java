package yagu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import yagu.GameResult;
import yagu.NumberBaseBallGame;

public class NumberBaseBallTest {
	
	@Test
	public void nothing()
	{
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkOnlyNumber()
	{
		NumberBaseBallGame game = new NumberBaseBallGame();
		game.checkInvalidArgument("36a");
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkUniqueNumber()
	{
		NumberBaseBallGame game = new NumberBaseBallGame();
		game.checkInvalidArgument("366");
	}
	
	@Test
	public void guessGameResult()
	{
		NumberBaseBallGame game = new NumberBaseBallGame();
		GameResult result = game.guessGameResult("312");
		assertEquals("12", result.toString());

		GameResult result1 = game.guessGameResult("123");
		assertEquals("03", result1.toString());

		GameResult result2 = game.guessGameResult("395");
		assertEquals("21", result2.toString());

		GameResult result3 = game.guessGameResult("039");
		assertEquals("03", result3.toString());


		
		
	}

}
