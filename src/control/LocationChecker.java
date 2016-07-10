package control;

import java.util.AbstractMap;
import java.util.Map;

/**
 * Created by
 *
 * @author Andrew U.
 *         on 9/07/2016.
 */
class LocationChecker implements Checker<Map.Entry<Character, Character>> {
    private static final String MATCH = "\\p{Upper}\\p{Digit}";
    private static final Checker<String> STRING_CHECKER = new StringChecker();

    /**
     * @param s entered data.
     * @return a row and column as chars.
     */
    @Override
    public Map.Entry<Character, Character> apply(String s) {
        String p = STRING_CHECKER.apply(s);
        if (!p.matches(MATCH)) {
            throw new IllegalArgumentException("Wrong location: " + s);
        }
        return new AbstractMap.SimpleImmutableEntry<>(p.charAt(0), p.charAt(1));
    }
}
