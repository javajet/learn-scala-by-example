package kitchen
import scala.util.{Failure, Success}
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/** Future Water & Milk **/
object Muggins4 extends App {


  /*************************************/


  type Ingredient = String

  type Flavouring = Ingredient

  type Milk = Ingredient

  type Sugar = Ingredient

  type Water = Ingredient

  type Drink = Seq[Ingredient]

  type IngredientList = (Flavouring, Future[Water], Future[Milk], Sugar)


  /*************************************/


  case object BadMilk extends Exception("Bad Milk")

  case object ColdWater extends Exception("Cold Water")

  case object BadKettle extends Exception("Bad Kettle")

  case object InvalidSugar extends Exception("Invalid Sugar")

  case object NoMilk extends Exception("No Milk")

  val GONE_BAD = new Milk("Gone Bad")

  val INVALID_SUGAR = new Sugar("Salt")


  /*************************************/


  val makeDrink: IngredientList => Future[Drink] = {

    case (flavour: Flavouring, boilWater: Future[Water], milkFromFridge: Future[Milk], sugar: Sugar) => for {

      water <- boilWater

      step1 <- startMaking(flavour)

      step2 <- addWater(step1, water)

      milk <- milkFromFridge

      step3 <- addMilk(step2, milk)

      drink <- addSugar(step3, sugar)

    } yield drink

  }


  /*************************************/


  val startMaking = (flavouring: Flavouring) => Future fromTry { Success(Array(flavouring)) }

  val addWater = (drink: Drink, water: Water) => Future fromTry {

    if ( water contains "Hot" )
      Success { drink :+ water }
    else
      Failure { ColdWater }
  }

  val addMilk = (drink: Drink, milk: Milk) => Future fromTry {

    if ( milk != GONE_BAD )
      Success { drink :+ milk }
    else
      Failure { BadMilk }
  }

  val addSugar = (drink: Drink, sugar: Sugar) => Future fromTry {

    if ( sugar != INVALID_SUGAR )
      Success { drink :+ sugar }
    else
      Failure { InvalidSugar }
  }


  /*************************************/


  val boiledKettle: Future[Water] = Future { "Hot Water" }

  val stoppedKettle: Future[Water] = Future { "Cold Water" }

  val faultyKettle: Future[Water] = Future failed { BadKettle }

  val milkFromFridge: Future[Milk] = Future { "Semi-skimmed Milk" }

  val outtaMilk: Future[Water] = Future failed { NoMilk }


  /*************************************/


  Seq( (boiledKettle, milkFromFridge),
       (stoppedKettle, milkFromFridge),
       (faultyKettle, milkFromFridge),
       (boiledKettle, outtaMilk) ) foreach {

    case (waitForKettle, waitForMilkman) =>

      Await ready (

        makeDrink ("Tea", waitForKettle, waitForMilkman, "No sugar")

        andThen {

          case Success(drink) =>

            println {
              drink mkString("Your drink contains: ", ", ", ".")
            }

          case Failure(e) =>

            println {
              f"Sadly, your drink wasn't made because: ${e getMessage}"
            }
        },

        5 seconds
      )
  }


  /*************************************/

}
