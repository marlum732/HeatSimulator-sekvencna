import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Chart extends JComponent {

    private final int TILE_SIZE = 5;
    private final int N_TILES;
    private final int GRID_WIDTH;
    private final int GRID_HEIGHT;

    private double[][] temperature;


    public Chart(double[][] temperature) {
        this.N_TILES = temperature.length;
        this.GRID_WIDTH = TILE_SIZE * N_TILES;
        this.GRID_HEIGHT = TILE_SIZE * temperature[0].length;
        this.setPreferredSize(new Dimension(GRID_WIDTH,GRID_HEIGHT));
        this.temperature = temperature;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        //first picture than grid


        paintHeatMap(g2d);
        drawGrid(g2d);
    }



    private void drawGrid(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        for (int i = 1; i <= N_TILES; i++) {
            int position = i * TILE_SIZE;
            g2d.drawLine(position, 0, position, GRID_HEIGHT);
            g2d.drawLine(0, position,GRID_WIDTH, position);
        }
    }



    private void paintHeatMap(Graphics2D g2d) {
        double min = 0.0; // blue
        double max = 1.0; // red

        BufferedImage bufferedImage = new BufferedImage(GRID_WIDTH, GRID_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D bufferedImageGraphics = (Graphics2D) bufferedImage.getGraphics();
        for (int i = 0; i < temperature.length; i++) {
            for (int j = 0; j < temperature[0].length; j++) {
                double temp = temperature[i][j];
                float hue = (float) (0.66 * (1 - (temp - min) / (max - min)));
                int rgb = Color.HSBtoRGB(hue, 1.0f, 1.0f);

                bufferedImageGraphics.setColor(new Color(rgb));
                bufferedImageGraphics.fillRect(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
        g2d.drawImage(bufferedImage, 0, 0,GRID_WIDTH, GRID_HEIGHT, null);
    }

}