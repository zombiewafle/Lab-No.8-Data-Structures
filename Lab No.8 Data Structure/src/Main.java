import Classes.DataPatient;
import Classes.VectorHeap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Creation of the heap
        VectorHeap vectorHeap = new VectorHeap();
        //----------------------------------


        //Menu's
        String  menu = "Menu\n" +
                "\n1. Patients" +
                "\n2. Exit";

        String fileMenu = "Menu\n" +
                "\n Please enter a txt file";
        //----------------------------------

        //Variables
        boolean go = false;
        boolean file =  false;
        BufferedReader input = null;
        Scanner sc = new Scanner(System.in);
        String op = sc.nextLine();
        //----------------------------------

        //Part that read the txt file
        System.out.println(fileMenu);
        String filePath = sc.nextLine();
        String nm;

        try{
            input = new BufferedReader(new FileReader(filePath));
            while((nm = input.readLine()) != null){
                String[] patientsInfo = nm.split(",");
                String patientName = patientsInfo[0];
                String patientSymptoms = patientsInfo[1];
                String patientPriority = patientsInfo[2];
                DataPatient dataPatient = new DataPatient(patientName, patientSymptoms, patientPriority);
                vectorHeap.add(dataPatient);
                file = true;


            }

        } catch (IOException e) {
            file = false;
            e.printStackTrace();
        }
        //----------------------------------

        //Switch case part
        while(file == true){
            switch (op){
                case "1":
                    if(vectorHeap.size() > 0){
                        System.out.println(vectorHeap.remove());
                    }else {
                        System.out.println("Error there is no patients on the heap\n");
                    }
                    break;
                case "2":
                    System.out.println("Goodbye and thanks for using my program");
                    break;
                default:
                    System.out.println("Error, invalid option");
                    break;

            }
        }
        //----------------------------------




    }
}
