package gh2;
import deque.LinkedListDeque;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static final double CONCERT_Q = 110.0;

    public static void main(String[] arguments){
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        LinkedListDeque<GuitarString> playList = new LinkedListDeque<>();

        for (int i = 0; i < 37; i++) {
            double number = 440*Math.pow(2,(i-24.0)/12.0);
            GuitarString addIn = new GuitarString(number);
            playList.addLast(addIn);
        }



        while (true){
            double sample = 0;
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int i = keyboard.indexOf(key);
                playList.get(i).pluck();
                sample = 0;
                for (int j = 0; j < 37; j++) {
                    sample += playList.get(i).sample();
                }
            }

            StdAudio.play(sample);

            for (int i = 0; i < 37; i++) {
                playList.get(i).tic();
            }
        }


    }
}
