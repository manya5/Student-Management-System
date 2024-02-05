package org.example;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class StudentDao {
    static Connection con;

    static int createStudent(Studentinfo student) throws SQLException {
        String query = " insert into students values(?,?,?)";
        con = DBconnection.createConnection();
        PreparedStatement pr = con.prepareStatement(query);
        pr.setInt(1, student.getId());
        pr.setInt(2, student.getAge());
        pr.setString(3, student.getName());
        int res = pr.executeUpdate();
        if (res != 0) System.out.println("insert successfully");
        return res;
    }

    static void getAllStudents() {
        con = DBconnection.createConnection();
        String query = "select * from students";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +
                        rs.getInt(2) + " " +
                        rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void getStudentByID(int id) {
        con = DBconnection.createConnection();
        String query = "select * from students where id =" + id;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +
                        rs.getInt(2) + " " +
                        rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void updateStudentById(int id, String updatedName) {
        con = DBconnection.createConnection();
        String query = "update students set stu_name =? where id =?";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, updatedName);
            pr.setInt(2, id);
            int a = pr.executeUpdate();
            if (a!= 0) System.out.println("Updated successfully");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    static void deleteStudentById(int id) {
        con = DBconnection.createConnection();
        String query = "delete from students where id =?";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, id);
            int a = pr.executeUpdate();
            if (a != 0) {
                System.out.println("deleted successfully");
            } else {
                System.out.println("Student with ID " + id + " not found");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}