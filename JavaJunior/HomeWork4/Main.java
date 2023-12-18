public class Main {
    public static void main(String[] args) {


        String url = "jdbc:mysql://192.168.77.137:3306";
        String user = "root";
        String pass = "admin";

        CreateDBJDBC.createDB(url, user, pass);




        Course course = new Course("Mathematics", "90 Minutes");

        CRUDHibernate.createCourse(course);
        CRUDHibernate.viewAll(url, user, pass);

        CRUDHibernate.updateCourse(5, "Economic theory", "95 Minutes");
        CRUDHibernate.deleteCourse(1);

        CRUDHibernate.viewAll(url, user, pass);

    }
}
