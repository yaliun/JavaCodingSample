package com.nts.unittest.bowlinggame;

import java.io.PrintStream;
import java.util.Scanner;

public class PlayGameInvoker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PrintStream printStream = new PrintStream(System.out);
		BowlingSimulator bowlingSimulator = new BowlingSimulator();
		bowlingSimulator.setInputScanner(scanner);

		printStream.print("\t\tPlay Bowling!!\n\t  게임을 하려면 아무거나 입력하세요.\n\t  그만하고 싶다면 exit를 입력하세요.\n\t");

		while (true) {
			String command = scanner.next();

			if (command.equalsIgnoreCase("exit")) {
				break;
			}

			bowlingSimulator.startGame();

			printStream.print("\t\t계속 하겠다면 아무키나 입력하세요. 그만두고 싶다면 exit를 입력하세요.\n\t");
		}
	}
}
