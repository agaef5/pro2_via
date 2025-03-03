package loginAndRegister.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import loginAndRegister.viewModel.LoginViewModel;

import java.io.IOException;

public class LoginViewController {

  @FXML
  private Button backButton;

  @FXML
  private TextField emailField;

  @FXML
  private Button loginButton;

  @FXML
  private Label messageLabel;

  @FXML
  private TextField passwordField;

  LoginViewModel loginViewModel;

  public void initialize(){
    loginViewModel = new LoginViewModel();
    emailField.textProperty().bindBidirectional(loginViewModel.getEmailProperty());
    passwordField.textProperty().bindBidirectional(loginViewModel.getPasswordProperty());
    messageLabel.textProperty().bind(loginViewModel.getMessageProperty());
    loginButton.disableProperty().bind(loginViewModel.getEnableLoginButtonProperty());
  }

  @FXML
  void onBack(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Front.fxml"));
    Parent frontPage = loader.load();
    FrontViewController frontViewController = loader.getController();
    Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(frontPage));
    stage.show();
  }

  @FXML
  void onLogin(ActionEvent event) {
    loginViewModel.loginUser();
  }

}
