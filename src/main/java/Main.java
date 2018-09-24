import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner read = new Scanner(new File("in69.txt"));
        PrintWriter writer = new PrintWriter("out.txt");

        while (read.hasNextLine()){
            String line = read.nextLine();
            Parser parser = new Parser(line);
            Expression expressionTree = parser.parse();
            long result = expressionTree.calculate();
            writer.println(result);
        }

        writer.close();
    }
}