package Classes;

//This class provides the information of the patients. And determinate
// the priority of the symptoms.

public class DataPatient implements Comparable<DataPatient> {

    String name, symptoms, priority;

    public DataPatient(String name, String symptoms, String priority){
        this.name = name;
        this.symptoms = symptoms;
        this.priority = priority;
    }

    public int compareTo(DataPatient d){
        return priority.compareTo(d.priority);
    }

}
