package api

import config.BaseHelpers.{C_cart_content, C_current_product, C_current_quantity, addProductToCart}
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object addToCart {
  def addToCart ():ChainBuilder={
    exec(
      http("add product to cart")
        .post(addProductToCart)
       // .body(StringBody(s"""{"cat":"$cat"}""")).asJson
        .formParam("action","ic_add_to_cart")
        .formParam("add_cart_data",s"current_product=${C_current_product}&cart_content=${C_cart_content}&current_quantity=${C_current_quantity}")
        .formParam("cart_widget","0")
        .formParam("cart_container","0")

        .check(status.is(200))
        .check(regex("al-box success cart-added-info "))
        .check(regex("Added!"))
    )
  }

}
