import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTask {
    private static final String START_DATE = "21-09-2017";
    private static final String END_DATE = "30-09-2017";
    private Date startDate;
    private Date endDate;

    @Before
    public void SetUp() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        startDate = dateFormat.parse(START_DATE);
        endDate = dateFormat.parse(END_DATE);
    }

    @Test(expected = DateException.class)
    public void constructorShouldThrowDateException() throws DateException, ParseException{
        new Task(endDate, startDate);
    }

    @Test
    public void createTask() throws DateException {
        Task task = new Task(startDate, endDate);
        assertEquals(task.getStartDate(), startDate);
        assertEquals(task.getEndDate(), endDate);
    }

}
