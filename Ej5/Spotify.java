package Ej5;

public class Spotify implements  OnlineMusicPlayer{

    @Override
    public void stream() {
        System.out.println("Streaming music on Spotify");
    }

    @Override
    public void play() {
        System.out.println("Esta Reproduciendo");
    }

    @Override
    public void stop() {
        System.out.println("Se ha parado Spotify");
    }
}
