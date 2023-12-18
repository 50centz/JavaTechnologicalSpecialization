

import java.sql.*;

public class CreateDBJDBC {


    public static void createDB(String url, String user, String pass) {

        try (Connection connection = DriverManager.getConnection(url, user, pass);) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE SCHEMA IF NOT EXISTS `SchoolDB`");
            statement.execute("CREATE TABLE `SchoolDB`.`Courses` (`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, `title` VARCHAR(45) NULL, `duration` VARCHAR(45) NULL);");
            System.out.println("The database has been successfully created");

        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("The database has already been created");
        }
    }
}
