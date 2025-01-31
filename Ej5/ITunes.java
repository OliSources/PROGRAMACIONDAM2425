package Ej5;

public class ITunes implements  OfflineMusicPlayer{
    @Override
    public void load() {
        System.out.println("Loading music on iTunes");
    }

    @Override
    public void play() {
        System.out.println("Esta Reproduciendo");
    }

    @Override
    public void stop() {
        System.out.println("Se ha parado la reproduccion de iTunes");
    }
}
