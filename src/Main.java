import javax.swing.*;
import java.util.Random;

public class Main {


    static int WIDTH = 100;
    static int HEIGHT = 100;
    static int RND_POINTS = 5;
    static int SEED = 555;
    static double CONDITION = 0.0025;
    static boolean chartVisible = true;
    static double[][] temperature;
    static Chart chart;


    public static void main(String[] args) {

        temperature = generateTemperatureMatrix();

    if(chartVisible) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        chart = new Chart(temperature);
        frame.add(chart);
        frame.pack();
        frame.setVisible(true);
    }

      ComputationThread computationThread = new ComputationThread(temperature, CONDITION, chartVisible, chart);
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