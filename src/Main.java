import java.util.Random;

public class Main {



    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.generateData();


        MainFrame mainFrame = new MainFrame(controller.getTemperature(), controller);


      ComputationThread computationThread = new ComputationThread(controller.getTemperature(), controller);
      computationThread.start();

      controller.setMainFrame(mainFrame);
      controller.setComputationThread(computationThread);
    }



}