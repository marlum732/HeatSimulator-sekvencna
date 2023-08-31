public class Controller {

    private MainFrame mainFrame;
    private ComputationThread computationThread;

    public Controller(){



    }

    public void test() {
        computationThread.setRunning(!computationThread.isRunning());
    }



    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setComputationThread(ComputationThread computationThread) {
        this.computationThread = computationThread;
    }
}
