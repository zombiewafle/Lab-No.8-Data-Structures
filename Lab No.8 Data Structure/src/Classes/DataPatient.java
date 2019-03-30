package Classes;

/*This class provides the information of the patients. And determinate
 the priority of the symptoms.

 Using the form of the Java Collections Framework
 and my implementation without the Java Collection Framework.

 The easiest form is adding getters and setters of the name, symptoms, and
 the priority and using a toString to show the information.
 */


public class DataPatient implements Comparable<DataPatient> {

    String name, symptoms, priority;

    public DataPatient(String name, String symptoms, String priority){
        this.name = name;
        this.symptoms = symptoms;
        this.priority = priority;
    }

    public String getName(){
        return name;
    }

    public String getSymptoms(){
        return symptoms;
    }

    public String getPriority(){
        return priority;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSymptoms(String symptoms){
        this.symptoms = symptoms;
    }

    public void setPriority(String priority){
        this.priority = priority;
    }

    public int compareTo(DataPatient d){
        return priority.compareTo(d.priority);
    }

    public String toString(){
        return "\nPatient:\n" +
                "\nName:" + getName() +
                "\nSymptoms: " + getSymptoms() +
                "\nPriority: " + getPriority();
    }
}
