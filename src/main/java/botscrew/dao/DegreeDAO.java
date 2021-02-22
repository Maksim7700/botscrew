package botscrew.dao;

import botscrew.util.ConnectionUtil;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class DegreeDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private final String QUERY = "select count(*) from degree d inner join lector l on d.id = l.deg_id inner join departament t on t.id=l.dep_id where t.name = ?1";

    public DegreeDAO() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        connection = ConnectionUtil.openConnection();
    }


}
