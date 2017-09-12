import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Scheduler {
    private ArrayList<Task> taskList;
    public Scheduler() throws DateException {
        taskList = new ArrayList<Task>();
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public ArrayList<Task> getOptimalTaskList(){
        ArrayList<Task> taskListCopy = new ArrayList<Task>(taskList);
        ArrayList<Task> optimalTaskList = new ArrayList<Task>();

        if (taskList.size() == 0){
            return null;
        } else {
            while (taskListCopy.size() > 0){
                Task earlierTask = taskListCopy.get(0);
                for (Task task: taskListCopy){
                    if (earlierTask.getEndDate().after(task.getEndDate())){
                        earlierTask = task;
                    }
                }

                taskListCopy.remove(earlierTask);
                optimalTaskList.add(earlierTask);
                ArrayList<Task> tasksToDelete = new ArrayList<Task>();

                for (Task task: taskListCopy){
                    if ((task.getStartDate().after(earlierTask.getStartDate()) &&
                            task.getStartDate().before(earlierTask.getEndDate())) ||
                            (task.getEndDate().after(earlierTask.getStartDate()) &&
                            task.getEndDate().before(earlierTask.getEndDate()))){
                        tasksToDelete.add(task);
                    }
                }

                taskListCopy.removeAll(tasksToDelete);
            }
        }
        return optimalTaskList;
    }


}
