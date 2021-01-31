package com.knoldus.validator.unit_testing

import com.knoldus.db.{CompanyReadDto, UserReadDto}
import com.knoldus.models.{Company, User}
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.mockito.Mockito.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class UT_Test_UserValidator extends AsyncFlatSpec{

  val MockedUserReadDto: UserReadDto = mock(classOf[UserReadDto])
  val MockedCompanyReadDto: CompanyReadDto = mock(classOf[CompanyReadDto])
  val MockedEmailValidator: EmailValidator = mock(classOf[EmailValidator])
  val userValidator = new UserValidator(MockedUserReadDto,MockedCompanyReadDto,MockedEmailValidator)

  //Unit Testing for UserValidator class by using mocked variable of the UserReadDto/CompanyReadDto/EmailValidator.

  "User Suresh" should "not be Valid due to used UserName" in {
    val user = User("Suresh","Kumar",23,50000,"Engineer","Knoldus","sureshkumar@gmail.com")
    when(MockedUserReadDto.getUserByFName(user.firstName)) thenReturn Some(User("Suresh","Kumar",23,50000,"Engineer","Knoldus","sureshkumar@gmail.com"))
    when(MockedCompanyReadDto.getCompanyByName(user.companyName)) thenReturn Some(Company("Knoldus","Knoldus@gmail.com","noida"))
    when(MockedEmailValidator.emailIdIsValid(user.emailId)) thenReturn true
    val isUserValid = userValidator.isUserValid(user)
    assert(!isUserValid)
  }

  "User Yash" should "be Valid due all correct fields" in {
    val user = User("Yash","Gupta",23,50000,"Engineer","Knoldus","yashgupta@gmail.com")
    when(MockedUserReadDto.getUserByFName(user.firstName)) thenReturn None
    when(MockedCompanyReadDto.getCompanyByName(user.companyName)) thenReturn Some(Company("Knoldus","Knoldus@gmail.com","noida"))
    when(MockedEmailValidator.emailIdIsValid(user.emailId)) thenReturn true
    val isUserValid = userValidator.isUserValid(user)
    assert(isUserValid)

  }

  "User Shubham" should "not be Valid due to wrong Company name" in {
    val user = User("Shubham","Gupta",21,50000,"Engineer","Google","yashgupta@gmail.com")
    when(MockedUserReadDto.getUserByFName(user.firstName)) thenReturn None
    when(MockedCompanyReadDto.getCompanyByName(user.companyName)) thenReturn None
    when(MockedEmailValidator.emailIdIsValid(user.emailId)) thenReturn true
    println()
    val isUserValid = userValidator.isUserValid(user)
    assert(!isUserValid)
  }

  "User Rahul" should "not be Valid wrong pattern of emailId" in {
    val user = User("Rahul","Gupta",21,50000,"Engineer","Knoldus","rahul gupta@gmail.com")
    when(MockedUserReadDto.getUserByFName(user.firstName)) thenReturn None
    when(MockedCompanyReadDto.getCompanyByName(user.companyName)) thenReturn Some(Company("Knoldus","Knoldus@gmail.com","noida"))
    when(MockedEmailValidator.emailIdIsValid(user.emailId)) thenReturn false
    println()
    val isUserValid = userValidator.isUserValid(user)
    assert(!isUserValid)
  }
}
