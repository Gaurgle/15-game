import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class Audio implements LineListener {

    private Clip clip;

    public Audio(String fileName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("audio/" +fileName);
        if (inputStream == null) {
            throw new UnsupportedAudioFileException("Audiofile " + fileName +" not found.");
        }

        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream)) {
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(this);
            clip.open(audioInputStream);

        }
    }

    public void play(){
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void stop(){
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    @Override
    public void update(LineEvent event){
        if (event.getType() == LineEvent.Type.STOP) {
            clip.stop();
        }
    }
}
