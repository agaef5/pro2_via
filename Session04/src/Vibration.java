public class Vibration implements PhoneState
{
  @Override public void handleSoundChange(MobilePhone phone)
  {
    phone.setState(new Vibration());
  }
}
