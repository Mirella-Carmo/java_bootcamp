public class App {
    public static void main(String[] args){    
        MusicPlayer musicPlayer = new Computer();
        runMusic(musicPlayer);
        runVideo(new Computer());
    }
    public static void runVideo(VideoPlayer videoPlayer){
            videoPlayer.playVideo();
    }
    public static void runMusic(MusicPlayer musicPlayer){
            musicPlayer.playMusic();
    }
    
}
//var music1 = new MusicPlayer(); //!ERRADO. Como é abstrata não instancia
//* Para instanciar tem que ter uma interface anônima