package com.knoldus.validator.integration_testing

import com.knoldus.validator.EmailValidator
import org.scalatest.funsuite.AnyFunSuite

class IT_Test_EmailValidator extends AnyFunSuite{
  val emailValidator = new EmailValidator

//Integration testing where EmailValidator function is tested by given values

  // Whereas I only use those 4 condition which are given in Group1's question 1 to validate the email ID.

  //Correct email "yashgupta@gmail.com"
  test("yashgupta@gmail.com valid"){
    assert(emailValidator.emailIdIsValid("yashgupta@gmail.com"))
  }

  //Wrong email "yashguptagmail.com" because it does not contain "@"
  test("yashguptagmail.com not valid"){
    assert(!emailValidator.emailIdIsValid("yashguptagmail.com"))
  }

  //Wrong email "yashgupta@gmail.col" because it does not contain ".com/.net/.org"
  test("yashgupta@gmail.col not valid"){
    assert(!emailValidator.emailIdIsValid("yashgupta@gmail.col"))
  }

  //Wrong email "yash gupta@gmail.com" because it contains " "
  test("yash gupta@gmail.com not valid"){
    assert(!emailValidator.emailIdIsValid("yash gupta@gmail.com"))
  }

  //Right email "yash23gupta@gmail.com" because it contains "23"
  test("yashg23gupta@gmail.com not valid"){
    assert(emailValidator.emailIdIsValid("yash23gupta@gmail.com"))
  }

}
