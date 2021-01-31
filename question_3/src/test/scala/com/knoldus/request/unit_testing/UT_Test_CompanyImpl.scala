package com.knoldus.request.unit_testing

import com.knoldus.models.Company
import com.knoldus.request.CompanyImpl
import com.knoldus.validator.CompanyValidator
import org.mockito.Mockito.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class UT_Test_CompanyImpl extends AsyncFlatSpec{
  val MockedCompanyValidator:CompanyValidator = mock(classOf[CompanyValidator])
  val companyImpl = new CompanyImpl(MockedCompanyValidator)

  //Unit Testing for CompanyImpl class by using mocked variable of the CompanyValidator.


  "Company Google" should "be Valid due to new name and correct email pattern" in {
    val company = Company("Google","Google@alphabet.com","California")
    when(MockedCompanyValidator.isCompanyValid(company)) thenReturn true
    val isCompanyCreated = companyImpl.createCompany(company)
    println()
    assert(isCompanyCreated.contains("Google"))
  }

  "Company Google" should "not be Valid due to incorrect email pattern" in {
    val company = Company("Google","Go ogle@alphabet.com","California")
    when(MockedCompanyValidator.isCompanyValid(company)) thenReturn false
    val isCompanyCreated = companyImpl.createCompany(company)
    println()
    assert(!isCompanyCreated.contains("Google"))
  }

  "Company Knoldus" should "not be Valid due to used name and correct email pattern" in {
    val company = Company("Knoldus","knoldus@gmail.com","noida")
    when(MockedCompanyValidator.isCompanyValid(company)) thenReturn false
    val isCompanyCreated = companyImpl.createCompany(company)
    println()
    assert(!isCompanyCreated.contains("Knoldus"))
  }

  "Company Philips" should "not be Valid due to used name and incorrect email pattern" in {
    val company = Company("Philips","philips 123@gmail.com","noida")
    when(MockedCompanyValidator.isCompanyValid(company)) thenReturn false
    val isCompanyCreated = companyImpl.createCompany(company)
    println()
    assert(!isCompanyCreated.contains("Philips"))
  }

  "Company Diamond" should "be Valid due to new name and correct email pattern" in {
    val company = Company("Diamond","diamond@gmail.com","California")
    when(MockedCompanyValidator.isCompanyValid(company)) thenReturn true
    val isCompanyCreated = companyImpl.createCompany(company)
    println()
    assert(isCompanyCreated.contains("Diamond"))
  }


}
