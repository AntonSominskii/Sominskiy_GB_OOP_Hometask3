import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Stream implements Iterator<StudyGroup> {
    private List<StudyGroup> studyGroups;
    private int currentIndex = 0;
    private int streamNumber;

    public Stream(List<StudyGroup> studyGroups, int streamNumber) {
        this.studyGroups = studyGroups;
        this.streamNumber = streamNumber;
    }

    public List<StudyGroup> getStudyGroups() {
        return studyGroups;
    }

    public int getStreamNumber() {
        return streamNumber;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < studyGroups.size();
    }

    @Override
    public StudyGroup next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return studyGroups.get(currentIndex++);
    }
}