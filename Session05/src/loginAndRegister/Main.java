package loginAndRegister;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import loginAndRegister.view.FrontViewController;
import loginAndRegister.view.LoginViewController;
import loginAndRegister.view.RegisterViewController;
import loginAndRegister.viewModel.LoginViewModel;
import loginAndRegister.viewModel.RegisterViewModel;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application
{

  public void start(Stage window) throws Exception{
    RegisterViewModel registerViewModel = new RegisterViewModel();
    LoginViewModel loginViewModel = new LoginViewModel();

    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("view/Front.fxml"));
    Scene scene = new Scene(loader.load());

    window.setTitle("Login trial");
    window.setScene(scene);
    window.show();
}

  public static void main(String[] args)
  {
    launch(args);
  }
}