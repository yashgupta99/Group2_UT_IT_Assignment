package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company

class CompanyValidator(companyReadDto: CompanyReadDto,emailValidator: EmailValidator) {

  def isCompanyValid(company: Company): Boolean = {
    val result = companyReadDto.getCompanyByName(company.name)
    if(result.isEmpty) {
      if(isEmailValid(company)){
        println("=>Company ='"+company.name+"' is valid because it does not exist in database!")
        true
      }
      else{
        println("=>Company ='"+company.name+"' is not valid because it has wrong emailId pattern!")
        false
      }
    } //Company is not exist so you can create one that is why its valid.
    else{
      println("=>Company ='"+company.name+"' is not valid because it exist in database!")
      false
    } //Company is already exist.
  }
  def isEmailValid(company: Company):Boolean = {
    if(emailValidator.emailIdIsValid(company.emailId)) {
      println("Company's mail='"+company.emailId+"' is valid according to given condition in Group1's ques 1")
      true
    }
    else {
      println("Company's mail='"+company.emailId+"' is not valid according to given condition in Group1's ques 1")
      false
    }
  }

}
