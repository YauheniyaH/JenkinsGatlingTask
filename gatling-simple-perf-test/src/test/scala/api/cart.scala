package api

import config.BaseHelpers.{C_cart_content, C_p_id, C_trans_id, demoHome}
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object cart {
  def openCart(): ChainBuilder = {
    exec(
      http("cart")
        .get(demoHome + "/cart" )
        .check(regex("""hidden type="hidden" name="cart_content" value='(.*?)'>""").find.saveAs(C_cart_content))
      //  .check(regex("""class="product_id" value="(.+?)">""").find.saveAs(C_p_id))

        .check(regex("""type="hidden" value="(.+?)" name="trans_id">""").find.saveAs(C_trans_id))
    )
  }

}
