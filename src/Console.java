import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the 6 letters one after another. Do not separate them with a delimiter.");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Solver solver = new Solver(input);
        System.out.println(solver.solve());
    }
}
