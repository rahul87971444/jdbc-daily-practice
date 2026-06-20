import java.sql.*;
import java.util.Scanner;
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Connection con =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "password");
            while(true) {
                System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Student");
                System.out.println("2. Search Student");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Display All Students");
                System.out.println("6. Exit");
                System.out.print("Enter Choice: ");
                int choice = sc.nextInt();
                switch(choice) {
                    case 1:
                        PreparedStatement ps1 =
                            con.prepareStatement(
                                "INSERT INTO Student VALUES(?, ?)");
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter Name: ");
                        String name = sc.next();
                        ps1.setInt(1, id);
                        ps1.setString(2, name);
                        ps1.executeUpdate();
                        System.out.println("Student Added");
                        break;
                    case 2:
                        PreparedStatement ps2 =
                            con.prepareStatement(
                                "SELECT * FROM Student WHERE id=?");
                        System.out.print("Enter ID: ");
                        id = sc.nextInt();
                        ps2.setInt(1, id);
                        ResultSet rs =
                            ps2.executeQuery();
                        if(rs.next()) {
                            System.out.println(
                                rs.getInt("id") + " " +
                                rs.getString("name"));
                        } else {
                            System.out.println(
                                "Student Not Found");
                        }
                        break;
                    case 3:
                        PreparedStatement ps3 =
                            con.prepareStatement(
                                "UPDATE Student SET name=? WHERE id=?");
                        System.out.print("Enter ID: ");
                        id = sc.nextInt();
                        System.out.print("Enter New Name: ");
                        name = sc.next();
                        ps3.setString(1, name);
                        ps3.setInt(2, id);
                        ps3.executeUpdate();
                        System.out.println(
                            "Student Updated");
                        break;
                    case 4:
                        PreparedStatement ps4 =
                            con.prepareStatement(
                                "DELETE FROM Student WHERE id=?");
                        System.out.print("Enter ID: ");
                        id = sc.nextInt();
                        ps4.setInt(1, id);
                        ps4.executeUpdate();
                        System.out.println(
                            "Student Deleted");
                        break;
                    case 5:
                        Statement st =
                            con.createStatement();
                        ResultSet rsAll =
                            st.executeQuery(
                                "SELECT * FROM Student");
                        while(rsAll.next()) {
                            System.out.println(
                                rsAll.getInt("id") + " " +
                                rsAll.getString("name"));
                        }
                        break;
                    case 6:
                        con.close();
                        sc.close();
                        System.out.println("Thank You");
                        System.exit(0);
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
