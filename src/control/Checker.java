package control;

import java.util.function.Function;

/**
 * Created by
 *
 * @author Andrew U.
 *         on 9/07/2016.
 *         <p>
 *         Checks entered data.
 */
interface Checker<T> extends Function<String, T> {
}
