package com.knoldus.db

import com.knoldus.models.User

import scala.collection.immutable.HashMap

class UserReadDto {
  val sureshUser: User = User("Suresh","Kumar",23,50000, "Engineer", "Knoldus","suresh.kumar@knoldus.com")
  val honeyUser: User = User("Honey","Singh",37,5000000, "Singer", "MusicCompany","honey.singh@MusicCompany.com")
  val sidhuUser: User = User("Sidhu","Moosewala",27,4000000, "Singer", "Tseries","sidhu.moosewala@Tseries.com")
  val rameshUser: User = User("Ramesh","Kumar",25,50000, "Engineer", "Philips","ramesh.kumar@philips.com")
  val users: HashMap[String, User] = HashMap("Suresh" -> sureshUser, "Honey" -> honeyUser, "Sidhu" -> sidhuUser, "Ramesh" ->  rameshUser)

  def getUserByFName(name: String): Option[User] = users.get(name)

}
