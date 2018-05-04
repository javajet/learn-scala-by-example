package race

import scala.util.Try

object Driver extends App {


  /*************************************/


  trait Money

  sealed trait Car

  case object Ferrari extends Car

  case object Porsche extends Car

  case object Mini extends Car

  type Dealership = Map[Money,Car]


  /*************************************/


  type RaceOutcome = String

  val WON: RaceOutcome = "Won the race"

  val LOST: RaceOutcome = "Lost the race"

  type EntryCriteria = (Money, Money => Car, Car => RaceOutcome)

  type Race = EntryCriteria => RaceOutcome


  /*************************************/


  trait Printable { def msg: String }


  /*************************************
    *
    * THE FOLLOWING TWO FUNCTIONS DO
    * *EXACTLY* THE SAME THING USING
    * TWO DIFFERENT SCALA TECHNIQUES
    * (THEY ARE EQUIVALENT IN TERMS
    * OF FUNCTIONALITY). PRESENTED
    * HERE AS AN ILLUSTRATION OF
    * WHAT'S POSSIBLE USING
    * `FOR COMPREHENSION`
    *
    *************************************/


  val enterRaceMethod1: Race = {

    case (usingMoney, buyCar, raceAroundTrack) =>

      raceAroundTrack( buyCar(usingMoney) )
      // f(x), g(x) -> y = g(f(x))
  }


  val enterRaceMethod2: Race = {

    case (usingMoney, buyCar, raceAroundTrack) => {

      for {

        withMoney <- Try { usingMoney }

        brandNewCar <- Try { buyCar(withMoney) }

      } yield raceAroundTrack(brandNewCar)

    } get
  }


  /*************************************/


  val raceAroundTrack: Car => RaceOutcome = (car: Car) =>

    if (car == Ferrari)
      WON
    else
      LOST


  /*************************************/


  val purchaseNewCar = (dealer: Dealership, money: Money) => {

      if ( dealer hasCarForPrice money )
        dealer sellCar money

      else
        dealer dodgyDealings()
  }


  implicit class AsDealership(forecourt: Dealership) {

    val hasCarForPrice = (carsWorth: Money) => forecourt contains carsWorth


    val sellCar = (money: Money) => forecourt apply money


    val dodgyDealings = () => Mini

  }


  /*************************************/


  val cash = new Money with Printable { val msg = "a big wad of fifties" }

  val creditCard = new Money with Printable { val msg = "my wife's credit card" }

  val finance = new Money with Printable { val msg = "the never-never" }

  val stolenMoney = new Money with Printable { val msg = "money I stole from the bank" }


  /*************************************/


  val franchise: Dealership =
    Map[Money,Car](
      cash -> Porsche,
      finance -> Ferrari,
      creditCard -> Ferrari)


  /*************************************/


  //  type Race = EntryCriteria => RaceOutcome

  //  type EntryCriteria = (Money, Money => Car, Car => RaceOutcome)

  //  Second Parameter: "Money => Car"

  //  val purchaseNewCar: (Dealership, Money) => Car

  //  val franchise: Dealership

  val localGarage = purchaseNewCar curried (franchise)


  /*************************************/


  println {

    enterRaceMethod1((cash, localGarage, raceAroundTrack))

  }

  println {

    enterRaceMethod2((finance, localGarage, raceAroundTrack))

  }


  /*************************************/


  val printer = (input: EntryCriteria, method: EntryCriteria => RaceOutcome) =>
    println(f"${method apply input} " +
            f"using a ${input._2 apply input._1} " +
            f"I bought with ${input._1.asInstanceOf[Printable] msg}")


  /*************************************/


  printer((cash, localGarage, raceAroundTrack), enterRaceMethod1)

  printer((finance, localGarage, raceAroundTrack), enterRaceMethod2)

  printer((creditCard, localGarage, raceAroundTrack), enterRaceMethod1)

  printer((stolenMoney, localGarage, raceAroundTrack), enterRaceMethod2)


  /*************************************/
}