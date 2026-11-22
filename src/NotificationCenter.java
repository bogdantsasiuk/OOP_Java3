import java.util.ArrayList;
import java.util.List;

public class NotificationCenter {
    private String centerName;
    private List<Notification> notifications;

    public NotificationCenter(String centerName) {
        this.centerName = centerName;
        this.notifications = new ArrayList<>();
    }

    public void addNotification(Notification notification) {
        this.notifications.add(notification);
    }

    public void processAllNotifications() {
        System.out.println("=== " + centerName + ": Обробка черги повідомлень ===");
        for (Notification n : notifications) {
            System.out.println("Екран телефону показує:");
            System.out.println(n.getDisplayText());
            System.out.println("Системна дія:");
            n.deliver();
            System.out.println("-------------------------");
        }
    }
}
