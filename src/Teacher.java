public class Teacher extends Person {
    private static final long serialVersionUID = 1L;
    private String department;

    public Teacher(String id, String name, String phone, String department) {
        super(id, name, phone);
        this.department = department;
    }

    @Override
    public String getRole() { return "Викладач"; }

    @Override
    public String toString() {
        return "Викладач: " + name + " (Кафедра: " + department + ")";
    }
}