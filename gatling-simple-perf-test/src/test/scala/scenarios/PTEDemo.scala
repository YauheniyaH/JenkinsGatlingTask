package scenarios


import config.BaseHelpers.thinkTimer
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object PTEDemo {

  def scnPTEDemoTablesChairs:ScenarioBuilder={
    scenario( "Add table and chair plus checkout")
      .exec(flushHttpCache)
      .exec(flushCookieJar)
      .exitBlockOnFail(
        group("Home page"){
          exec(api.home.pteHome())
            .exec(thinkTimer())

        }
          .group("Tables"){
            exec(api.category.category())
              .exec(thinkTimer())

            .exec(api.tableProduct.tableProduct())
              .exec(thinkTimer())

            .exec(api.addToCart.addToCart())
              .exec(thinkTimer())
          }




          .group("Chairs"){
            exec(api.category.category("chairs"))
              .exec(thinkTimer())
           . exec(api.chairProduct.chairProduct())
              .exec(thinkTimer())
              .exec(api.addToCart.addToCart())
              .exec(thinkTimer())
          }

//          .group("Cart"){
//            exec(api.cart.openCart())
//              .exec(thinkTimer())
//              .exec(api.checkout.checkout())
//              .exec(thinkTimer())
//              .exec(api.confirmationPage.confirmationPage())
//          }



      )
  }


  def scnPTEDemoTablesOnly: ScenarioBuilder = {
    scenario ("Add table only")
      .exec (flushHttpCache)
      .exec (flushCookieJar)
      .exitBlockOnFail (
        group ("Home page") {
          exec (api.home.pteHome ())
            .exec (thinkTimer ())

        }
          .group ("Tables") {
            exec (api.category.category ())
              .exec (thinkTimer ())
              .exec (api.tableProduct.tableProduct ())
              .exec (thinkTimer ())
              .exec (api.addToCart.addToCart ())
              .exec (thinkTimer ())
          }
      )
  }

  def scnPTEDemoChairsOnly: ScenarioBuilder = {
    scenario ("Add chair only")
      .exec (flushHttpCache)
      .exec (flushCookieJar)
      .exitBlockOnFail (

          group ("Chairs") {
            exec (api.category.category ("chairs"))
              .exec (thinkTimer ())
              .exec (api.chairProduct.chairProduct())
              .exec (thinkTimer ())
              .exec (api.addToCart.addToCart ())
              .exec (thinkTimer ())
          }
      )
  }

  def scnPTEDemoCheckout: ScenarioBuilder = {
    scenario ("Checkout")
      .exec (flushHttpCache)
      .exec (flushCookieJar)
      .exitBlockOnFail (

        group ("Checkout") {
          exec (api.cart.openCart ())
            .exec (thinkTimer ())
            .exec (api.checkout.checkout ())
            .exec (thinkTimer ())
            .exec (api.confirmationPage.confirmationPage ())
        }
      )
  }

  }