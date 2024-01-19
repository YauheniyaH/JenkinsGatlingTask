package simulations

//import config.BaseHelpers.httpProtocol

import io.gatling.core.Predef._
import scenarios.PTEDemo.{scnPTEDemoChairsOnly, scnPTEDemoCheckout, scnPTEDemoTablesOnly}

class PerfTestSimulation extends Simulation {

  //mvn clean gatling:test -DTablesUsers=100 -DChairsUsers=50 -DCheckoutUsers=30
  //mvn clean gatling:test
  setUp (
    scnPTEDemoTablesOnly.inject (atOnceUsers (System.getProperty ("TablesUsers", "10").toInt))
      andThen (
      scnPTEDemoChairsOnly.inject (atOnceUsers (System.getProperty ("ChairsUsers", "5").toInt))
        andThen(scnPTEDemoCheckout.inject (atOnceUsers (System.getProperty ("CheckoutUsers", "3").toInt))
        )


    )
    //.protocols(httpProtocol)
  )

}
