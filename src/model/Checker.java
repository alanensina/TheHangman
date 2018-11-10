package model;

import java.util.Random;
import java.util.Scanner;

public class Checker {
	Reaper reaper;
	private String word;
	private int errors = 0;
	private int letters;
	private char[] sortedWord;
	private char[] playersWord;
	Random r = new Random();
	private int level;
	boolean correctLetter = false; 
	boolean endGame = false; 
	Scanner input = new Scanner(System.in);
	int counter = 0;

	private String[] wordsLv1 = { "abstract", "continue", "for", "new", "switch", "assert", "default", "goto",
			"package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double", "implements",
			"protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return",
			"transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void",
			"class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while" };

	private String[] wordsLv2 = { "byte", "short", "int", "long", "float", "double", "char", "boolean", "enum",
			"void" };

	public Checker(int level, Reaper reaper) {
		this.reaper = reaper;
		if (level != 1 && level != 2) {
			this.level = 0;
		}
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public String[] getPalavrasNv1() {
		return wordsLv1;
	}

	public String[] getPalavrasNv2() {
		return wordsLv2;
	}

	public void selectWord() {

		if (getLevel() == 1) {
			this.word = wordsLv1[r.nextInt(49)];
			this.letters = word.length();
			sortedWord = new char[letters];
			playersWord = new char[letters];
			this.errors = 6;
		}

		else if (getLevel() == 2) {
			this.word = wordsLv2[r.nextInt(9)];
			this.letters = word.length();
			sortedWord = new char[letters];
			playersWord = new char[letters];
			this.errors = 5;
		} else {
			this.reaper.invalidLevel();
			System.exit(0);
		}
	}

	public String getWord() {
		return this.word;
	}

	public void arrayOrganizer() {

		// Filling the array of the word with _ for better visualization
		for (int x = 0; x < this.letters; x++) {
			playersWord[x] = '_';
		}

		// Putting the sorted word in an array to be compared
		for (int i = 0; i < letters; i++) {
			sortedWord[i] = this.word.charAt(i);
		}
	}

	public void startGame() {
		while (this.errors > 0) {
			this.checkBothArrays();

			if (endGame) {
				reaper.youWin();
				System.out.println(this.word);
				break;
			}

			this.counter = 0;

			reaper.typeALetter();

			this.checkingLetter(input.next().charAt(0));

			if (!correctLetter) {
				this.errors--;
				System.out.println("Que pena, a letra está incorreta.");
			}

			this.correctLetter = false; // Reseta a variável para o próximo laço.

			for (int n = 0; n < this.letters; n++) {
				System.out.print(playersWord[n] + " ");
			}
			System.out.println("");

			// Placar de erros
			if (this.getLevel() == 1) {
				System.out.println("Chances disponíveis: " + this.errors + "/6");
			} else {
				System.out.println("Chances disponíveis: " + this.errors + "/5");
			}
		}

		if (!endGame) { // Caso os erros cheguem a 6, o jogador perde.

			reaper.youLose();
			System.out.println(this.word);
		}

	}

	public void checkBothArrays() {
		// Verifica se o array da palavra sorteada está igual ao array que o jogador
		// preenche ao acertar uma letra
		for (int k = 0; k < this.letters; k++) {
			if (sortedWord[k] == playersWord[k]) {
				endGame = true;
			} else {
				endGame = false;
				break;
			}
		}
	}

	public void checkingLetter(char letter) {
		for (int x = 0; x < this.letters; x++) {
			if (letter == sortedWord[x]) {
				playersWord[x] = letter;
				correctLetter = true;
				reaper.correct();

			} else if (letter != sortedWord[x] && this.counter < this.letters) {
				counter++;
			}
		}
	}
}
