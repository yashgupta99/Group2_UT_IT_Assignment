package com.knoldus.validator.integration_testing

import com.knoldus.db.{CompanyReadDto, UserReadDto}
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.funsuite.AsyncFunSuite

class IT_Test_UserValidator extends AsyncFunSuite{
  val userValidator = new UserValidator(userReadDto =new  UserReadDto,
                                        companyReadDto =new CompanyReadDto,
                                        emailValidator =new  EmailValidator)

//Integration testing for the methods of UserValidation class

  val user1 : User = User("Yash","Gupta",21,50000,"Engineer","Knoldus","yashgupta@knoldus.com")
  test("Correct user, Company name & EmailId"){
    assert(userValidator.isUserValid(user1))
    assert(userValidator.isCompanyExistInDb(user1))
    assert(userValidator.isEmailValid(user1))
  }

  val user2 : User = User("Suresh","Gupta",21,50000,"Engineer","Knoldus","yashgupta@knoldus.com")
  test("Wrong user name & Correct Company name & EmailId"){
    assert(!userValidator.isUserValid(user2))
    assert(userValidator.isCompanyExistInDb(user2))
    assert(userValidator.isEmailValid(user2))
  }

  val user3 : User = User("Yash","Gupta",21,50000,"Engineer","Google","yashgupta@knoldus.com")
  test("Correct user,EmailId & Wrong Company name"){
    println()
    assert(!userValidator.isUserValid(user3))
    assert(!userValidator.isCompanyExistInDb(user3))
    assert(userValidator.isEmailValid(user3))
  }

  val user4 : User = User("Yash","Gupta",21,50000,"Engineer","Knoldus","yashguptaknoldus.com")
  test("Correct user, Company name & Wrong EmailId"){
    println()
    assert(!userValidator.isUserValid(user4))
    assert(userValidator.isCompanyExistInDb(user4))
    assert(!userValidator.isEmailValid(user4))
  }

  val user5 : User = User("Suresh","Gupta",21,50000,"Engineer","Google","yashguptaknoldus.com")
  test("Wrong user, Company name & EmailId"){
    println()
    assert(!userValidator.isUserValid(user5))
    assert(!userValidator.isCompanyExistInDb(user5))
    assert(!userValidator.isEmailValid(user5))
  }






}
