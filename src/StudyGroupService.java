import java.util.Collections;

public class StudyGroupService {
    public void removeStudentByName(StudyGroup group, String name) {
        group.getStudents().removeIf(student -> student.getName().equals(name));
    }

    public void sortStudentsById(StudyGroup group) {
        Collections.sort(group.getStudents());
    }

    public void sortStudentsByName(StudyGroup group) {
        group.getStudents().sort(new StudentComparator());
    }
}