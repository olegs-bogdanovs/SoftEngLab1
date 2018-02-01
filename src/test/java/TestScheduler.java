import com.tsi.softenf.lab1.exceptions.DateException;
import com.tsi.softenf.lab1.Scheduler;
import com.tsi.softenf.lab1.Task;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class TestScheduler {
    private Task task1;
    private Task task2;
    private Task task3;
    Scheduler scheduler;

    @Before
    public void SetUp() throws ParseException, DateException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        task1 = new Task(dateFormat.parse("01-09-2017"), dateFormat.parse("10-09-2017"));
        task2 = new Task(dateFormat.parse("12-09-2017"), dateFormat.parse("28-09-2017"));
        task3 = new Task(dateFormat.parse("09-09-2017"), dateFormat.parse("15-09-2017"));
    }

    @Test
    public void addTaskToScheduler() throws DateException{
        Scheduler scheduler = new Scheduler();
        scheduler.addTask(task1);
        scheduler.addTask(task2);
        scheduler.addTask(task3);
        assertEquals(3, scheduler.getTaskList().size());
        assertTrue(scheduler.getTaskList().contains(task1));
        assertTrue(scheduler.getTaskList().contains(task2));
        assertTrue(scheduler.getTaskList().contains(task3));
    }

    @Test
    public void testOptimalSchedule() throws DateException{
        Scheduler scheduler = new Scheduler();
        scheduler.addTask(task1);
        scheduler.addTask(task2);
        scheduler.addTask(task3);
        ArrayList <Task> taskList = scheduler.getOptimalTaskList();
        assertEquals(2, taskList.size());
        assertTrue(taskList.contains(task1));
        assertTrue(taskList.contains(task2));
    }

    @Test
    public void testOptimalSchedulePath1() throws DateException{
        Scheduler scheduler = new Scheduler();
        assertEquals(0, scheduler.getOptimalTaskList().size());
    }

    @Test
    public void testOptimalSchedulePath2() throws DateException{
        Scheduler scheduler = new Scheduler();
        scheduler.addTask(task1);
        assertEquals(1, scheduler.getOptimalTaskList().size());
        assertTrue(scheduler.getOptimalTaskList().contains(task1));
    }

    @Test
    public void testOptimalSchedulePath5() throws DateException{
        Scheduler scheduler = new Scheduler();
        scheduler.addTask(task2);
        scheduler.addTask(task1);
        assertEquals(2, scheduler.getOptimalTaskList().size());
        assertTrue(scheduler.getOptimalTaskList().contains(task1));
        assertTrue(scheduler.getOptimalTaskList().contains(task2));
    }

    @Test
    public void testOptimalSchedulePath6() throws DateException{
        Scheduler scheduler = new Scheduler();
        scheduler.addTask(task3);
        scheduler.addTask(task1);
        assertEquals(1, scheduler.getOptimalTaskList().size());
        assertTrue(scheduler.getOptimalTaskList().contains(task1));
    }
}

