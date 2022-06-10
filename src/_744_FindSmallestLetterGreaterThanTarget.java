import javax.sound.midi.Soundbank;
import java.time.OffsetDateTime;

/**
 * @author Diyang Li
 * @create 2022-06-09 10:09 AM
 */
public class _744_FindSmallestLetterGreaterThanTarget {
    /**
     * my method, fit the template of binary search
     *
     * @param letters
     * @param target
     * @return
     */
    public static char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }

        int start = 0;
        int end = letters.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            char midChar = letters[mid];
            if (letters[mid] <= target && letters[mid + 1] > target) {
                return letters[mid + 1];
            } else if (letters[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (letters[mid] > target) {
            return letters[mid];
        } else {
            return letters[mid + 1];
        }
    }


    /**
     * I don't like this
     *
     * @param letters
     * @param target
     * @return
     */
    public static char nextGreatestLetter1(char[] letters, char target) {
        int length = letters.length;
        if (target >= letters[length - 1]) {
            return letters[0];
        }
        int low = 0, high = length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (letters[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return letters[low];
    }


    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters, target));
    }
}
