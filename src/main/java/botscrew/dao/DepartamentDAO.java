package botscrew.dao;


import botscrew.util.ConnectionUtil;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
public class DepartamentDAO  {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private final String GET_COUNT_LECTORS = "select * from lector l inner join departament d on l.dep_id=d.id where d.name=?";
    private final String AVG_SALARY_DEPARTAMENT = "select AVG(salary) as salary from Lector l inner join Departament d on l.dep_id=d.id where d.name=?";
    private final String DEPARTAMENT_HEAD = "select head from departament where name = ?";
    private final String STATISTIC = "select count(*) as count, d.name from degree d inner join lector l on d.id = l.deg_id inner join departament t on t.id=l.dep_id where t.name=? group by d.name";

    public DepartamentDAO() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        connection = ConnectionUtil.openConnection();
    }

    public int getCountLectors(String departament) {
        int count = 0;
        try {
            preparedStatement = connection.prepareStatement(GET_COUNT_LECTORS);
            preparedStatement.setString(1, departament);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    public int avgSalaryByDepartament(String departament) {
        int salary = 0;
        try {
            preparedStatement = connection.prepareStatement(AVG_SALARY_DEPARTAMENT);
            preparedStatement.setString(1, departament);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            salary = resultSet.getInt("salary");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return salary;

    }
    public String departamentHead(String departament) {
        String name = "";
        try {
            preparedStatement = connection.prepareStatement(DEPARTAMENT_HEAD);
            preparedStatement.setString(1, departament);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            name = resultSet.getString("head");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return name;
    }

    public Map<String, Integer> getStatistic(String departament) {
        StringBuilder professor = new StringBuilder();
        StringBuilder assistant = new StringBuilder();
        StringBuilder associateProfessor = new StringBuilder();
        int countProfessor = 0;
        int countAssistant = 0;
        int countAssociateProfessor = 0;
        Map<String, Integer> map = new HashMap<>();

        try {
            preparedStatement = connection.prepareStatement(STATISTIC);
            preparedStatement.setString(1, departament);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            professor.append(resultSet.getString("name"));
            countProfessor = resultSet.getInt("count");
            resultSet.next();
            associateProfessor.append(resultSet.getString("name"));
            countAssociateProfessor = resultSet.getInt("count");
            resultSet.next();
            assistant.append(resultSet.getString("name"));
            countAssistant = resultSet.getInt("count");
            map.put(String.valueOf(professor), countProfessor);
            map.put(String.valueOf(associateProfessor), countAssociateProfessor);
            map.put(String.valueOf(assistant), countAssistant);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return map;
    }
}
