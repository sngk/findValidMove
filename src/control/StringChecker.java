package control;

/**
 * Created by
 *
 * @author Andrew U.
 *         on 9/07/2016.
 */
 class StringChecker implements Checker<String> {
    @Override
    public String apply(String s){
        return s.trim().toUpperCase();
    }
}
