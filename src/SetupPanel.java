import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetupPanel extends JPanel {

    private JTextField inputWidth, inputHeight, inputRndPoints;
    private Controller controller;

    public SetupPanel(int WIDTH, int HEIGHT, Controller controller) {
        this.controller = controller;
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        SpringLayout layout = new SpringLayout();
        setLayout(layout);


        JLabel titleLabel = new JLabel("Simulator");
        JLabel widthLabel = new JLabel("Input width:");
        JLabel heightLabel = new JLabel("Input height:");
        JLabel pointsLabel = new JLabel("Input points:");

        inputWidth = new JTextField(15);
        inputHeight = new JTextField(15);
        inputRndPoints = new JTextField(15);

        JButton showGuiButton = new JButton("Show map");
        JButton startSimulationButton = new JButton("Start simulation");

        showGuiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContentPanel parent = (ContentPanel) getParent();
                parent.showHideMap();
            }
        });

        startSimulationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.test();
            }
        });


        add(titleLabel);
        add(widthLabel);
        add(heightLabel);
        add(pointsLabel);
        add(inputWidth);
        add(inputHeight);
        add(inputRndPoints);
        add(showGuiButton);
        add(startSimulationButton);

        layout.putConstraint(SpringLayout.NORTH, titleLabel, 10, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titleLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);

        layout.putConstraint(SpringLayout.WEST, widthLabel, 10, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, widthLabel, 20, SpringLayout.SOUTH, titleLabel);

        layout.putConstraint(SpringLayout.WEST, inputWidth, 10, SpringLayout.EAST, widthLabel);
        layout.putConstraint(SpringLayout.BASELINE, inputWidth, 0, SpringLayout.BASELINE, widthLabel);

        layout.putConstraint(SpringLayout.WEST, heightLabel, 10, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, heightLabel, 10, SpringLayout.SOUTH, inputWidth);

        layout.putConstraint(SpringLayout.WEST, inputHeight, 10, SpringLayout.EAST, heightLabel);
        layout.putConstraint(SpringLayout.BASELINE, inputHeight, 0, SpringLayout.BASELINE, heightLabel);

        layout.putConstraint(SpringLayout.WEST, pointsLabel, 10, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, pointsLabel, 10, SpringLayout.SOUTH, inputHeight);

        layout.putConstraint(SpringLayout.WEST, inputRndPoints, 10, SpringLayout.EAST, pointsLabel);
        layout.putConstraint(SpringLayout.BASELINE, inputRndPoints, 0, SpringLayout.BASELINE, pointsLabel);

        layout.putConstraint(SpringLayout.NORTH, showGuiButton, 20, SpringLayout.SOUTH, pointsLabel);
        layout.putConstraint(SpringLayout.WEST, showGuiButton, 10, SpringLayout.WEST, this);

        layout.putConstraint(SpringLayout.NORTH, startSimulationButton, 10, SpringLayout.SOUTH, showGuiButton);
        layout.putConstraint(SpringLayout.WEST, startSimulationButton, 0, SpringLayout.WEST, showGuiButton);
    }
}