/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataapp;

import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UI extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        
        String dbURL = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "Panavision85!";
        
        DB database = new DB(dbURL, user, password);
        
        Scene scene = new Scene(new Group(), 575, 200);
        
        Employee emp = new Employee();
        
        stage.setTitle("Staff Information");
        
        GridPane gp = new GridPane();
        gp.setVgap(5);
        gp.setHgap(10);
        gp.setPadding(new Insets(5, 5, 5, 5));
        
        TextField tfID = new TextField();
        gp.add(new Label("ID"), 0, 0);
        gp.add(tfID, 1, 0);
        
        TextField tfLN = new TextField();
        gp.add(new Label("Last Name"), 0, 1);
        gp.add(tfLN, 1, 1);
        
        TextField tfFN = new TextField();
        gp.add(new Label("First Name"), 2, 1);
        gp.add(tfFN, 3, 1);
        
        TextField tfMI = new TextField();
        tfMI.setMaxWidth(25.0);
        gp.add(new Label("mi"), 4, 1);
        gp.add(tfMI, 5, 1);
        
        TextField tfAddress = new TextField();
        gp.add(new Label("Address"), 0, 2);
        gp.add(tfAddress, 1, 2);
        
        TextField tfCity = new TextField();
        gp.add(new Label("City"), 2, 2);
        gp.add(tfCity, 3, 2);
        
        TextField tfState = new TextField();
        tfState.setMaxWidth(25.0);
        gp.add(new Label("State"), 4, 2);
        gp.add(tfState, 5, 2);
        
        TextField tfPhone = new TextField();
        gp.add(new Label("Telephone"), 0, 3);
        gp.add(tfPhone, 1, 3);
        
        TextField tfEmail = new TextField();
        gp.add(new Label("Email"), 2, 3);
        gp.add(tfEmail, 3, 3);
        
        Button insertBTN = new Button();
        insertBTN.setText("Insert");
        gp.add(insertBTN, 0, 4);
        GridPane.setValignment(insertBTN, VPos.BOTTOM);
        
        Button viewBTN = new Button();
        viewBTN.setText("View");
        viewBTN.setMaxWidth(100.0);
        gp.add(viewBTN, 1, 4);
        GridPane.setValignment(viewBTN, VPos.BOTTOM);
        
        Button updateBTN = new Button();
        updateBTN.setText("Update");
        gp.add(updateBTN, 2, 4);
        GridPane.setValignment(updateBTN, VPos.BOTTOM);
        
        Button clearBTN = new Button();
        clearBTN.setText("Clear");
        gp.add(clearBTN, 3, 4);
        GridPane.setValignment(clearBTN, VPos.BOTTOM);
        
        insertBTN.setOnAction(e -> 
        {try{
            
            emp.setId(Integer.parseInt(tfID.getText()));
            emp.setLastName(tfLN.getText());
            emp.setFirstName(tfFN.getText());
            emp.setMi(tfMI.getText());
            emp.setAddress(tfAddress.getText());
            emp.setCity(tfCity.getText());
            emp.setState(tfState.getText());
            emp.setPhone(tfPhone.getText());
            emp.setEmail(tfEmail.getText());
            
            database.insert(emp);
            
        }catch(Exception error){
                    System.out.println("SQL Exeption: insert");
        }
        });
        
        updateBTN.setOnAction(e ->
        {try{
            
            emp.setId(Integer.parseInt(tfID.getText()));
            emp.setLastName(tfLN.getText());
            emp.setFirstName(tfFN.getText());
            emp.setMi(tfMI.getText());
            emp.setAddress(tfAddress.getText());
            emp.setCity(tfCity.getText());
            emp.setState(tfState.getText());
            emp.setPhone(tfPhone.getText());
            emp.setEmail(tfEmail.getText());


            database.update(emp);
            
        
        }catch(Exception error){
                    System.out.println("sql exception: update");}
        });
        
        clearBTN.setOnAction(e -> {
        try{
            
            emp.setId(Integer.parseInt(tfID.getText()));
            
            database.clear(emp);

            
            
        }catch(Exception error){
            System.out.println("sql exception: clear");
        }
        });
        
        Group root = (Group) scene.getRoot();
        root.getChildren().add(gp);
        stage.setScene(scene);
        stage.show();
        
        
    }
    
}
