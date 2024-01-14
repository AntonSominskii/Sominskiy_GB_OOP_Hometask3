import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем студентов для первой группы
        Student student1 = new Student(3, "Иванов Иван");
        Student student2 = new Student(1, "Петров Петр");
        Student student3 = new Student(2, "Сидоров Сидор");

        // Создаем первую учебную группу и добавляем в нее студентов
        StudyGroup group1 = new StudyGroup();
        group1.addStudent(student1);
        group1.addStudent(student2);
        group1.addStudent(student3);

        // Создаем студентов для второй группы
        Student student4 = new Student(4, "Алексеев Алексей");
        Student student5 = new Student(5, "Борисов Борис");

        // Создаем вторую учебную группу и добавляем в нее студентов
        StudyGroup group2 = new StudyGroup();
        group2.addStudent(student4);
        group2.addStudent(student5);

        // Создаем студентов для третьей группы
        Student student6 = new Student(6, "Викторов Виктор");
        Student student7 = new Student(7, "Григорьев Григорий");

        // Создаем третью учебную группу и добавляем в нее студентов
        StudyGroup group3 = new StudyGroup();
        group3.addStudent(student6);
        group3.addStudent(student7);

        // Создаем сервис для работы с учебными группами
        StudyGroupService groupService = new StudyGroupService();

        // Создаем потоки учебных групп
        Stream stream1 = new Stream(new ArrayList<>(List.of(group1, group2)), 1);
        Stream stream2 = new Stream(new ArrayList<>(List.of(group3)), 2);

        List<Stream> streams = new ArrayList<>(List.of(stream1, stream2));
        StreamService streamService = new StreamService();

        // Демонстрация работы итератора
        System.out.println("Студенты в группе № 1:");
        for (Student student : group1) {
            System.out.println(student.getName());
        }

        // Сортировка студентов по ID
        groupService.sortStudentsById(group1);
        System.out.println("\nСтуденты в группе № 1, после сортировки по ID:");
        for (Student student : group1) {
            System.out.println(student.getName() + " (ID: " + student.getStudentId() + ")");
        }

        // Сортировка студентов по имени
        groupService.sortStudentsByName(group1);
        System.out.println("\nСтуденты в группе № 1, после сортировки по имени:");
        for (Student student : group1) {
            System.out.println(student.getName());
        }

        // Удаление студента по имени
        groupService.removeStudentByName(group1, "Петров Петр");
        System.out.println("\nСтуденты в группе № 1, после удаления Петрова Петра:");
        for (Student student : group1) {
            System.out.println(student.getName());
        }

        // Сортировка потоков по количеству групп и вывод номеров потоков
        streamService.sortStreams(streams);
        System.out.println("\nСортировка потоков по количеству групп:");
        for (Stream stream : streams) {
            System.out.println("Поток № " + stream.getStreamNumber() + " с " + stream.getStudyGroups().size() + " группами");
        }

        // Контроллер для управления учебными группами и потоками
        Controller controller = new Controller();

        // Вызов методов контроллера
        controller.sortStreams(streams); // Сортировка потоков
        controller.sortStudentsById(group1); // Сортировка студентов в группе по ID
        controller.removeStudent(group1, "Иванов Иван"); // Удаление студента
    }
}