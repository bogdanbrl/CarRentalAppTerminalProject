package utils;

import java.util.regex.Pattern;

/**
 * @author Double "B"
 * @created 23/03/2021 - 8:26 PM
 * @project CarRentalAppSDAProject
 */
public class GregorianDateMatcher implements DateMatcher{

    /** We've used an alternation character “|” to match at least one of the four branches.
     * Thus, the valid date of February either matches the first branch of February 29th of a leap year
     * either the second branch of any day from 1 to 28.
     * The dates of remaining months match third and fourth branches.
     * */

    private static Pattern DATE_PATTERN = Pattern.compile(
            "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
                    + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
                    + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
                    + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");

    @Override
    public boolean matches(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }
}
