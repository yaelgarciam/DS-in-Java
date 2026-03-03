import java.util.ArrayList;
import java.util.List;

public class ServerErrorLog {

    private static final int MAX_SIZE = 10000;
    private List<String> log = new ArrayList<>();

    public void addError(String error) {
        log.add(error);

        if (log.size() > MAX_SIZE) {
            log.remove(0); 
        }
    }

    public void printLog() {
        for (String error : log) {
            System.out.println(error);
        }
    }

    public static void main(String[] args) {
        ServerErrorLog errorLog = new ServerErrorLog();


        for (int i = 1; i <= 10005; i++) {
            errorLog.addError("Error " + i);
        }

        errorLog.printLog();

        System.out.println("First 5 errors:");
        for (int i = 0; i < 5; i++) {
            System.out.println(errorLog.log.get(i));
        }
    }

}