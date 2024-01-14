import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class StudyGroupIterator implements Iterator<Student> {
    private List<Student> students;
    private int currentIndex = 0;

    public StudyGroupIterator(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < students.size();
    }

    @Override
    public Student next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return students.get(currentIndex++);
    }

    @Override
    public void remove() {
        if (currentIndex <= 0) {
            throw new IllegalStateException();
        }
        students.remove(--currentIndex);
    }
}
