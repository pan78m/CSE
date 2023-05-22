package Activity_Sel_Problem;

import java.util.*;

class Activity implements Comparable<Activity> {
    int start;
    int finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compareTo(Activity other) {
        return this.finish - other.finish;
    }
}

public class ActivitySelection {
    public static List<Activity> selectActivities(Activity[] activities) {
        List<Activity> selectedActivities = new ArrayList<>();
        
        // Sort activities based on finish times
        Arrays.sort(activities);
        
        // Select the first activity
        selectedActivities.add(activities[0]);
        
        // Iterate through the remaining activities
        int lastSelectedActivityIndex = 0;
        for (int i = 1; i < activities.length; i++) {
            Activity currentActivity = activities[i];
            Activity lastSelectedActivity = activities[lastSelectedActivityIndex];
            
            // Check if the current activity does not overlap with the last selected activity
            if (currentActivity.start >= lastSelectedActivity.finish) {
                selectedActivities.add(currentActivity);
                lastSelectedActivityIndex = i;
            }
        }
        
        return selectedActivities;
    }

    public static void main(String[] args) {
        // Create sample activities
        Activity[] activities = {
                new Activity(1, 3),
                new Activity(2, 5),
                new Activity(1, 6),
                new Activity(5, 7),
                new Activity(8, 9),
                new Activity(5, 9)
        };

        // Select activities
        List<Activity> selectedActivities = selectActivities(activities);

        // Print the selected activities
        System.out.println("Selected Activities:");
        for (Activity activity : selectedActivities) {
            System.out.println("Start Time: " + activity.start + ", Finish Time: " + activity.finish);
        }
    }
}
