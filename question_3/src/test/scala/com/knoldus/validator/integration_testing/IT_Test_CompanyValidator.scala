package com.knoldus.validator.integration_testing

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.scalatest.funsuite.AnyFunSuite

class IT_Test_CompanyValidator extends AnyFunSuite{
  val companyValidator = new CompanyValidator(companyReadDto = new CompanyReadDto,emailValidator = new EmailValidator)
// Integration testing for the methods of CompanyValidator class by providing User class's objects.

  val company1: Company =Company("HCL", "HCL@gmail.com", "noida")
  test("Correct company name & EmailID"){
    assert(companyValidator.isCompanyValid(company1))
    assert(companyValidator.isEmailValid(company1))
  }

  val company2: Company =Company("HCL", "HCLgmail.com", "noida")
  test("Correct company name & Wrong EmailID"){
    println()
    assert(!companyValidator.isCompanyValid(company2)) // Its true because HCL does not exist already
    assert(!companyValidator.isEmailValid(company2)) // Its false because mailId does not contain "@"
  }

  val company3: Company =Company("Knoldus", "knoldus@gmail.com", "noida")
  test("Wrong  company name & Correct EmailID"){
    println()
    assert(!companyValidator.isCompanyValid(company3)) //Its false beacause company already exist
    assert(companyValidator.isEmailValid(company3)) // Its true because emailID pattern is correct
  }

  val company4: Company =Company("Knoldus", "knoldusgmail.com", "noida")
  test("Wrong company name & EmailID"){
    println()
    assert(!companyValidator.isCompanyValid(company4))//Its false because company already exist
    assert(!companyValidator.isEmailValid(company4)) //Its false because mail is wrong
  }


}
