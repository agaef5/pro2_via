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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import loginAndRegister.viewModel.RegisterViewModel;

import java.io.IOException;

public class RegisterViewController {

  @FXML
  private Button backButton;

  @FXML
  private TextField passwordField;

  @FXML
  private Button registerButton;

  @FXML
  private TextField repeatPasswordField;

  @FXML
  private TextField emailField;

  @FXML
  private Label messageLabel;

  private RegisterViewModel registerViewModel;

  public void initialize(){
      registerViewModel = new RegisterViewModel();
      emailField.textProperty().bindBidirectional(registerViewModel.getEmailProperty());
      passwordField.textProperty().bindBidirectional(registerViewModel.getPasswordProperty());
      repeatPasswordField.textProperty().bindBidirectional(registerViewModel.getRepeatedPasswordProperty());
      messageLabel.textProperty().bind(registerViewModel.getMessageProperty());
      registerButton.disableProperty().bind(registerViewModel.getEnableRegisterButtonProperty());
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
  void onRegister(ActionEvent event) {
    registerViewModel.registerUser();
  }

}
