package dashboard.main;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.*;
import com.jfoenix.controls.JFXDialog.DialogTransition;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.controlsfx.*;

public class LoginController implements Initializable {
	
	@FXML
	private JFXTextField username;
	@FXML 
	private JFXPasswordField password;
	@FXML
	private JFXButton login;
	@FXML
	private JFXButton reset;
	
	public void initialize(URL location, ResourceBundle resources) {

		login.setDefaultButton(true);
		reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	reset(e);
            }
        });;
		//login.setOnMouseClicked(this::loginUser);
		login.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	loginUser(e);
            }
        });;
		
	}
	
	public void loginUser(ActionEvent e)
	{
		String user,pass;
		user=username.getText();
		pass=password.getText();
		if(user.equals("rohan") && pass.equals("rohan"))
		{
			/*JFXTextArea textArea = new JFXTextArea("Logged in Successfully");
			JFXDialogLayout content = new JFXDialogLayout();
			content.setHeading(new Text("Successful"));
			content.setBody(textArea);
			JFXDialog d = new JFXDialog(null,content,DialogTransition.LEFT,true);*/
			//System.out.println("User logged in");
			Optional<ButtonType> alert = new Alert(Alert.AlertType.INFORMATION, "Logged In Successfully!!").showAndWait();
			//closeStage();
			loadMain();
		}
		else
		{
			//JOptionPane.showMessageDialog(null, "Wrong Credentials\nEnter Valid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Wrong credentials");
			username.setText(null);
			password.setText(null);
			Optional<ButtonType> alert = new Alert(Alert.AlertType.ERROR, "Invalid Credentials!\nPlease Enter Correct Details!!").showAndWait();
		}
	}
	
	public void reset(ActionEvent e)
	{
		username.setText(null);
		password.setText(null);
		username.requestFocus();
	}

	void loadMain() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("UI.fxml"));
            Stage stage = new Stage(StageStyle.UNDECORATED);
            stage.setScene(new Scene(parent));
            stage.show();
        }
        catch (IOException ex) {
        	ex.printStackTrace();
        }
    }
	
	/*private void closeStage() {
        ((Stage) username.getScene().getWindow()).close();
    }*/
}
