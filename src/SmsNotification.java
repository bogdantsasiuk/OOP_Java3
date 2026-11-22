public class SmsNotification extends MessageNotification {
    private String text;

    public SmsNotification(String recipientId, String senderNumber, String _text) {
        super(recipientId, senderNumber);
        text = _text;
    }


    public String getDisplayText() {
        return "Нове SMS від " + senderNumber + ": " + text;
    }


    public void deliver() {
        System.out.println("Відправка SMS на номер " + recipientId + "...");
    }
}