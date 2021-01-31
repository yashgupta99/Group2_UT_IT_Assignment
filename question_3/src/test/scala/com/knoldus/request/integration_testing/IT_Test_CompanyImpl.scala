package com.knoldus.request.integration_testing

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.request.CompanyImpl
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.scalatest.funsuite.AsyncFunSuite

class IT_Test_CompanyImpl extends AsyncFunSuite{
  val companyImpl= new CompanyImpl(companyValidator = new CompanyValidator(companyReadDto = new CompanyReadDto,
                                                                            emailValidator = new EmailValidator
                                                                          )
                                  )

  // Integration testing for the methods of CompanyImpl class by providing wanted class's objects.

  val company1: Company =Company("HCL", "HCL@gmail.com", "noida")
  test("Correct company name & EmailID"){
    assert(companyImpl.createCompany(company1).contains(company1.name))
  }

  val company2: Company =Company("HCL", "HCLgmail.com", "noida")
  test("Correct company name & Wrong EmailID"){
    println()
    assert(!companyImpl.createCompany(company2).contains(company2.name))
  }

  val company3: Company =Company("Knoldus", "knoldus@gmail.com", "noida")
  test("Wrong  company name & Correct EmailID"){
    println()
    assert(!companyImpl.createCompany(company3).contains(company3.name))
  }

  val company4: Company =Company("Knoldus", "knoldusgmail.com", "noida")
  test("Wrong company name & EmailID"){
    println()
    assert(!companyImpl.createCompany(company4).contains(company4.name))
  }

  val company5: Company =Company("Diamond", "diamond@gmail.com", "noida")
  test("Correct company's name & EmailID"){
    println()
    assert(companyImpl.createCompany(company5).contains(company5.name))
  }

}
