package org.example;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO STUDENT MANAGEMENT SYSTEM");
        do {
            System.out.println("ENTER 1 FOR CREATING STUDENT\n" +
                    "ENTER 2 FOR FETCHING ALL THE STUDENTS\n" +
                    "ENTER 3 FOR FETCHING STUDENT BY ID\n" +
                    "ENTER 4 FOR UPDATE STUDENT BY ID\n" +
                    "ENTER 5 FOR DELETING STUDENT BY ID\n" +
                    "ENTER 6 FOR EXITING THE PROGRAM");
            int n = sc.nextInt();
            switch (n) {
                case 1 -> {
                    System.out.println("ENTER STUDENT ID");
                    int ID = sc.nextInt();
                    System.out.println("ENTER STUDENT AGE");
                    int AGE = sc.nextInt();
                    sc.nextLine(); // Consume the newline character left by nextInt()
                    System.out.println("ENTER STUDENT NAME");
                    String NAME = sc.nextLine();
                    Studentinfo student = new Studentinfo(ID, AGE, NAME);
                    try {
                        StudentDao.createStudent(student);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                }
                case 2 -> {
                    StudentDao.getAllStudents();
                }
                case 3 -> {
                    System.out.println("Enter id of Student which you have to fetch");
                    int id = sc.nextInt();
                    StudentDao.getStudentByID(id);
                }
                case 4 -> {
                    System.out.println("Enter id of Student which want to update");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter update name");
                    String name = sc.nextLine();
                    StudentDao.updateStudentById(id,name);
                }
                case 5 -> {
                    System.out.println("Enter id of student which you want to delete");
                    int id = sc.nextInt();
                    StudentDao.deleteStudentById(id);
                }
                case 6 -> System.exit(0);
            }
        } while (true);
    }
}
