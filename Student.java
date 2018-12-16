import java.util.ArrayList;
import java.util.Scanner;

public class Student
{
    String name;
    String email;
    ArrayList<Project> student_projects;
    ArrayList<Publication> student_publications;
    int type; //Type 1 = Undergrad, type 2 = Grad; type 3 = Master

    public Student(String name, String email, int type)
    {
        this.name = name;
        this.email = email;
        this.student_projects = new ArrayList<Project>();
        this.student_publications = new ArrayList<Publication>();
        this.type = type;
    }

    public String getEmail() {
        return this.email;
    }
    public String getName() {
        return this.name;
    }

    public void display()
    {
        System.out.println("\n" + this.name);
        if(this.type == 1)
        {
            System.out.println("Undergraduate student");
        }
        else if(this.type == 2)
        {
            System.out.println("Graduate student");
        }
        else if(this.type == 3)
        {
            System.out.println("Master's student");
        }
        System.out.println(this.email);
        for (Project i : this.student_projects) {
            System.out.println(i.getTitle());
        }
        /*
        for (Publication i : student_publications) {
            System.out.println(i.getTitle());
        }*/

        System.out.println("\n");
    }
}
