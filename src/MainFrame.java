import javax.swing.*;

public class MainFrame extends JFrame {

    private ContentPanel contentPanel;
    private double[][] temperature;


    public MainFrame(double[][] temperature) {
        this.temperature= temperature;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        contentPanel = new ContentPanel(300, 500, temperature);
        this.add(contentPanel);

        this.pack();
        this.setVisible(true);
    }

    public Chart getChart() {
        return contentPanel.getChart();
    }

}