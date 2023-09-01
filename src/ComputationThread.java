public class ComputationThread extends Thread {

    private final int WIDTH;
    private final int HEIGHT;
    private final double[][] temperature;
    private final Controller controller;
    private boolean isRunning = false;
    private double CONDITION = 0.0025;


    public ComputationThread(double[][] temperature, Controller controller) {
        this.WIDTH = temperature.length;
        this.HEIGHT = temperature[0].length;
        this.temperature = temperature;
        this.controller=controller;
    }


    @Override
    public void run() {
        while (!isRunning){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boolean stable = false;

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
            if (!stable && controller.isChartVisible()) {
                controller.repaintChart();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start) + " ms");
    }


    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}