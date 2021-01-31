name := "Group2_UT_IT_assignment"

version := "0.1"

scalaVersion := "2.12.12"

lazy val question_1_2 = project.in(file("question_1_2"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test,
      "org.mockito" %% "mockito-scala" % "1.16.13" % Test
    )

  )
lazy val question_3 = project.in(file("question_3"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test,
      "org.mockito" %% "mockito-scala" % "1.16.13" % Test
    )

  )


libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test,
      "org.mockito" %% "mockito-scala" % "1.16.13" % Test)
