import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.*;

public class CRUDHibernate {


    public static void createCourse(Course course) {
        Connector connector = new Connector();
        Session session = connector.getSession();


        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
        session.close();

        System.out.println("\nThe course has been successfully created");
        System.out.println();

    }

    public static void viewAll(String url, String user, String pass) {
        try (Connection connection = DriverManager.getConnection(url, user, pass);) {
            Statement statement = connection.createStatement();

            ResultSet set = statement.executeQuery("SELECT * FROM SchoolDB.Courses;");
            while (set.next()) {
                System.out.println("id: " + set.getInt(1) + "    " + set.getString(2) + "   " + set.getString(3));
            }

            System.out.println("\nRead data successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCourse(int id, String title, String duration) {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            Course course = session.get(Course.class, id);
            course.setTitle(title);
            course.setDuration(duration);
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
            System.out.println("\nThe data has been successfully updated\n");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("\nThere is no course with this id");
        }
    }

    public static void deleteCourse(int id) {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            Course course = session.get(Course.class, id);
            session.delete(course);
            session.beginTransaction();
            session.getTransaction().commit();
            System.out.println("\nThe deletion was completed successfully\n");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("\nDeletion is not possible, there is no such id in the database\n");
        }
    }


}
