package com.knoldus.db.ut_it_testing

import com.knoldus.db.UserReadDto
import com.knoldus.models.User
import org.scalatest.flatspec.AsyncFlatSpec

class UT_IT_Test_UserReadDto extends AsyncFlatSpec{
  val userReadDto = new UserReadDto

  //In this class UT & IT testing combine because this class has only one method and has no nested method calling

  "User Suresh" should "be available in database"in {
    assert(userReadDto.getUserByFName("Suresh").contains(User("Suresh","Kumar",23,50000, "Engineer", "Knoldus","suresh.kumar@knoldus.com")))
  }

  "User Honey" should "be available in database"in {
    assert(userReadDto.getUserByFName("Honey").contains(User("Honey","Singh",37,5000000, "Singer", "MusicCompany","honey.singh@MusicCompany.com")))
  }

  "User Sidhu" should "be available in database"in {
    assert(userReadDto.getUserByFName("Sidhu").contains(User("Sidhu","Moosewala",27,4000000, "Singer", "Tseries","sidhu.moosewala@Tseries.com")))
  }

  "User Natwarlal" should "not be available in database"in {
    assert(userReadDto.getUserByFName("Natwarlal").isEmpty)
  }

  "User Rajesh" should "be available in database"in {
    assert(userReadDto.getUserByFName("Rajesh").isEmpty)
  }



}
