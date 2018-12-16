import java.util.ArrayList;

public class Publication {
    ArrayList<Professor> publication_professors;
    ArrayList<Student> publication_students;
    ArrayList<Researcher> publication_researchers;
    String title;
    String conference;
    int year;
    Project publication_project;
    boolean project_already_assigned;

    public Publication()
    {

    }

    public void start(String title, String conference, int year)
    {
        this.title = title;
        this.conference = conference;
        this.year = year;
        this.project_already_assigned = false;
    }

    public String getTitle()
    {
        return this.title;
    }

    public boolean isProjectAlreadyAssigned()
    {
        return this.project_already_assigned;
    }

    public void addProject(Project project)
    {
        this.project_already_assigned = true;
        this.publication_project = project;
    }

    public void addAuthor(Student student)
    {
        this.publication_students.add(student);
    }
    public void addAuthor(Professor professor)
    {
        this.publication_professors.add(professor);
    }
    public void addAuthor(Researcher researcher)
    {
        this.publication_researchers.add(researcher);
    }
}
