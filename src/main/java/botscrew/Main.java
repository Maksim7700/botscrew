package botscrew;

import botscrew.dao.DepartamentDAO;
import botscrew.dao.LectorDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.scan("botscrew.dao");
        configApplicationContext.refresh();
        String name = "e1";
        String dep = "dep1";

        LectorDAO lectorDAO = configApplicationContext.getBean(LectorDAO.class);
        System.out.println(lectorDAO.findLectorsByName(name));

        DepartamentDAO departamentDAO = configApplicationContext.getBean(DepartamentDAO.class);
        System.out.println(departamentDAO.getCountLectors(dep));

        System.out.println("The average salary of "+ dep + " " + departamentDAO.avgSalaryByDepartament(dep));

        System.out.println("Head of "+ dep + " department is " + departamentDAO.departamentHead(dep));

        System.out.println("statistic of departament " + dep + " " + departamentDAO.getStatistic(dep));
    }
}
