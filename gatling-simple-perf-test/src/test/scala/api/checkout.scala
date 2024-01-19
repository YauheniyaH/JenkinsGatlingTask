package api

import config.BaseHelpers.{C_cart_content, C_current_product, C_current_quantity, C_p_id, C_trans_id, addProductToCart, demoHome}
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object checkout {

  def checkout():ChainBuilder={
    exec(
      http("Open checkout")
        .post (demoHome+"/checkout")
     //  .formParam("cart_content", ${C_cart_content})
        //.formParam("p_id[]", ${C_p_id})
        .formParam("p_quantity[]", "1")
        .formParam("total_net", "100")
        .formParam("trans_id", s"${C_trans_id}")
        .formParam("shipping", "order")
    )
  }

}
