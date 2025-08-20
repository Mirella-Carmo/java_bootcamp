public class MusicBox implements MusicPlayer {

    @Override
    public void pauseMusic() {
        System.err.println("A Caixa de som está pausando a musica");        
        
    }

    @Override
    public void playMusic() {
        System.err.println("A caixa de som está tocando a musica");        
        
    }

    @Override
    public void stopMusic() {
        System.err.println("A caixa de som está parando a musica");        
        
    }

}
