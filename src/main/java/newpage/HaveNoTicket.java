package newpage;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
public class HaveNoTicket extends BaseTest {
	
	    public void main(String[] args) { // Before Java 8
	        Date today = new Date();
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(today); // don't forget this if date is arbitrary
	        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1 being Sunday
	        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
	        int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
	        int month = cal.get(Calendar.MONTH); // 0 being January
	        int year = cal.get(Calendar.YEAR);
	    }
}
	
	    
