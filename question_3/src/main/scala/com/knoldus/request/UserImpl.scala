package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator

class UserImpl(userValidator: UserValidator){

  def createUser(user: User): Option[String] = {
    if (userValidator.isUserValid(user)) {
      println("=>User '"+user.firstName+"' created successfully!")
      Option(user.emailId)
    }
    else {
      println("=>User '"+user.firstName+"' is not created due to above reasons!")
      None
    }
  }

}
