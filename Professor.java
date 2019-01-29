import java.util.ArrayList;
import java.util.Scanner;

public class Professor extends Person
{
    ArrayList<Student> professor_mentorships;

    public Professor(String name, String email)
    {
        this.name = name;
        this.email = email;
        this.collaborator_projects = new ArrayList<Project>();
        this.collaborator_publications = new ArrayList<Publication>();
        this.professor_mentorships  = new ArrayList<Student>();
    }

    public void display()
    {
        System.out.println("\n" + this.name + "\nProfessor");
        System.out.println(this.email);
        for (Project i : this.collaborator_projects)
        {
            System.out.println("Project:" + i.getTitle());
        }
        for (Publication i : this.collaborator_publications)
        {
            System.out.println("Publication:" + i.getTitle());
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
