package pl.info.czerniak.tableviewtest.table;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class Person implements Serializable {
    public static int personCount = 0;
    private SimpleObjectProperty<ImageView> personAvatar;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;

    public void setFirstName(String firstName){
        this.firstName.setValue(firstName);
    }

    public void setLastName(String lastName){
        this.lastName.setValue(lastName);
    }

    public String getFirstName(){
        return this.firstName.get();
    }

    public String getLastName(){
        return this.lastName.get();
    }

    public ImageView getPersonAvatar(){
        return this.personAvatar.get();
    }


    @Override
    public String toString() {
        return "Imię: " + firstName.getValue() + " " + "Nazwisko: " + lastName.getValue();
    }

    public Person(String firstName, String lastName, String sex){
        try {
            if(sex.equals("man")){
                Image avatar = new Image(new FileInputStream("/home/andy/Dokumenty/Programowanie/javastart/tableviewtest/src/main/resources/img/boy.png"),50,50,true,true);
                this.personAvatar = new SimpleObjectProperty<ImageView>(new ImageView(avatar));
                Person.personCount = Person.personCount + 1;
            } else if(sex.equals("woman")){
                Image avatar = new Image(new FileInputStream("/home/andy/Dokumenty/Programowanie/javastart/tableviewtest/src/main/resources/img/girl.png"),50,50,true,true);
                this.personAvatar = new SimpleObjectProperty<ImageView>(new ImageView(avatar));
                Person.personCount = Person.personCount + 1;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
    }
}
