package edu.matc.persistence;

import edu.matc.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM user";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.error("SearchUser.getAllUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            logger.error("SearchUser.getAllUsers()...Exception: " + e);
        }
        return users;
    }

    

    public List<User> getAUser(String lastName) {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM user where last_name = '" + lastName + "';";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.error("SearchUser.getAUser()...SQL Exception: " + e);
        } catch (Exception e) {
            logger.error("SearchUser.getAUser()...Exception: " + e);
        }
        return users;
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setId(Integer.parseInt(results.getString("id")));
        user.setDateOfBirth(results.getDate("date_of_birth").toLocalDate());
        user.setUserName(results.getString("user_name"));

        return user;
    }



}