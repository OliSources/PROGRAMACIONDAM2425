package Ej5;

public class MP3Player implements OfflineMusicPlayer{
    @Override
    public void play() {
        System.out.println("Playing music on MP3 Player");
    }

    @Override
    public void load() {
        System.out.println("Reproducioendo MP3 Player");
    }

    @Override
    public void stop() {
        System.out.println("Se Ha parado MP3 Player");
    }
}
