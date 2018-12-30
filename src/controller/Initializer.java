package controller;

import java.util.Scanner;

import model.Checker;
import model.Player;
import model.Reaper;

public class Initializer {
	
	public Initializer() {}
	
	public static void start() {
		Scanner input = new Scanner(System.in);
		Reaper reaper = new Reaper();

		reaper.phrase1();

		String name = input.nextLine();

		reaper.phrase2();

		String city = input.nextLine();

		Player player = new Player(name, city);
		reaper.setPlayer(player);

		reaper.phrase3();
		reaper.phrase4();

		Checker checker = new Checker(input.nextInt(), reaper);

		checker.selectWord();
		checker.arrayOrganizer();
		reaper.phrase5();
		
		checker.startGame();		

		input.close();
	}

}
