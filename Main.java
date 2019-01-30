import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Admin administrator = new Admin();

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Professor> professors = new ArrayList<>();
        ArrayList<Researcher> researchers = new ArrayList<>();

        ArrayList<Publication> publications = new ArrayList<>();
        ArrayList<Project> projects = new ArrayList<>();

        boolean process;
        process = true;
        Scanner input = new Scanner(System.in);

        while (process) {
            System.out.println("Welcome! How do you like to continue?");
            System.out.println("Press 1 to ADD A COLLABORATOR");
            System.out.println("Press 2 to LOGIN AS ADMIN");
            System.out.println("Press 3 to CONSULT COLLABORATOR OR PROJECT");
            System.out.println("Press 4 to SHOW REPORT");

            int option = input.nextInt();

            switch (option) {
                case 1:
                    Scanner input2 = new Scanner(System.in);
                    Scanner input3 = new Scanner(System.in);
                    Scanner input4 = new Scanner(System.in);
                    String name, email;
                    System.out.println("Adding new collaborator...");
                    System.out.println("Are you a (1) student, (2) professor, (3) researcher?");
                    int option2 = input.nextInt();

                    if (option2 == 1 || option2 == 2 || option2 == 3)
                    {
                        System.out.println("Type in your name:");
                        name = input2.nextLine();
                        System.out.println("Type in your email:");
                        email = input3.nextLine();
                        switch (option2)
                        {
                            case 1:
                                int type;
                                System.out.println("Are you (1) an undergrad, (2) a graduate, (3) mastering?");
                                type = input4.nextInt();
                                Student newCollab = new Student(name, email, type);
                                students.add(newCollab);
                                System.out.println("Added!");
                                break;

                            case 2:
                                Professor newCollab2 = new Professor(name, email);
                                professors.add(newCollab2);
                                System.out.println("Added!");
                                break;

                            case 3:
                                Researcher newCollab3 = new Researcher(name, email);
                                researchers.add(newCollab3);
                                System.out.println("Added!");
                                break;
                        }
                    }
                    else
                    {
                        System.out.println("Umm, that's not an option...");
                    }
                    break;
                case 2:
                    Scanner enter_system = new Scanner(System.in);
                    int tries = 3;
                    boolean isAdmin = false;
                    String adminEmail, adminPassword, email2, pass;

                    while(tries != 0)
                    {
                        System.out.println("Enter email");
                        adminEmail = enter_system.nextLine();
                        email2 = administrator.getEmail();
                        if(adminEmail.equals(email2))
                        {
                            System.out.println("Enter password");
                            adminPassword = enter_system.nextLine();
                            pass = administrator.getPassword();
                            if(adminPassword.equals(pass))
                            {
                                isAdmin = true;
                                break;
                            }
                            else
                            {
                                tries = tries - 1;
                                System.out.println("Wrong password! You've got " + tries + " more chances");
                            }
                        }
                        else
                        {
                            System.out.println("Wrong email! Try again");
                        }
                    }
                    if(isAdmin)
                    {
                        login(students, professors, researchers, projects, publications);
                    }
                    break;
                case 3:
                    consult(students, professors, researchers, projects);
                    break;
                case 4:
                    report(students, professors, researchers, projects, publications);
                    break;
            }

            System.out.println("Would you like to exit or continue?");
            System.out.println("Press 0 to exit the application or 1 to continue");
            if (input.nextInt() == 0) {
                process = false;
            }

        }
    }

    public static void consult(ArrayList<Student> students, ArrayList<Professor> professors,
                               ArrayList<Researcher> researchers, ArrayList<Project> projects)
    {
        System.out.println("Consult for a (1) collaborator, (2) project");
        Scanner input = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        int option;
        boolean found = false;
        option = input.nextInt();
        String email;

        if (option == 1)
        {
            Scanner input2 = new Scanner(System.in);
            System.out.println("Enter email");
            email = input2.nextLine();
            String my_email;

            for (Student i : students) {
                my_email = i.getEmail();
                if (email.equals(my_email)) {
                    i.display();
                    found = true;
                }
            }
            if (!found) {
                for (Professor i : professors) {
                    my_email = i.getEmail();
                    if (email.equals(my_email)) {
                        i.display();
                        found = true;
                    }
                }
            }
            if (!found) {
                for (Researcher i : researchers) {
                    my_email = i.getEmail();
                    if (email.equals(my_email)) {
                        i.display();
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.println("Not found...");
            }
        } else if (option == 2) {
            System.out.println("Enter project's exact name");
            String name;
            name = input3.nextLine();
            for(Project i : projects)
            {
                if(i.title.equals(name))
                {
                    i.display();
                }
            }
        }
    }

    public static void login(ArrayList<Student> students, ArrayList<Professor> professors,
                      ArrayList<Researcher> researchers, ArrayList<Project> projects,
                             ArrayList<Publication> publications)
    {
        Scanner input = new Scanner(System.in);
        int option;
        boolean process;
        process = true;

        while(process)
        {
            System.out.println("What would you like to do?");
            System.out.println("Press 1 to ADD A PROJECT");
            System.out.println("Press 2 to EDIT A PROJECT");
            System.out.println("Press 3 to ADD A PUBLICATION");
            System.out.println("Press 4 to ASSOCIATE MENTORING TO PROFESSOR");
            System.out.println("Press 5 to LOG OUT");

            Scanner input2 = new Scanner(System.in);
            //Scanner input9 = new Scanner(System.in);
            option = input2.nextInt();

            switch(option)
            {
                case 1:
                    int continuing;
                    String name, email, my_email;
                    Professor project_head;
                    boolean found = false;
                    Scanner input3 = new Scanner(System.in);
                    Scanner input4 = new Scanner(System.in);

                    System.out.println("Enter the professor's email");
                    for (Professor i : professors) {
                        email = input3.nextLine();
                        my_email = i.getEmail();
                        if (email.equals(my_email)) {
                            found = true;
                            project_head = i;
                            System.out.println("Enter project's name");
                            name = input4.nextLine();

                            Project newProject = new Project(1, name);
                            projects.add(newProject);
                            project_head.collaborator_projects.add(newProject); //adiciona o projeto na lista de projetos desse professor head
                            newProject.projects_professors.add(project_head);

                            System.out.println("Add all info? (1) Yes or (2) no. You can edit it later");
                            continuing = input.nextInt();
                            if(continuing == 1)
                            {
                                newProject.start(newProject, students, professors, researchers);
                            }
                        }
                    }
                    if(!found)
                    {
                        System.out.println("Sorry, start over");
                    }
                    break;
                case 2:
                    Scanner input5 = new Scanner(System.in);
                    String name2, my_name;
                    boolean found2 = false;
                    System.out.println("Enter project's name");
                    name2 = input5.nextLine();
                    for (Project i : projects) {
                        my_name = i.getTitle();
                        if (name2.equals(my_name)) {
                            i.edit(i, students, professors, researchers, publications);
                            found2 = true;
                        }
                    }
                    if(!found2)
                    {
                        System.out.println("This project doesn't seem to exist...");
                    }
                    break;

                case 3:

                    addpublication(students, professors, researchers, projects, publications);

                case 4:

                    mentoring(students, professors);

                case 5:
                    process = false;

            }

        }

    }

    public static void report(ArrayList<Student> students, ArrayList<Professor> professors,
                               ArrayList<Researcher> researchers, ArrayList<Project> projects,
                              ArrayList<Publication> publications)
    {
        System.out.println("Laboratory's Report");
        int number = 0;
        int prof = 0;

        for (Student i : students) {
            number++;
        }
        for (Professor i : professors) {
            number++;
            prof++;
        }
        for (Researcher i : researchers) {
            number++;
        }
        System.out.println("Number of collaborators: " + number);
        number = 0;

        int n1 = 0, n2 = 0, n3 = 0;
        for (Project i : projects) {
            if(i.status == 1)
            {
                n1++;
            }
            else if(i.status == 2)
            {
                n2++;
            }
            else if(i.status == 3)
            {
                n3++;
            }
        }


        System.out.println("Number of projects under construction: " + n1);
        System.out.println("Number of projects in process: " + n2);
        System.out.println("Number of projects concluded: " + n3);
        n1 = n1 + n2 + n3;
        System.out.println("Number of projects: " + n1);


        for (Publication i : publications) {
            number++;
        }
        System.out.println("Number of publications: " + number);
        number = 0;

        for (Professor i : professors) {
            if(i.professor_mentorships != null)
            {
                number++;
            }
        }
        number = number - prof;
        System.out.println("Number of mentorships: " + number);

    }

    public static void addpublication(ArrayList<Student> students, ArrayList<Professor> professors,
                                      ArrayList<Researcher> researchers, ArrayList<Project> projects,
                                      ArrayList<Publication> publications)
    {
        Scanner input10 = new Scanner(System.in);
        Scanner input11 = new Scanner(System.in);
        Scanner input9 = new Scanner(System.in);
        String a_email, tit, con;
        int year;

        System.out.println("Do you want to (1) add a publication to the laboratory (You wont't be able to edit it " +
                "later, only add authors. You can add one author at a time), (2) associate an existing publication " +
                "to a project, (3) associate an existing publication to a collaborator (as an author)?");
        int pub = input9.nextInt();
        boolean found3 = false;
        if(pub == 1)
        {
            Publication newPublication = new Publication();

            System.out.println("Enter the author's email");
            a_email = input10.nextLine();
            for (Professor i : professors) {

                if (i.email.equals(a_email)) {
                    found3 = true;
                    newPublication.publication_professors.add(i);
                    i.collaborator_publications.add(newPublication);
                }
            }
            if (!found3) {
                for (Student i : students) {

                    if (i.email.equals(a_email)) {
                        found3 = true;
                        newPublication.publication_students.add(i);
                        i.collaborator_publications.add(newPublication);
                    }
                }
            }
            if (!found3) {
                for (Researcher i : researchers) {
                    if (i.email.equals(a_email)) {
                        found3 = true;
                        newPublication.publication_researchers.add(i);
                        i.collaborator_publications.add(newPublication);
                    }
                }
            }
            if (!found3) {
                System.out.println("Sorry, start over");
            }
            else {
                System.out.println("Enter the publication's title");
                tit = input11.nextLine();
                System.out.println("Enter the conference in which you presented your publication");
                con = input10.nextLine();
                System.out.println("Enter the year that happened");
                year = input11.nextInt();
                newPublication.start(tit, con, year);
            }
        }
        else if(pub == 2)
        {
            System.out.println("Type in the exact title of the publication:");
            boolean added = false;
            String pubtitle = input10.nextLine();
            String projtitle;
            for(Publication i : publications)
            {
                if(i.title.equals(pubtitle))
                {
                    System.out.println("Type in the exact title of the project:");
                    projtitle = input9.nextLine();
                    for(Project j : projects)
                    {
                        if(i.title.equals(projtitle))
                        {
                            j.add1Publication(i, j);
                            i.addProject(j);
                            System.out.println("Added!");
                            added = true;
                            break;
                        }
                    }
                    break;
                }
            }

            if(!added)
            {
                System.out.println("Project or publication not found. Make sure they already exist");
            }

        }
        else if(pub == 3)
        {
            System.out.println("Type in the exact title of the publication:");
            boolean added = false;
            String pubtitle = input10.nextLine();
            String email;
            for(Publication i : publications)
            {
                if(i.title.equals(pubtitle))
                {
                    System.out.println("Type in the author's email:");
                    email = input9.nextLine();
                    for (Professor j : professors) {

                        if (j.email.equals(email)) {
                            found3 = true;
                            i.addAuthor(j);
                        }
                    }
                    if (!found3) {
                        for (Student j : students) {

                            if (j.email.equals(email)) {
                                found3 = true;
                                i.addAuthor(j);
                            }
                        }
                    }
                    if (!found3) {
                        for (Researcher j : researchers) {
                            if (j.email.equals(email)) {
                                found3 = true;
                                i.addAuthor(j);
                            }
                        }
                    }
                    if (!found3) {
                        System.out.println("Sorry, start over");
                    }
                }
            }

            if(!added)
            {
                System.out.println("Project or publication not found. Make sure they already exist");
            }
        }
    }

    public static void mentoring(ArrayList<Student> students, ArrayList<Professor> professors)
    {
        Scanner input = new Scanner(System.in);
        String email;


        System.out.println("Type in the professor's email");

        email = input.nextLine();

        for(Professor i : professors)
        {
            if(i.email.equals(email))
            {
                System.out.println("Type in the student's email");
                email = input.nextLine();
                for(Student j : students)
                {
                    if(j.email.equals(email))
                    {
                        i.newMentorship(j);
                    }
                }

            }
        }

    }

}
