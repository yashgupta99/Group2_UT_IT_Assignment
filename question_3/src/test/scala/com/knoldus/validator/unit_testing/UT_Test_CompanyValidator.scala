package com.knoldus.validator.unit_testing

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.mockito.Mockito.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class UT_Test_CompanyValidator extends AsyncFlatSpec{

  val MockedCompanyReadDto: CompanyReadDto = mock(classOf[CompanyReadDto])
  val MockedEmailValidator: EmailValidator = mock(classOf[EmailValidator])
  val companyValidator = new CompanyValidator(MockedCompanyReadDto,MockedEmailValidator)

  //Unit Testing for CompanyValidator class by using mocked variable of the CompanyReadDto/EmailValidator.

  "Company Google" should "be Valid due to new name and correct email pattern" in {
    val company = Company("Google","Google@alphabet.com","California")
    when(MockedCompanyReadDto.getCompanyByName(company.name)) thenReturn None
    when(MockedEmailValidator.emailIdIsValid(company.emailId)) thenReturn true
    val isCompanyValid = companyValidator.isCompanyValid(company)
    assert(isCompanyValid)
  }

  "Company Google" should "not be Valid due to wrong email pattern" in {
    val company = Company("Google","Go ogle@alphabet.com","California")
    when(MockedCompanyReadDto.getCompanyByName(company.name)) thenReturn None
    when(MockedEmailValidator.emailIdIsValid(company.emailId)) thenReturn false
    println()
    val isCompanyValid = companyValidator.isCompanyValid(company)
    assert(!isCompanyValid)
  }

  "Company Knoldus" should "not be Valid due to used name" in {
    val company = Company("Knoldus","Knoldus@gmail.com","noida")
    when(MockedCompanyReadDto.getCompanyByName(company.name)) thenReturn Some(Company("Knoldus","Knoldus@gmail.com","noida"))
    when(MockedEmailValidator.emailIdIsValid(company.emailId)) thenReturn true
    println()
    val isCompanyValid = companyValidator.isCompanyValid(company)
    assert(!isCompanyValid)
  }

  "Company Knoldus" should "not be Valid due to used name & wrong email pattern" in {
    val company = Company("Knoldus","Knoldus@gmail.com","noida")
    when(MockedCompanyReadDto.getCompanyByName(company.name)) thenReturn Some(Company("Knoldus","Knoldus@gmail.com","noida"))
    when(MockedEmailValidator.emailIdIsValid(company.emailId)) thenReturn false
    println()
    val isCompanyValid = companyValidator.isCompanyValid(company)
    assert(!isCompanyValid)
  }


}
