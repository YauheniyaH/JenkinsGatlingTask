package api

import config.BaseHelpers.{demoHome, sentHeaders}
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object home {
  def pteHome(): ChainBuilder={
    exec(
      http( "PTE Home Page")

        .get(demoHome)
        .headers(sentHeaders)
        .check(regex(pattern="Performance testing Essentials"))
        .check(status.is(200))
    )
  }

}
