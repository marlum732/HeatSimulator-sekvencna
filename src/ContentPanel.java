import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {

    private SetupPanel setupPanel;
    private Chart chart;
    private boolean mapVisible = true;



    public ContentPanel(int WIDTH, int HEIGHT) {
        this.setLayout(new BorderLayout());

        setupPanel = new SetupPanel(300, 500);
        this.add(setupPanel, BorderLayout.CENTER);

        chart = new Chart(Main.generateTemperatureMatrix());
        chart.setVisible(mapVisible);
        this.add(chart, BorderLayout.EAST);

    }


    public void showHideMap() {
        mapVisible = !mapVisible;

    }
}