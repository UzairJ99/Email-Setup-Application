//UZAIR JAWAID
//Email set up application
//2018-07-17
//Creates an email with randomly generated password for employees

package emailApplication;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class App extends Application implements EventHandler<ActionEvent>
{
	//main method
	public static void main(String[] args) 
	{
		//launches the start method
		launch(args);
	}//end of main
	
	//declaring variables
	Button btnNext, btnBack;
	Label appTitle, firstNamelbl, lastNamelbl, departmentlbl, finished, email, info, passwordlbl;
	TextField firstName, lastName;
	ChoiceBox <String> departmentList;
	ImageView logo;
	Pane layout = new Pane(); //sets up layout pane
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	//start method
	public void start (Stage primaryStage) throws Exception
	  {
	    primaryStage.setTitle("Email Setup Application");
	    
	    btnNext = new Button("Submit");
	    btnNext.setOnAction(this); //makes button interactive
	    btnNext.setId("nextBtn"); //sets the id for CSS and HTML
	    
	    btnBack = new Button("Exit");
	    btnBack.setOnAction(this);
	    btnBack.setId("backBtn");
	    
	    appTitle = new Label ("E-mail Setup");
	    appTitle.setId("title");
	    
	    firstNamelbl = new Label("First Name: ");
	    firstNamelbl.setId("basicLabel");
	    firstName = new TextField();
	    
	    lastNamelbl = new Label("Last Name: ");
	    lastNamelbl.setId("basicLabel");
	    lastName = new TextField();
	    
	    departmentlbl = new Label("Department: ");
	    departmentlbl.setId("basicLabel");
	    departmentList = new ChoiceBox<>();
	    departmentList.getItems().addAll("Sales", "Development", "Accounting");
	    departmentList.setValue("Sales");
	    departmentList.setMinWidth(150);
	    
	    finished = new Label("Email successfully created!");
	    finished.setId("banner");
	    
	    email = new Label();
	    email.setId("finalLabel");
	    email.setMaxWidth(360);
	    email.setAlignment(Pos.CENTER);
	    
	    passwordlbl = new Label();
	    passwordlbl.setId("finalLabel");
	    
	    logo = new ImageView();
	    Image image = new Image("emailApplication/Uzi Prod Logo.png", 100, 100, false, false);
	    logo.setImage(image);
	   
	    
	    //add components
	    layout.getChildren().add(btnNext);
	    layout.getChildren().add(btnBack);
	    layout.getChildren().add(appTitle);
	    layout.getChildren().add(firstNamelbl);
	    layout.getChildren().add(firstName);
	    layout.getChildren().add(lastNamelbl);
	    layout.getChildren().add(lastName);
	    layout.getChildren().add(departmentlbl);
	    layout.getChildren().add(departmentList);
	    layout.getChildren().add(logo);
	    layout.getChildren().add(email);
	    layout.getChildren().add(passwordlbl);
	    layout.getChildren().add(finished);
	    
	    finished.setVisible(false);
	    
	    
	    layout.setId("background");
	    
	    //position components
	    btnNext.setLayoutX(240);
	    btnNext.setLayoutY(295);
	    btnBack.setLayoutX(520);
	    btnBack.setLayoutY(295);
	    appTitle.setLayoutX(40);
	    appTitle.setLayoutY(40);
	    firstNamelbl.setLayoutX(40);
	    firstNamelbl.setLayoutY(110);
	    firstName.setLayoutX(40);
	    firstName.setLayoutY(140);
	    lastNamelbl.setLayoutX(40);
	    lastNamelbl.setLayoutY(190);
	    lastName.setLayoutX(40);
	    lastName.setLayoutY(220);
	    departmentlbl.setLayoutX(40);
	    departmentlbl.setLayoutY(270);
	    departmentList.setLayoutX(40);
	    departmentList.setLayoutY(300);
	    logo.setLayoutX(530);
	    logo.setLayoutY(-5);
	    finished.setLayoutX(240);
	    finished.setLayoutY(110);
	    email.setLayoutX(240);
	    email.setLayoutY(165);
	    passwordlbl.setLayoutX(240);
	    passwordlbl.setLayoutY(190);
	    
	    //create the scene
	    Scene scene = new Scene(layout, 640,380);
	    //gets the CSS style sheet and applies it
	    scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
	    
	    primaryStage.setScene(scene);
	    primaryStage.show();
	  }//end of layout design
	  
	public void handle (ActionEvent e)
	  {
		while(true) //infinite loop so the user can continuously click
		{
		    if (e.getSource() == btnNext)
		    {
		    	
		    	if (firstName.getText().length() > 0 && lastName.getText().length() > 0) 
		    	{
		    		String department = departmentList.getValue();
			    	String password = randomAlphaNumeric(8); //assigns a random password of 8 characters
			    	finished.setVisible(true);
			    	finished.setId("banner");
			    	finished.setText("Email successfully created!");
			    	String emailString = firstName.getText() + "." + lastName.getText() + "@ThisCompany." + department + ".com";
			    	String finalEmail = emailString.toLowerCase(); //changes the email to all lowercase letters
			    	System.out.println("Email successfully created for " + firstName.getText());
			    	System.out.println("Password is: " + password);
			    	System.out.println(finalEmail);
			    	email.setText("E-mail: " + finalEmail);
			    	passwordlbl.setText("Password: " + password);
			    	break; //break loop
		    	} 
		    	else 
		    	{
		    		finished.setVisible(true);
		    		finished.setText("Please fill in the required information");
		    		finished.setId("bannerFailed");
		    	}
		    	
		    }
		    else if (e.getSource() == btnBack) 
		    {
		    	System.exit(0); //exits application
		    }
		    break;
		}
	  }//end of handle event
	
	//function to generate random string
	public static String randomAlphaNumeric(int count) 
	{
		StringBuilder builder = new StringBuilder(); //declare and initialize string builder object
		while (count-- != 0) //count down until the variable count reaches 0
		{
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length()); //store a random integer within the length of the string variable
			builder.append(ALPHA_NUMERIC_STRING.charAt(character)); //find the associated character at that integer and append it to the string
		}
		return builder.toString(); //returns the final string password
		
	}//end of random password function

}//end of application
