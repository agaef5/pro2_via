package loginAndRegister.view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import loginAndRegister.viewModel.LoginViewModel;
import loginAndRegister.viewModel.RegisterViewModel;

import java.util.HashMap;

public class ScreenController {
  private HashMap<String, Pane> screenMap = new HashMap<>();
  private Scene main;

  LoginViewModel loginViewModel = new LoginViewModel();
  RegisterViewModel registerViewModel = new RegisterViewModel();

  public ScreenController(Scene main) {
    this.main = main;
  }

  protected void addScreen(String name, Pane pane){
    screenMap.put(name, pane);
  }

  protected void removeScreen(String name){
    screenMap.remove(name);
  }

  protected void activate(String name){
    main.setRoot( screenMap.get(name) );
  }
}