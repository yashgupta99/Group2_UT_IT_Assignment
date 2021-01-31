package com.knoldus.db

import com.knoldus.models.Company

import scala.collection.immutable.HashMap

class CompanyReadDto {

  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val philipsCompany: Company = Company("Philips", "philips123@gmail.com", "Noida")
  val tseriesCompany: Company = Company("Tseries", "Tseries@gmail.com", "Noida")
  val musicCompany: Company = Company("MusicCompany", "MusicCompany@gmail.com", "Noida")

  val companies: HashMap[String, Company] = HashMap("Knoldus" -> knoldusCompany, "Philips" -> philipsCompany, "Tseries" -> tseriesCompany,
                                                     "MusicCompany" -> musicCompany)

  def getCompanyByName(name: String): Option[Company] = companies.get(name)

}
