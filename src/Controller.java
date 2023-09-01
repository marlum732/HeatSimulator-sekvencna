import java.util.Random;

public class Controller {
    private int WIDTH = 200;
    private int HEIGHT = 200;
    private int RND_POINTS = 200;
    private int SEED = 555;
    private boolean chartVisible = true;
    private double[][] temperature;

    private MainFrame mainFrame;
    private ComputationThread computationThread;

    public Controller(){


    }


    private double[][] generateTemperatureMatrix() {
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

    public void generateData(){
        temperature = generateTemperatureMatrix();
    }

    public boolean isChartVisible(){
        return chartVisible;
    }


    public void test() {
        computationThread.setRunning(!computationThread.isRunning());
    }

    public void repaintChart(){
        mainFrame.getChart().repaint();
    }


    public double[][] getTemperature() {
        return temperature;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setComputationThread(ComputationThread computationThread) {
        this.computationThread = computationThread;
    }
}
