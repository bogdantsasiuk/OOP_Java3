import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ініціалізуємо систему сповіщень (з ЛР 1-2)
        NotificationCenter notifCenter = new NotificationCenter("Система сповіщень Університету");

        // Ініціалізуємо сервіс університету (ЛР 3)
        UniversityService uniService = new UniversityService(notifCenter);

        while (true) {
            System.out.println("\n=== СИСТЕМА УПРАВЛІННЯ НАВЧАЛЬНИМ ПРОЦЕСОМ ===");
            System.out.println("1. Додати студента");
            System.out.println("2. Додати викладача та курс");
            System.out.println("3. Записати студента на курс");
            System.out.println("4. Виставити оцінку студенту");
            System.out.println("5. Показати всі курси (з пагінацією)");
            System.out.println("6. Показати всіх студентів (Залікові книжки)");
            System.out.println("7. Обробити чергу сповіщень");
            System.out.println("0. Вихід (дані зберігаються автоматично)");
            System.out.print("Оберіть дію: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очищення буфера

            switch (choice) {
                case 1:
                    System.out.print("Ім'я студента: ");
                    String sName = scanner.nextLine();
                    System.out.print("Номер телефону: ");
                    String sPhone = scanner.nextLine();
                    System.out.print("Факультет (напр. ФІТ, ФЕУ, ФПН): ");
                    String sFac = scanner.nextLine();
                    uniService.addStudent(new Student(String.valueOf(System.currentTimeMillis()), sName, sPhone, sFac));
                    System.out.println("Студента додано!");
                    break;
                case 2:
                    System.out.print("Ім'я викладача: ");
                    String tName = scanner.nextLine();
                    System.out.print("Кафедра: ");
                    String tDep = scanner.nextLine();
                    Teacher teacher = new Teacher(String.valueOf(System.currentTimeMillis()), tName, "000", tDep);
                    uniService.addTeacher(teacher);

                    System.out.print("Назва курсу, який він читає: ");
                    String cTitle = scanner.nextLine();
                    uniService.addCourse(new Course(cTitle, teacher));
                    System.out.println("Викладача та курс створено!");
                    break;
                case 3:
                    if(uniService.getStudents().isEmpty() || uniService.getCourses().isEmpty()) {
                        System.out.println("Спочатку додайте студентів та курси!");
                        break;
                    }
                    Student st = uniService.getStudents().get(0); // Для простоти беремо першого
                    Course crs = uniService.getCourses().get(0); // Беремо перший курс
                    uniService.enrollStudentInCourse(st, crs);
                    System.out.println("Студента " + st.getName() + " записано на курс " + crs.getTitle());
                    break;
                case 4:
                    if(uniService.getStudents().isEmpty()) {
                        System.out.println("Немає студентів!");
                        break;
                    }
                    Student studentToGrade = uniService.getStudents().get(0);
                    System.out.print("Назва курсу для оцінки: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Оцінка: ");
                    int grade = scanner.nextInt();
                    uniService.gradeStudent(studentToGrade, courseName, grade);
                    System.out.println("Оцінку виставлено!");
                    break;
                case 5:
                    System.out.print("Введіть номер сторінки: ");
                    int page = scanner.nextInt();
                    uniService.displayCoursesWithPagination(page, 2); // 2 курси на сторінку
                    break;
                case 6:
                    System.out.println("--- Список студентів ---");
                    for (Student s : uniService.getStudents()) {
                        System.out.println(s);
                    }
                    break;
                case 7:
                    notifCenter.processAllNotifications(); // Відпрацьовує код з ЛР 2
                    break;
                case 0:
                    System.out.println("Вихід із програми. Всі дані збережено у university_data.ser");
                    scanner.close();
                    return;
                default:
                    System.out.println("Невідома команда.");
            }
        }
    }
}