/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany;

import java.util.Scanner;

/**
 *
 * @author Ваня
 */
public class App {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Vuvedete broi studenti: ");
        int n=scan.nextInt();
        Student[]students=new Student[n];
        for(int i=0;i<n;i++){
            try{
                System.out.println("Vuvedete danni za student "+(i+1));
                System.out.print("Ime: ");
                String fName=scan.nextLine();
                System.out.print("Familia: ");
                String lName=scan.nextLine();
                System.out.print("Faculteten nomer: ");
                String fNum=scan.nextLine();
                System.out.print("Godina na obuchenie: ");
                int yearS=Integer.parseInt(scan.nextLine());
                System.out.print("Semester: ");
                String semester=scan.nextLine();
                System.out.print("EGN: ");
                String EGN=scan.nextLine();
                students[i]=new Student(fName,lName,fNum,yearS,semester,EGN);
            }catch(InvalidDataException e){
                System.out.println("Greshka: "+e.getMessage());
                i--;
            }
        }
        System.out.println("Informatsiq za studentite: ");
        for(Student student:students){
            if(student!=null){
                student.printInfo();
            }
        }
    }
}
