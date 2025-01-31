package EjGamer;

public class EsportsTournament {
    public static void main(String[] args) {
        Gamer fps = new FPSGamer();
        Gamer mobaGamer = new MOBAGamer();
        Gamer sportsGamer = new SportsGamer();
        Gamer[] gamers = new Gamer[]{fps, mobaGamer, sportsGamer};
        startTournament(gamers);
    }
    public static void startTournament(Gamer[] jugadores){

        for (Gamer g : jugadores){
            g.playGame();
        }
    }
}
