//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MobilePhone
{
      private int volume;
      private PhoneState currentState;
      private PhoneState soundState, vibrateState, silentState;

      public MobilePhone(){
        volume = 0;
        silentState = new Silent();
      }

      public void receiveCall()
      {

      }

      public void receiveText()
      {

      }

      public void turnVolumeUp()
      {
        volume = 100;
      }

      public void turnVolumeDown()
      {
        volume = 0;
      }

      @Override public void toggleVibration()
      {
        vibrationOn = !vibrationOn;
      }

      void setState(PhoneState newState){

      }

  public void setState(SoundVibration soundVibration)
  {
  }
}