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
        VectorHeap vH = new VectorHeap();
        //----------------------------------


        //Menu's
        String  menu = "Menu\n" +
                "\n1. Patients using Java Collection Framework form" +
                "\n2. Patients using my implementation" +
                "\n3. Exit";

        String fileMenu = "Menu\n" +
                "\n Please enter a txt file";
        //----------------------------------

        //Variables
        boolean go = false;
        boolean file =  false;
        BufferedReader input = null;
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        //----------------------------------
        //Part that read the txt file
        String patientFilePath = sc.nextLine();
        String patient;

        try{
            input = new BufferedReader(new FileReader(patientFilePath));
            while ((patient = input.readLine()) != null){
                String[] patientsInfo = patient.split(",");
                String patientsName = patientsInfo[0];
                String patientSymptoms = patientsInfo[1];
                String patientsPriority = patientsInfo[2];
                DataPatient d = new DataPatient(patientsName, patientSymptoms, patientsPriority);
                vH.add(d);
                file = true;
            }

        }catch (IOException e){
            file = false;
            e.printStackTrace();
        }

        //----------------------------------
        //Part that read the txt file in the Java Collections Framework.
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
                case 1:
                    if(vectorHeap.size() > 0){
                        System.out.println(vectorHeap.remove());
                    }else {
                        System.out.println("Error there is no patients on the heap\n");
                    }
                    break;

                case 2:
                    if(vectorHeap.size() > 0){
                        System.out.println(vectorHeap.remove());
                    }else {
                        System.out.println("Error there is no patients on the heap\n");
                    }
                    break;
                case 3:
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
