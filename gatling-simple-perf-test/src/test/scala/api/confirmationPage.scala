package api

import config.BaseHelpers.demoHome
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object confirmationPage {
  def confirmationPage():ChainBuilder={
    exec(
      http("Confirmation page")
      .get (demoHome + "/thank-you")
        .check(regex("Thank You"))
    )
  }

}
