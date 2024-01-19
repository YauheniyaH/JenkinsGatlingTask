package config

//import config.BaseHelpers.httpProtocol._

import io.gatling.core.ConfigKeys.http
import io.gatling.http.protocol.HttpProtocolBuilder
import io.gatling.core.Predef._
import io.gatling.core.protocol
import io.gatling.core.structure._
import io.gatling.http.protocol.HttpProtocolBuilder

object BaseHelpers {

  val demoHome="http://localhost/"
  val cvsFeeder=csv("feeders/tables_and_chairs.csv").random
  val cvsFeederChairs=csv("feeders/chairs.csv").random
  val addProductToCart="http://localhost/wp-admin/admin-ajax.php"
  val C_current_product=""
  val C_cart_content=""
  val C_current_quantity=""
  val C_p_id=""
  val C_trans_id=""

  def thinkTimer (Min :Int=2, Max :Int=5): ChainBuilder={
    pause(Min, Max)
  }

  val sentHeaders = Map(
  "content-type" -> "application/javascript",
   "accept" -> "text/html"
  )

//  val httpProtocol: HttpProtocolBuilder = http
//    acceptHeader( value="*/*")
//    .acceptEncodingHeader( value="gzip, deflate, br")
//    .acceptLanguageHeader("en-GB, en-US;q=0.9,en;q=0.8")
//    .upgradeInsecureRequestsHeader("1")
//    .userAgentHeader("")



}
