package com.knoldus.request.integration_testing

import com.knoldus.db.{CompanyReadDto, UserReadDto}
import com.knoldus.models.User
import com.knoldus.request.UserImpl
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.funsuite.AsyncFunSuite

class IT_Test_UserImpl extends AsyncFunSuite{

  val userImpl = new UserImpl(userValidator = new UserValidator(userReadDto = new UserReadDto,
                                                                companyReadDto = new CompanyReadDto,
                                                                emailValidator = new EmailValidator
                                                                )
                              )

  // Integration testing for the methods of UserImpl class by providing wanted class's objects.

  val user1 : User = User("Yash","Gupta",21,50000,"Engineer","Knoldus","yashgupta@knoldus.com")
  test("Correct user, Company name & EmailId"){
    assert(userImpl.createUser(user1).contains(user1.emailId))
  }

  val user2 : User = User("Suresh","Gupta",21,50000,"Engineer","Knoldus","yashgupta@knoldus.com")
  test("Wrong user name & Correct Company name & EmailId"){
    println()
    assert(!userImpl.createUser(user2).contains(user2.emailId))
  }

  val user3 : User = User("Yash","Gupta",21,50000,"Engineer","Google","yashgupta@knoldus.com")
  test("Correct user,EmailId & Wrong Company name"){
    println()
    assert(!userImpl.createUser(user3).contains(user3.emailId))
  }

  val user4 : User = User("Yash","Gupta",21,50000,"Engineer","Knoldus","yashguptaknoldus.com")
  test("Correct user, Company name & Wrong EmailId"){
    println()
    assert(!userImpl.createUser(user4).contains(user4.emailId))
  }

  val user5 : User = User("Suresh","Gupta",21,50000,"Engineer","Google","yashguptaknoldus.com")
  test("Wrong user, Company name & EmailId"){
    println()
    assert(!userImpl.createUser(user5).contains(user5.emailId))
  }

  val user6 : User = User("Kannu","Gupta",21,50000,"Engineer","Knoldus","kannugupta@knoldus.com")
  test("Correct username, Company name & EmailId"){
    println()
    assert(userImpl.createUser(user6).contains(user6.emailId))
  }


}
