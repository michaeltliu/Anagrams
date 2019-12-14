import java.io.IOException;
import java.util.*;

public class Solver {
    private ArrayList<String> letters;
    private Words words;

    public Solver(String input) throws IOException {
        String[] array = input.split("");
        letters = new ArrayList<>();
        for (String s : array) {
            letters.add(s);
        }
        words = new Words();
    }

    public ArrayList<String> solve() {
        // possibilities contains strings in the process of being built
        Queue<String> possibilities = new LinkedList<>();
        // remaining contains lists corresponding to each string in possibilities
        // each list contains the letters that still need to be added
        Queue<ArrayList<String>> remaining = new LinkedList<>();
        possibilities.add("");
        remaining.add(letters);

        // strings that are confirmed anagrams
        HashSet<String> anagrams = new HashSet<>();
        // phrases are added to this set once they use all available letters
        HashSet<String> completed = new HashSet<>();

        while (!remaining.isEmpty()) {
            ArrayList<String> list = remaining.remove();
            String phrase = possibilities.remove();

            if (words.isWord(phrase) && phrase.length() > 2) anagrams.add(phrase);
            for (int i = 0; i < list.size(); i ++) {
                ArrayList<String> copy = new ArrayList<>(list);
                String add = copy.remove(i);
                if (!copy.isEmpty()) {
                    possibilities.add(phrase + add);
                    remaining.add(copy);
                }
                else {
                    completed.add(phrase + add);
                }
            }
        }

        // tests strings that used all available letters to see if they are real words
        for (String phrase : completed) {
            if (words.isWord(phrase)) anagrams.add(phrase);
        }

        ArrayList<String> ret = new ArrayList(anagrams);

        // sorts the anagrams by descending length to maximize my SCOREEEE
        ret.sort(Comparator.comparingInt(String::length).reversed());
        return ret;
    }
}
