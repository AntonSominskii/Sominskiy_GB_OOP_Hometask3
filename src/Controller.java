import java.util.List;

public class Controller {
    private StudyGroupService groupService = new StudyGroupService();
    private StreamService streamService = new StreamService();

    public void removeStudent(StudyGroup group, String name) {
        groupService.removeStudentByName(group, name);
    }

    public void sortStudentsById(StudyGroup group) {
        groupService.sortStudentsById(group);
    }

    public void sortStudentsByName(StudyGroup group) {
        groupService.sortStudentsByName(group);
    }

    public void sortStreams(List<Stream> streams) {
        streamService.sortStreams(streams);
    }
}