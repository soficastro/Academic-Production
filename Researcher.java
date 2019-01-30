import java.util.ArrayList;

public class Researcher extends Person
{

    public Researcher(String name, String email)
    {
        this.name = name;
        this.email = email;
        this.researcher_projects = new ArrayList<Project>();
        this.researcher_publications = new ArrayList<Publication>();
    }
    

    public void display()
    {
        System.out.println(this.name + "\nResearcher");
        System.out.println(this.email);
        for (Project i : this.researcher_projects) {
            System.out.println("Project: " + i.getTitle());
        }
        
        for (Publication i : researcher_publications) {
            System.out.println("Publication: " + i.getTitle());
        }
    }
}
