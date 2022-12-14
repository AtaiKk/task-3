import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    User user = new User();
    Computer computer = new Computer();
    static int userScore = 0;
    static int computerScore = 0;
    static int draw = 0;
    static int numberOfGames = 0;

    public static void startFirstGame() {
        MoveForFirstGame userMove = User.getMoveForFirstGame();
        MoveForFirstGame computerMove = Computer.getMoveForFirstGame();
        System.out.println("\nВаш ход  " + userMove + ".");
        System.out.println("Ход компьютера  " + computerMove + ".\n");

        if ((userMove.equals(MoveForFirstGame.ROCK) && computerMove.equals(MoveForFirstGame.PAPER)) || (userMove.equals(MoveForFirstGame.PAPER) && computerMove.equals(MoveForFirstGame.SCISSORS)) ||
                (userMove.equals(MoveForFirstGame.SCISSORS) && computerMove.equals(MoveForFirstGame.ROCK))) {
            System.out.println("Компьютер победил");
            computerScore++;
        } else if ((userMove.equals(MoveForFirstGame.PAPER) && computerMove.equals(MoveForFirstGame.ROCK)) || (userMove.equals(MoveForFirstGame.SCISSORS) && computerMove.equals(MoveForFirstGame.PAPER)) ||
                (userMove.equals(MoveForFirstGame.ROCK) && computerMove.equals(MoveForFirstGame.SCISSORS))) {
            System.out.println("Вы победили");
            userScore++;
        } else {
            draw++;
            System.out.println("Ничья");
        }
        numberOfGames++;
    }

        public static void startSecondGame(){
        Move userMove = User.getMoveForSecondGame();
        Move computerMove = Computer.getMoveForSecondGame();
        System.out.println("\nВаш ход  " + userMove + ".");
        System.out.println("Ход компьютера  " + computerMove + ".\n");

        if((userMove.equals(Move.SPOCK) && computerMove.equals(Move.LIZARD)) ||
                (userMove.equals(Move.PAPER) && computerMove.equals(Move.LIZARD)) ||
                (userMove.equals(Move.SCISSORS) && computerMove.equals(Move.SPOCK))||
                (userMove.equals(Move.ROCK) && computerMove.equals(Move.SPOCK))||
                (userMove.equals(Move.ROCK) && computerMove.equals(Move.PAPER)) ||
                (userMove.equals(Move.SPOCK) && computerMove.equals(Move.PAPER)) ||
                (userMove.equals(Move.PAPER) && computerMove.equals(Move.SCISSORS)) ||
                (userMove.equals(Move.LIZARD) && computerMove.equals(Move.SCISSORS)) ||
                (userMove.equals(Move.SCISSORS) && computerMove.equals(Move.ROCK)) ||
                (userMove.equals(Move.LIZARD) && computerMove.equals(Move.ROCK))){
            System.out.println("Компьютер победил");
            computerScore++;
        }else if((userMove.equals(Move.LIZARD) && computerMove.equals(Move.SPOCK)) ||
                (userMove.equals(Move.LIZARD) && computerMove.equals(Move.PAPER)) ||
                (userMove.equals(Move.SPOCK) && computerMove.equals(Move.ROCK))||
                (userMove.equals(Move.SPOCK) && computerMove.equals(Move.SCISSORS))||
                (userMove.equals(Move.PAPER) && computerMove.equals(Move.ROCK)) ||
                (userMove.equals(Move.PAPER) && computerMove.equals(Move.SPOCK)) ||
                (userMove.equals(Move.SCISSORS) && computerMove.equals(Move.PAPER)) ||
                (userMove.equals(Move.SCISSORS) && computerMove.equals(Move.LIZARD)) ||
                (userMove.equals(Move.ROCK) && computerMove.equals(Move.SCISSORS)) ||
                (userMove.equals(Move.ROCK) && computerMove.equals(Move.LIZARD))){
            System.out.println("Вы победили");
            userScore++;
        }else {
            draw++;
            System.out.println("Ничья");
        }
        numberOfGames++;
    }
    public static void allGameForFirstGame() {
        Scanner s = new Scanner(System.in);
        System.out.println("Хотите ли вы сыграть ещё раз?(Y/N)");
        String answer = null;
        try {
            answer = s.nextLine();
        } catch (ArithmeticException e) {
            System.out.println("Вы ввели не коректные данные,попробуйте ещё раз");
            allGameForFirstGame();
        }
        String correctAnswer = answer.toUpperCase();
        switch (correctAnswer) {
            case "Y":
                startFirstGame();
                allGameForFirstGame();
            case "N":
                break;
            default:
                System.out.println("Вы ввели не коректные данные,попробуйте ещё раз");
                allGameForFirstGame();
        }
    }

    public static void allGameForSecondGame() {
        Scanner s = new Scanner(System.in);
        System.out.println("Хотите ли вы сыграть ещё раз?(Y/N)");
        String answer = null;
        try {
            answer = s.nextLine();
        } catch (ArithmeticException e) {
            System.out.println("Вы ввели не коректные данные,попробуйте ещё раз");
            allGameForSecondGame();
        }
        String correctAnswer = answer.toUpperCase();
        switch (correctAnswer) {
            case "Y":
                startSecondGame();
                allGameForSecondGame();
            case "N":
                break;
            default:
                System.out.println("Вы ввели не коректные данные,попробуйте ещё раз");
                allGameForSecondGame();
        }
    }

    public static void printGame(){
        int winRate = (userScore*100) / numberOfGames;
        System.out.println("+------------------------------------------------------+");
        System.out.println("| ПОБЕД | ПОРАЖЕНИЙ | НИЧЬИ | ВСЕГО ИГР | ПРОЦЕН ПОБЕД |");
        System.out.printf("|%-7s|%-11s|%-7s|%-11s|%-14s|\n", userScore, computerScore, draw, numberOfGames, winRate);
        System.out.println("+------------------------------------------------------+");
    }

    public static void chooseGame(){
        System.out.println("1 - легкий\n2 - усложненный\n");
        System.out.print("Выберите режим игры: ");
        Scanner s = new Scanner(System.in);
        int answer = 0;
        try {
            answer = s.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Вы ввели не коректные данные, попробуйте ещё раз");
            chooseGame();
        }
        switch (answer){
            case 1:
                startFirstGame();
                allGameForFirstGame();
                printGame();
                break;
            case 2:
                startSecondGame();
                allGameForSecondGame();
                printGame();
                break;
            default:
                System.out.println("Вы выбрали не существующие данные, попробуйте ещё раз");
                chooseGame();
        }
    }
}
