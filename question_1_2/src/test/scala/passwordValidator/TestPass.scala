package passwordValidator
import passwordValidation.{PassValidator,CheckPassword}
import org.mockito.Mockito.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class TestPass extends AsyncFlatSpec{
  val MockedValidation: PassValidator = mock(classOf[PassValidator])
  val password = new CheckPassword(MockedValidation)

  // Unit Test Cases for Email Validation

  "Password with every condition" should "be Valid" in {
    when(MockedValidation.isValid("Y@sh1234")) thenReturn true
    val result = password.getPass("Y@sh1234")
    assert(result == "yes")
  }

  "Password with blank space" should "be invalid" in {
    when(MockedValidation.isValid("Y@sh 1234")) thenReturn false
    val result = password.getPass("Y@sh 1234")
    assert(result == "no")
  }

  "Password without special symbol" should "be invalid" in {
    when(MockedValidation.isValid("Yash1234")) thenReturn false
    val result = password.getPass("Yash1234")
    assert(result == "no")
  }

  "Password without a single small letter" should "be invalid" in {
    when(MockedValidation.isValid("Y@SH1234")) thenReturn false
    val result1 = password.getPass("Y@SH1234")
    assert(result1 == "no")
  }

  "Password without Capital letter" should "be invalid" in {
    when(MockedValidation.isValid("y@sh1234")) thenReturn false
    val result1 = password.getPass("y@sh1234")
    assert(result1 == "no")
  }

  "Password length less then 8 letters" should "be invalid" in {
    when(MockedValidation.isValid("Y@sh123")) thenReturn false
    val result1 = password.getPass("Y@sh123")
    assert(result1 == "no")
  }

  "Password length more then 15 letters" should "be invalid" in {
    when(MockedValidation.isValid("Y@shhhhhhh1234569874")) thenReturn false
    val result1 = password.getPass("Y@shhhhhhh1234569874")
    assert(result1 == "no")
  }
  "Password" should "be Valid" in {
    when(MockedValidation.isValid("Y@sh12345")) thenReturn true
    val result = password.getPass("Y@sh12345")
    assert(result == "yes")
  }
}
