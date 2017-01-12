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
				throw new IllegalArgumentException("���ڰ� �ߺ� �Ǿ����ϴ�.");
			}
		}
		else
		{
			throw new IllegalArgumentException("�Է°��� 3�ڸ� ���ڰ� �ƴմϴ�.");
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
