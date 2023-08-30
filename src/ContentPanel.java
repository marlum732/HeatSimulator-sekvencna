import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {

    private SetupPanel setupPanel;
    private Chart chart;
    private boolean mapVisible = true;
    private double[][] temperature;



    public ContentPanel(int WIDTH, int HEIGHT, double[][] temperature) {
        this.temperature = temperature;
        this.setLayout(new BorderLayout());

        setupPanel = new SetupPanel(300, 500);
        this.add(setupPanel, BorderLayout.CENTER);

        chart = new Chart(temperature);
        chart.setVisible(mapVisible);
        this.add(chart, BorderLayout.EAST);

    }


    public void showHideMap() {
        mapVisible = !mapVisible;
        chart.setVisible(mapVisible);

        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

        if (mapVisible) {
            chart.setPreferredSize(new Dimension(600, chart.getHeight()));
        } else {
            chart.setPreferredSize(new Dimension(0, chart.getHeight()));
        }

        revalidate();
        repaint();

        if (parentFrame != null) {
            parentFrame.pack();
        }

    }

    public Chart getChart() {
        return chart;
    }
}