import java.util.ArrayList;
import java.util.Scanner;

public class Professor
{
    String name;
    String email;
    ArrayList<Project> professor_projects;
    ArrayList<Publication> professor_publications;
    ArrayList<Student> professor_mentorships;

    public Professor(String name, String email)
    {
        this.name = name;
        this.email = email;
        this.professor_projects = new ArrayList<Project>();
        this.professor_publications = new ArrayList<Publication>();
        this.professor_mentorships  = new ArrayList<Student>();
    }

    public String getEmail() {
        return this.email;
    }

    public void display()
    {
        System.out.println(this.name + "\nProfessor");
        System.out.println(this.email);
        for (Project i : this.professor_projects)
        {
            System.out.println(i.getTitle());
        }
        for (Publication i : this.professor_publications)
        {
            System.out.println(i.getTitle());
        }
        if(this.professor_mentorships != null)
        {
            System.out.println("Mentor to:");
            for (Student i : this.professor_mentorships) {
                System.out.println(i.getName());
            }
         }
    }

    public void newMentorship(Student student)
    {
        this.professor_mentorships.add(student);
    }


}
