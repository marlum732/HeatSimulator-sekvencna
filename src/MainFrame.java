import javax.swing.*;

public class MainFrame extends JFrame {



    public MainFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        ContentPanel contentPanel = new ContentPanel(300, 500);
        this.add(contentPanel);

        this.pack();
        this.setVisible(true);
    }


    public static void main(String[] args) {


        new MainFrame();


    }




}