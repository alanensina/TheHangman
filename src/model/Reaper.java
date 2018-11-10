package model;

public class Reaper {

	private Player player;

	public Reaper(Player player) {
		this.player = player;
	}

	public Reaper() {

	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	// Introduction
	public void phrase1() {
		System.out.println(
				"Olá. Seja bem-vindo ao Jogo da Forca dos Javeiros.\nNesse jogo seu objetivo é adivinhar qual a palavra reservada do Java sorteada.");
		System.out.println(
				"\nMas antes, ainda não fomos apresentados um ao outro.\nEu sou o Ceifador. Minha missão é levá-lo a forca, já o seu é adivinhar a palavra e fugir desse destino trágico.");
		System.out.println("Qual o seu nome?");
	}

	public void phrase2() {
		System.out.println(
				"OK e você é de onde? Bom, preciso saber para poder levar o seu corpo para seus familiares caso você perca.\nQual sua cidade natal?");
	}

	public void phrase3() {
		System.out
				.println("Ahh " + player.getCity() + ", tenho um amigo que mora lá. Fique tranquilo " + player.getName()
						+ ", enviarei seu caixão em segurança e ele fará o serviço de comunicar seus parentes.");
	}

	public void phrase4() {
		System.out.println(
				"Vamos as regras:\n- No nível 1, Serão 50 possíveis palavras e você terá 6 tentativas.\n- No nível 2, são apenas 10 palavras relacionadas aos tipos primitivos e operadores. Porém são 5 tentativas.\nVamos lá, agora selecione o nível do jogo que deseja jogar, digite 1 ou 2:");
	}

	public void phrase5() {
		System.out.println("Ok. Vamos começar!");
	}

	// Default message if the player choose a wrong level.
	public void invalidLevel() {
		System.out.println(
				"Jogo encerrado, pois você não selecionou nenhuma das opções disponíveis que era 1 e 2.\nPor desrespeitar as regras, levarei seu corpo para "
						+ player.getCity() + " mesmo sem você ter jogado.");
	}

	// End game, you win!
	public void youWin() {
		System.out.println("Fim de jogo, você venceu. Sua alma está a salvo. A palavra certa é: ");
	}

	public void youLose() {
		System.out.println("HAHAHAHAHA você perdeu. Diga adeus a sua vida. A palavra correta é: ");
	}

	// Type a letter.
	public void typeALetter() {
		System.out.println("Digite uma letra: ");
	}

	public void correct() {
		System.out.println("Muito bem, a letra está correta.");
	}

}
