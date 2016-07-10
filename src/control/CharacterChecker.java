package control;

/**
 * Created by
 *
 * @author Andrew U.
 *         on 9/07/2016.
 */
class CharacterChecker implements Checker<Character> {
    private static final String MATCH = "\\p{Upper}";
    private static final Checker<String> STRING_CHECKER = new StringChecker();

    /**
     * @param s any entered letter.
     * @return character in [A-Z].
     */
    @Override
    public Character apply(String s) {
        String rs = STRING_CHECKER.apply(s);
        if (!rs.matches(MATCH)) {
            throw new IllegalArgumentException("Wrong character: " + s);
        }
        return rs.charAt(0);
    }
}
