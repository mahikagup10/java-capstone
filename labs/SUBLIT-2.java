public class SUBLIT-2 {
    
}

import java.util.Scanner;

class Mainclass{
        public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String genre = scanner.next();
            String name = scanner.next();
            String attribute = scanner.next();

            if (genre.equals("shooter")) {
                Shooter shooter = new Shooter(name, genre, attribute);
                shooter.play();
            } else if (genre.equals("strategy")) {
                int playerCount = Integer.parseInt(attribute);
                Strategy strategy = new Strategy(name, genre, playerCount);
                strategy.play();
            } else {
                Game game = new Game(name, genre);
                game.play();
            }
        }
    }
}

class Game{
    protected String name;
    protected String genre;

    Game(String name, String genre){
        this.name = name;
        this.genre = genre;
    }

    void play(){
        System.out.println("The"+genre+"game"+name+"is being played");
    }
}

class Shooter extends Game{
    private String platform;

    Shooter(String platform){
        super();
        this.platform = platform;
    }
    @Override
    void play(){
        System.out.println("The"+genre+name+"game on"+platform+"is being played");
    }

}

class Strategy extends Game{
    private int playercount;

    Strategy(String platform){
        super();
        this.playercount = playercount;
    }

    @Override
    void play(){
        System.out.println("The"+genre+name+"game for"+playercount+"players is being played");
    }
}