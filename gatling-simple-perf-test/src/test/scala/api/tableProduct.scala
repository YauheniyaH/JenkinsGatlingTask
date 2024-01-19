package api

import config.BaseHelpers.{C_cart_content, C_current_product, C_current_quantity, cvsFeeder, demoHome}
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import io.gatling.http.check.HttpCheck

object tableProduct {
  def tableProduct(): ChainBuilder = {
    feed(cvsFeeder)
      .exec(
        http("select product")
          .get(demoHome + "/products/"+"${tables}")
          .check(substring("current_product").exists)
          .check(regex("""hidden type="hidden" name="current_product" value="(.+?)">""").find.saveAs(C_current_product))
          .check(regex("""hidden type="hidden" name="cart_content" value='(.*?)'>""").find.saveAs(C_cart_content))
          .check(regex("""name="current_quantity" type="number" min="1" max="" step="1" value="(.+?)">""").find.saveAs(C_current_quantity))


      )


  }

}
