package Ej5;

public class MusicApp {
    public static void main(String[] args) {
        MusicPlayer[] players = new MusicPlayer[]{new Spotify(), new ITunes(), new MP3Player()};
        MusicApp app = new MusicApp();
        app.startMusic(players);
    }

    public void startMusic(MusicPlayer[] player) {
        for (MusicPlayer m : player) {
            m.play();
            if (m instanceof OnlineMusicPlayer o) {
                o.stream();
            }
            if (m instanceof OfflineMusicPlayer of) {
                 of.load();
            }
         m.stop();
        }
    }
}
