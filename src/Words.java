import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Words {
    private static HashSet<String> words;

    public Words() throws FileNotFoundException {
        File dictionary = new File("C:\\Users\\liumi\\Downloads\\usa2\\usa2.txt");
        Scanner scan = new Scanner(dictionary);
        words = new HashSet<>();
        while (scan.hasNextLine()) {
            String word = scan.nextLine();
            words.add(word);
        }
    }

    public static boolean isWord(String w) {
        return words.contains(w);
    }
}
