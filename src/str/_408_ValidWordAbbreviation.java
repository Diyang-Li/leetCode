package str;

/**
 * @author Diyang Li
 * @create 2022-09-07 5:09 PM
 */
public class _408_ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while (i < word.length() && j < abbr.length()) {
            char orig = word.charAt(i);
            char sub = abbr.charAt(j);
            if (orig == sub) {
                i++;
                j++;
                continue;
            } else {
                if (Character.isLetter(sub)) return false;
                if (abbr.charAt(j) == '0') return false;
                StringBuilder sb = new StringBuilder();
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    sb.append(abbr.charAt(j));
                    j++;
                }
                int num = Integer.valueOf(sb.toString());
                i += num;
            }
        }

        return i == word.length() && j == abbr.length();
    }

}
