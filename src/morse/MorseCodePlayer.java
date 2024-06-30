package morse;

import javax.sound.sampled.*;
import java.io.IOException;

public class MorseCodePlayer {

    // Параметры звука
    private static final int DOT = 100; // Длительность точки (миллисекунды)
    private static final int DASH = DOT * 3; // Длительность тире
    private static final int FREQ = 800; // Частота сигнала

    // Генерация звука для точки или тире
    private static void playTone(SourceDataLine sdl, int duration) throws LineUnavailableException {
        byte[] buf = new byte[1];
        for (int i = 0; i < duration * 8; i++) {
            sdl.write(new byte[]{(byte) (Math.sin(i / (8000F / FREQ) * 2.0 * Math.PI) * 127.0)}, 0, 1);
        }
        sdl.drain();
    }

    // Воспроизведение строки кода Морзе
    public static void soundMorse(String morseCode) throws IOException, LineUnavailableException {
        try (SourceDataLine sdl = AudioSystem.getSourceDataLine(new AudioFormat(8000F, 8, 1, true, false))) {
            sdl.open(sdl.getFormat());
            sdl.start();

            for (char note : morseCode.toCharArray()) {
                switch (note) {
                    case '.':
                        playTone(sdl, DOT);
                        break;
                    case '-':
                        playTone(sdl, DASH);
                        break;
                    default:
                        continue;
                }
                // Пауза между элементами
                try {
                    Thread.sleep(DOT / 3);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread was interrupted, Failed to complete operation");
                }
            }
        }
    }
}
