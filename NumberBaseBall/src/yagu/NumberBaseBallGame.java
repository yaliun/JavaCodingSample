package yagu;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class NumberBaseBallGame {
	
	final String GAME_NUMBER = "390";

	public void checkInvalidArgument(String str) {
		
		boolean b = Pattern.matches("\\d{3}", str);	
		
		if (b)
		{
			Set<String> hs = new HashSet<String>();
			
			for(int i = 0; i < str.length(); i++)
			{
				hs.add(String.valueOf(str.charAt(i)));
			}
			
			if (hs.size() != str.length())
			{
				throw new IllegalArgumentException("숫자가 중복 되었습니다.");
			}
		}
		else
		{
			throw new IllegalArgumentException("입력값이 3자리 숫자가 아닙니다.");
		}
	}

	public GameResult guessGameResult(String str) {
		
		GameResult gr = new GameResult();
		
		int strike = 0;
		int ball = 0;
		int i = 0;
		
		char[] gameNumbers = GAME_NUMBER.toCharArray();
		
		for (char c:gameNumbers)
		{
			if (c == str.charAt(i))
			{
				strike++;
			}
			else
			{
				ball++;
			}
			i++;
		}
		
		gr.setStrike(strike);
		gr.setBall(ball);
		
		return gr;
		
	}

}
