import javax.swing.*;
import java.util.Random;

public class Main {


    static int WIDTH = 100;
    static int HEIGHT = 100;
    static int RND_POINTS = 50;
    static int SEED = 555;
    static double CONDITION = 0.0025;
    static double[][] temperature;


    public static void main(String[] args) {

        temperature = generateTemperatureMatrix();


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        Chart chart = new Chart(temperature);
        frame.add(chart);
        frame.pack();
        frame.setVisible(true);


        Thread compThread = new Thread(() -> {
            boolean stable = false;
            double CONDITION = 0.0025; // 0.25 degrees

            long start = System.currentTimeMillis();
            while (!stable) {
                stable = true;

                for (int i = 0; i < WIDTH; i++) {
                    for (int j = 0; j < HEIGHT; j++) {
                        if (temperature[i][j] == 1) continue;

                        double value = 0;
                        if (i > 0) value += temperature[i - 1][j];
                        if (i < WIDTH - 1) value += temperature[i + 1][j];
                        if (j > 0) value += temperature[i][j - 1];
                        if (j < HEIGHT - 1) value += temperature[i][j + 1];
                        value /= 4;

                        double diff = Math.abs(value - temperature[i][j]);
                        if (diff > CONDITION) {
                            stable = false;
                        }

                        temperature[i][j] = value;
                    }
                }

                if (!stable) {
                    chart.repaint();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("Done. Execution time: " + (end - start) + " ms");
        });
        compThread.start();
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