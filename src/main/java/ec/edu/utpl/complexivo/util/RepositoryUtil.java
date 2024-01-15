package ec.edu.utpl.complexivo.util;

import java.math.BigDecimal;
import java.math.BigInteger;

public class RepositoryUtil {

    public static String stringFromObject(Object val, String... defaultValue) {
        String result = null;
        if (defaultValue != null && defaultValue.length == 1) {
            result = defaultValue[0];
        }
        if (val != null) {
            result = val.toString();
        }
        return result;
    }

    public static Integer integerFromObject(Object val) {
        Integer result = 0;
        if (val != null) {
            if (val instanceof BigDecimal) {
                result = ((BigDecimal) val).intValue();
            } else if (val instanceof BigInteger) {
                result = ((BigInteger) val).intValue();
            } else if (val instanceof Short) {
                result = ((Short) val).intValue();
            } else if (val instanceof String && isStringNumber(val.toString())) {
                result = Integer.parseInt(val.toString());
            } else if (val instanceof Long) {
                result = ((Long) val).intValue();
            } else if (val instanceof Integer) {
                result = (Integer) val;
            }
        }

        return result;
    }

    public static boolean isStringNumber(String value) {
        boolean isString = false;
        if (value != null && !value.isEmpty()) {
            isString = value.matches("-?\\d+(\\.\\d+)?");
        }
        return isString;
    }
}
