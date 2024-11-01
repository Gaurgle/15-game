import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class Audio implements LineListener {

    private Clip themeSong;

    public Audio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("audio/Game15_1.0.wav");
        if (inputStream == null) {
            throw new UnsupportedAudioFileException("Audiofile not found.");
        }

        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream)) {
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            themeSong = (Clip) AudioSystem.getLine(info);
            themeSong.addLineListener(this);
            themeSong.open(audioInputStream);

        }

        themeSong.start();

    }

    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP) {
            themeSong.stop();
        }
    }
}
