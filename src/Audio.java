import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class Audio implements LineListener {

    private Clip clip;

    public Audio(String fileName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("audio/" + fileName);
        if (inputStream == null) {
            throw new UnsupportedAudioFileException("Audio file " + fileName + " not found.");
        }

        try (AudioInputStream originalStream = AudioSystem.getAudioInputStream(inputStream)) {
            AudioFormat baseFormat = originalStream.getFormat();
            AudioFormat compatibleFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false
            );

            // Convert the audio stream to a compatible format
            AudioInputStream convertedStream = AudioSystem.getAudioInputStream(compatibleFormat, originalStream);

            DataLine.Info info = new DataLine.Info(Clip.class, compatibleFormat);
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(this);
            clip.open(convertedStream);

        }
    }

    public void play() {
        if (clip != null) {
            clip.setFramePosition(0); // Start from the beginning
            clip.start();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP) {
            clip.stop();
        }
    }
}
