package exe.boris.targetmaker.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by boris on 20.02.15.
 */
public class CurrentDate{

    public static String createCurrentDate() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("EEE  MMMM HH:mm:ss ZZZ yyyy");
        String d = dateFormat.format(date);
        return d;
    }
}
