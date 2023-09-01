
public class Main {



    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.generateData();

        MainFrame mainFrame = new MainFrame(controller);


      ComputationThread computationThread = new ComputationThread(controller);
      computationThread.start();

      controller.setMainFrame(mainFrame);
      controller.setComputationThread(computationThread);
    }



}