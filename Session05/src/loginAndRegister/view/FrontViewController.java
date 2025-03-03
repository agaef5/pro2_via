package loginAndRegister.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import loginAndRegister.viewModel.LoginViewModel;
import loginAndRegister.viewModel.RegisterViewModel;

import java.io.IOException;

public class FrontViewController
{
  @FXML
  private Button loginButton;

  @FXML
  private Button registerButton;


  @FXML
  void onLoginPressed(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
    Parent loginPage = loader.load();
    LoginViewController loginViewController = loader.getController();
    loginViewController.initialize();
    Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(loginPage));
    stage.show();

  }

  @FXML
  void onRegisterButtonPressed(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
    Parent registerPage = loader.load();
    RegisterViewController registerViewController = loader.getController();
    registerViewController.initialize();
    Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(registerPage));
    stage.show();

  }
}
