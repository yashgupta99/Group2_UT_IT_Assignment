package com.knoldus.db.ut_it_testing

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import org.scalatest.flatspec.AsyncFlatSpec

class UT_IT_Test_CompanyReadDto extends AsyncFlatSpec{
  val companyReadDto = new CompanyReadDto

  //In this class UT & IT testing combine because this class has only one method and has no nested method calling

  "Company Knoldus" should "be available in database" in{
    val getCompany = companyReadDto.getCompanyByName("Knoldus")
    assert(getCompany.contains(Company("Knoldus", "knoldus@gmail.com", "Noida")))
  }

  "Company Philips" should "be available in database" in{
    val getCompany = companyReadDto.getCompanyByName("Philips")
    assert(getCompany.contains(Company("Philips", "philips123@gmail.com", "Noida")))
  }

  "Company Tseries" should "be available in database" in{
    val getCompany = companyReadDto.getCompanyByName("Tseries")
    assert(getCompany.contains(Company("Tseries", "Tseries@gmail.com", "Noida")))
  }

  "Company IRS" should "not be available in database" in{
    val getCompany = companyReadDto.getCompanyByName("IRS")
    assert(getCompany.isEmpty)
  }

  "Company DTC" should "not be available in database" in{
    val getCompany = companyReadDto.getCompanyByName("DTC")
    assert(getCompany.isEmpty)
  }


}
