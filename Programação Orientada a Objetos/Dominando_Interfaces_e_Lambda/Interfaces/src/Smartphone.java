public class Smartphone implements VideoPlayer, MusicPlayer{

    @Override
    public void pauseVideo() {
        System.err.println("O smartphone está pausando o video");        
    }

    @Override
    public void playVideo() {
        System.err.println("O smartphone está transmitindo o video");        
        
    }

    @Override
    public void stopVideo() {
        System.err.println("O smartphone está parando o video");        

        
    }

    @Override
    public void pauseMusic() {
        System.err.println("O smartphone está pausando a musica");        
        
    }

    @Override
    public void playMusic() {
        System.err.println("O smartphone está tocando a musica");        
        
    }

    @Override
    public void stopMusic() {
        System.err.println("O smartphone está parando a musica");        
        
    }

}
