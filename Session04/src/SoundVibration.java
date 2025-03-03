public class SoundVibration implements PhoneState
{
  @Override public void handleSoundChange(MobilePhone phone)
  {
    System.out.println();
    phone.setState(new SoundVibration());
  }
}
