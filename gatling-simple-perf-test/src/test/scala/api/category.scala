package api

import config.BaseHelpers.demoHome
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object category {
  def category(cat: String="tables"):ChainBuilder={
    exec(
      http("category")
        .get(demoHome+"/"+s"$cat")
    )
  }

}
