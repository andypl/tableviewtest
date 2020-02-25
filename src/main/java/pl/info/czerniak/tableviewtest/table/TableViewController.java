package pl.info.czerniak.tableviewtest.table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import pl.info.czerniak.tableviewtest.table.Person;

public class TableViewController {

    @FXML
    private TableView<Person> tableView;

    @FXML
    private TableColumn<Person, ImageView> personAvatar;

    @FXML
    private TableColumn<Person, String> personName;

    @FXML
    private TableColumn<Person, String> personSurname;

    @FXML
    private ImageView imageViewAvatarMan;

    @FXML
    private ImageView imageViewAvatarWoman;

    @FXML
    private RadioButton radioButtonMan;

    @FXML
    private RadioButton radioButtonWoman;

    @FXML
    private TextField personFirstName;

    @FXML
    private TextField personLastName;

    @FXML
    private TextField logTextField;

    @FXML
    private Button clearTableButton;

    @FXML
    private Button addPersonButton;
    private ObservableList<Person> personObservableList = FXCollections.observableArrayList();

    @FXML
    private TextField textFieldPersonCount;

    private void configureAddButton(){
        addPersonButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(personFirstName.getText().isEmpty() || personLastName.getText().isEmpty()){
                    logTextField.setText("Uzupełnij imię i nazwisko!");
                }else{
                    if(radioButtonMan.isSelected()){
                        personObservableList.add(new Person(personFirstName.getText(), personLastName.getText(),"man"));
                        textFieldPersonCount.setText(String.valueOf((Person.personCount)));
                        logTextField.setText("Dodano: " + personFirstName.getText() + " " + personLastName.getText());

                    } else if(radioButtonWoman.isSelected()){
                        personObservableList.add(new Person(personFirstName.getText(), personLastName.getText(),"woman"));
                        textFieldPersonCount.setText(String.valueOf((Person.personCount)));
                        logTextField.setText("Dodano: " + personFirstName.getText() + " " + personLastName.getText());
                    } else {
                        logTextField.setText("Nie wybrano płci osoby!");
                    }

            }}
        });
    }
    private void configureClearButton(){
        clearTableButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(personObservableList.isEmpty()){
                    logTextField.setText("Tabela jest pusta!");
                }else{
                    tableView.getItems().clear();
                    logTextField.setText("Tabela została wyczyszczona!");
                    Person.personCount = 0;
                }
            }
        });
    }

    private void configureTable(){
        personAvatar.setCellValueFactory(new PropertyValueFactory<>("personAvatar"));
        personName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        personSurname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    }

    private void addDataToTable(){
        tableView.setItems(personObservableList);
    }

    private void configurePersonAvatars(){
        Image manAvatar = null;
        Image womanAvatar = null;
        try {
            manAvatar = new Image(new FileInputStream("/home/andy/Dokumenty/Programowanie/javastart/tableviewtest/src/main/resources/img/boy.png"));
            womanAvatar =  new Image(new FileInputStream("/home/andy/Dokumenty/Programowanie/javastart/tableviewtest/src/main/resources/img/girl.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.imageViewAvatarMan.setImage(manAvatar);
        this.imageViewAvatarMan.setFitHeight(50);
        this.imageViewAvatarMan.setFitWidth(50);
        this.imageViewAvatarMan.setPreserveRatio(true);
        this.imageViewAvatarMan.setSmooth(true);

        this.imageViewAvatarWoman.setImage(womanAvatar);
        this.imageViewAvatarWoman.setFitHeight(50);
        this.imageViewAvatarWoman.setFitWidth(50);
        this.imageViewAvatarWoman.setPreserveRatio(true);
        this.imageViewAvatarWoman.setSmooth(true);
    }

    public void initialize(){
        configureTable();
        addDataToTable();
        configureAddButton();
        configureClearButton();
        configurePersonAvatars();
    }

}
