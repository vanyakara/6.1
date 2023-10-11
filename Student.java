/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Ваня
 */
class Student {
    private String fName;
    private String lName;
    private String fNum;
    private int yearS;
    private String semester;
    private String EGN;
    public Student(String fName, String lName, String fNum, int yearS, String semester, String EGN) throws InvalidDataException{
        if(fName.isEmpty()||lName.isEmpty()||fNum.isEmpty()||yearS<1||semester.isEmpty()||isEGNValid(EGN)){
            throw new InvalidDataException("Nevalidni danni za studenta.");
        }
        this.fName=fName;
        this.lName=lName;
        this.fNum=fNum;
        this.yearS=yearS;
        this.semester=semester;
        this.EGN=EGN;
    }
    public void printInfo(){
        System.out.println("Ime: "+fName);
        System.out.println("Familia: "+lName);
        System.out.println("Faculteten nomer: "+fNum);
        System.out.println("God na obuchenie: "+yearS);
        System.out.println("Semester: "+semester);
        System.out.println("EGN: "+EGN);
        System.out.println();
    }
    public static boolean isEGNValid(String EGN){
        if(EGN.length()!=10){
            return false;
        }
        try{
            Long.parseLong(EGN);
        }catch(NumberFormatException e){
            return false;
        }
        String datePart=EGN.substring(0,6);
        DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("yyMMdd");
        try{
            LocalDate.parse(datePart, dateFormat);
        }catch(Exception e){
            return false;
        }
        int[]weights={2,4,8,5,10,9,7,3,6};
        int sum=0;
        for(int i=0;i<9;i++){
            sum+=(EGN.charAt(i)-'0')*weights[i];
        }
        int reminder=sum%11;
        int controlDigit=(reminder==10)?0:reminder;
        return controlDigit==EGN.charAt(9)-'0';
    }
}
