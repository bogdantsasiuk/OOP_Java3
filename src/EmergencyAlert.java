public class EmergencyAlert extends PushNotification {
    private int severityLevel;

    public EmergencyAlert(String recipientId, String title, String content, int severityLevel) {
        super(recipientId, "SYSTEM_ALERT", title, content);
        this.severityLevel = severityLevel;
    }


    public String getDisplayText() {
        return " ЕКСТРЕНЕ СПОВІЩЕННЯ (Рівень " + severityLevel + ") !!!\n" + super.getDisplayText();
    }


    public void deliver() {
        System.out.println("ІГНОРУВАННЯ БЕЗЗВУЧНОГО РЕЖИМУ! Увімкнення сирени для пристрою: " + recipientId);
        super.deliver();
    }
}