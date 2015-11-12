
/**
 * Matches a given pattern in a given target string
 */
public class PatternMatch_James {
    private char[] patternArray;

    /**
     * Pattern to look for
     *
     * @param pattern  the pattern
     */
    public PatternMatch_James(final String pattern) {
        this.patternArray = pattern.toCharArray();
    }

    /**
     * Returns <code>true</code> if the pattern substring is found anywhere in the target and
     * <code>false</code> otherwise.  Search is case-sensitive.
     *
     * @param   target  string to search through
     * @return  <code>true</code> if the pattern substring is found anywhere in the target and
     *          <code>false</code> otherwise
     */
    public boolean match(final String target) {
        int matchIndex = 0; // This variables acts as the state of the match!

        for (int i = 0; i < target.length(); i++) {
            if (patternArray[matchIndex] == target.charAt(i)) {
                // Got character match so advance the state to the next character in the pattern
                matchIndex++;
            } else {
                // No character match.  Reset state to first character in the pattern.
                matchIndex = 0;
            }

            if (matchIndex == patternArray.length) {
                // Walked through the whole pattern so match was found.  Return immediately.
                return true;
            }
        }

        // If this point reached then no match was found
        return false;
    }

    public String getPattern() {
        return new String(patternArray);
    }

    /**
     * Simple quick test
     *
     * @param args
     */
    public static void main(String[] args) {
        final String target = "centcenter";
        final PatternMatch_James patternMatch = new PatternMatch_James("abca");
//        final String target = "cababca";
//        final PatternMatch_James patternMatch = new PatternMatch_James("abca");
        System.out.printf(
                "Substring \"%s\" %s in target string \"%s\"",
                patternMatch.getPattern(),
                patternMatch.match(target) ? "FOUND" : "NOT FOUND",
                target);
    }
}

