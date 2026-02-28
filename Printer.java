
import java.util.*;

public class Printer {

    private Deque<String> printQueue;

    public Printer() {
        printQueue = new ArrayDeque<>();
    }

    public void addDoc(String document) {
        printQueue.addLast(document);
        System.out.println("Document added: " + document);
    }

    public void addUrgent(String document) {
        printQueue.addFirst(document);
        System.out.println("Urgent document added: " + document);
    }

    public void print() {
        if (printQueue.isEmpty()) {
            System.out.println("No documents to print.");
            return;
        }
        String document = printQueue.removeFirst();
        System.out.println("Printing: " + document);
    }

    public void cancelLast() {
        if (printQueue.isEmpty()) {
            System.out.println("No documents to cancel.");
            return;
        }
        String document = printQueue.removeLast();
        System.out.println("Document canceled: " + document);
    }

    public void showPending() {
        System.out.println("Pending documents: " + printQueue.size());
        for (String doc : printQueue) {
            System.out.println("- " + doc);
        }
    }

    public static void main(String[] args) {
        Printer printer = new Printer();

        printer.showPending();

        printer.addDoc("M1: The software development cycle");
        printer.addDoc("M1: SWEBOK");
        printer.addDoc("T2: Scrum concepts and Jira");
        printer.addDoc("M3: Stakeholders Table");
        printer.addUrgent("Data Structures in Java");
        printer.showPending();

        printer.print();

        printer.cancelLast();
        printer.showPending();

        printer.print();
        printer.showPending();
    }
}