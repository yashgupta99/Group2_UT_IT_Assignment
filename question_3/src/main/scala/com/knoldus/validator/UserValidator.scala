package com.knoldus.validator

import com.knoldus.db.{CompanyReadDto, UserReadDto}
import com.knoldus.models.User

class UserValidator(userReadDto: UserReadDto,companyReadDto: CompanyReadDto,emailValidator: EmailValidator) {

  def isUserValid(user: User): Boolean = {
    val name = user.firstName
    if(userReadDto.getUserByFName(name).isEmpty){
      if(isCompanyExistInDb(user)){
        if(isEmailValid(user)){
          println("=>User ='"+user.firstName+"' is valid because this user does not exist already in database!")
          true
        }
        else{
          println("=>User ='"+user.firstName+"' is not valid because this user's email is in wrong pattern")
          false
        }
      }
      else{
        println("=>User ='"+user.firstName+"' is not valid because this user's company does not exist")
        false
      }
    }  //Its true because this user is not already exist
    else {
      println("=>User ='"+user.firstName+"' is not valid because this user exist already in database!")
      false
    }//user already exist
  }

  def isCompanyExistInDb(user: User):Boolean = {

    val result = companyReadDto.getCompanyByName(user.companyName)
    if(result.isEmpty) {
      println("The user's company='"+user.companyName+"' is not exist in database")
      false
    } //because company is not exist
    else {
      println("The user's company='"+user.companyName+"' is exist in database")
        true
      } //because company is exist
  }

  def isEmailValid(user: User):Boolean = {
    if(emailValidator.emailIdIsValid(user.emailId)) {
      println("The user's email='"+user.emailId+"' is valid according to the given condition in Group1's ques-1")
      true
    }
    else {
      println("The user's email='"+user.emailId+"' is not valid according to the given condition in Group1's ques-1")
      false
    }
  }

}
