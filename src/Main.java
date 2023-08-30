import javax.swing.*;
import java.util.Random;

public class Main {


    static int WIDTH = 200;
    static int HEIGHT = 200;
    static int RND_POINTS = 200;
    static int SEED = 555;
    static double CONDITION = 0.0025;
    static boolean chartVisible = true;
    static double[][] temperature;

    public static void main(String[] args) {

        temperature = generateTemperatureMatrix();

        MainFrame mainFrame = new MainFrame(temperature);


      ComputationThread computationThread = new ComputationThread(temperature, CONDITION, chartVisible, mainFrame.getChart());
      computationThread.start();
    }


    static double[][] generateTemperatureMatrix() {
        Random random = new Random(SEED);
        double[][] t = new double[WIDTH][HEIGHT];
        int x, y;
        for (int i = 0; i < RND_POINTS; i++) {
            x = random.nextInt(WIDTH);
            y = random.nextInt(HEIGHT);
            t[x][y] = 1;
        }
        return t;
    }
}