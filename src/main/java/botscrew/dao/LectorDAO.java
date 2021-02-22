package botscrew.dao;

import botscrew.util.ConnectionUtil;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class LectorDAO   {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private final String QUERY = "select name from lector where name like CONCAT( '%',?,'%')";

    public LectorDAO() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        connection = ConnectionUtil.openConnection();
    }

    public List<String> findLectorsByName(String name){
        List<String> lectors = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name1 = resultSet.getString("name");
                lectors.add(name1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lectors;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        System.out.println(new LectorDAO().findLectorsByName("e1"));
    }
}
