package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
    public static boolean ifEmpty(String str) {
        if ("".equals(str) || str == null) {
            return true;
        }
        return false;

    }

    public static Date stringToDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(dateString);
    }
}