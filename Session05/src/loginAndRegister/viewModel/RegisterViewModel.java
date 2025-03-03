package loginAndRegister.viewModel;

import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.print.DocFlavor;

public class RegisterViewModel
{
  private StringProperty emailProperty = new SimpleStringProperty();
  private StringProperty passwordProperty = new SimpleStringProperty();
  private StringProperty repeatedPasswordProperty = new SimpleStringProperty();
  private StringProperty messageProperty = new SimpleStringProperty();
  private BooleanProperty enableRegisterButtonProperty = new SimpleBooleanProperty(true);

  public RegisterViewModel(){
    emailProperty.addListener(this::updateRegisterButtonState);
    passwordProperty.addListener(this::updateRegisterButtonState);
    repeatedPasswordProperty.addListener(this::updateRegisterButtonState);
  }

  public void registerUser(){
    messageProperty.set("");

    if(emailProperty.get() == null || emailProperty.get().isEmpty()){
      messageProperty.set("E-mail cannot be empty");
      return;
    }

    if(passwordProperty.get() == null || passwordProperty.get().isEmpty()){
      messageProperty.set("Password cannot be empty");
      return;
    }

    if (!passwordProperty.get().equals(repeatedPasswordProperty.get())){
      messageProperty.set("Passwords do not match");
      return;
    }

    System.out.println("User registered");
    messageProperty.set("Success");

    emailProperty.set("");
    passwordProperty.set("");
    repeatedPasswordProperty.set("");
  }

  public void updateRegisterButtonState(Observable observable){
    boolean isDisabled = emailProperty.get() == null || emailProperty.get().isEmpty() ||
        passwordProperty.get() == null || passwordProperty.get().isEmpty() ||
        repeatedPasswordProperty.get() == null || repeatedPasswordProperty.get().isEmpty();

    enableRegisterButtonProperty.set(isDisabled);

    System.out.println("Is the button disabled?: " + isDisabled);
}

  public StringProperty getEmailProperty(){
    return emailProperty;
  }

  public StringProperty getPasswordProperty(){
    return passwordProperty;
  }

  public StringProperty getRepeatedPasswordProperty(){
    return repeatedPasswordProperty;
  }

  public StringProperty getMessageProperty(){
    return messageProperty;
  }

  public BooleanProperty getEnableRegisterButtonProperty(){
    return enableRegisterButtonProperty;
  }


}
