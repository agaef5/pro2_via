package loginAndRegister.viewModel;

import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel
{
  private StringProperty emailProperty = new SimpleStringProperty();
  private StringProperty passwordProperty = new SimpleStringProperty();
  private StringProperty messageProperty = new SimpleStringProperty();
  private BooleanProperty enableLoginButtonProperty = new SimpleBooleanProperty(true);

  public LoginViewModel(){
    emailProperty.addListener(this::updateLoginButtonState);
    passwordProperty.addListener(this::updateLoginButtonState);
  }

  public void loginUser(){
    messageProperty.set("");

    if(emailProperty.get() == null || emailProperty.get().isEmpty()){
      messageProperty.set("E-mail cannot be empty");
      return;
    }

    if(passwordProperty.get() == null || passwordProperty.get().isEmpty()){
      messageProperty.set("Password cannot be empty");
      return;
    }

    System.out.println("User logged in");
    messageProperty.set("Success");

    emailProperty.set("");
    passwordProperty.set("");
  }

  public void updateLoginButtonState(Observable observable){
    boolean isDisabled = emailProperty.get() == null || emailProperty.get().isEmpty() ||
        passwordProperty.get() == null || passwordProperty.get().isEmpty();
    enableLoginButtonProperty.set(isDisabled);

    System.out.println("Is the button disabled?: " + isDisabled);
  }

  public StringProperty getEmailProperty(){
    return emailProperty;
  }

  public StringProperty getPasswordProperty(){
    return passwordProperty;
  }

  public StringProperty getMessageProperty(){
    return messageProperty;
  }

  public BooleanProperty getEnableLoginButtonProperty(){
    return enableLoginButtonProperty;
  }
}
