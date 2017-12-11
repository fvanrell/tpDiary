package Diary;
/**
 *
 * @author rzgheib
 */
public class Week {
    
public static final int BOOKABLE_DAYS_PER_WEEK = 5;

// A week number within a particular year (0-52).
    private final int weekNumber;
    private final Day[] days;

    public Week(int weekNumber)
    {
        this.weekNumber = weekNumber;
        days = new Day[BOOKABLE_DAYS_PER_WEEK];
        for (int i = 0; i < BOOKABLE_DAYS_PER_WEEK; i++) {
            days[i] = new Day(weekNumber * 7 + i + 1);
        }
    }
    
    public void showAppointments()
    {
        for (int i = 0; i < BOOKABLE_DAYS_PER_WEEK; i++) {
            days[i].showAppointments();
        }
    }
    
      public Day getDay(int dayInWeek)
    {
        if (dayInWeek > 0 && dayInWeek <= 5) {
            return days[dayInWeek-1];
        } else {
            return null;
        }
    }

    /**
     * @return The week number (0-52).
     */
    public int getWeekNumber()
    {
        return weekNumber;
    }
    
}
