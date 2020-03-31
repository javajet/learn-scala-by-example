package kitchen

import scala.util.{Failure, Success, Try}

/** With Validation **/
object Example2 extends App {

  /*************************************/

  type Ingredient = String
  type Flavouring = Ingredient
  type Milk = Ingredient
  type Sugar = Ingredient
  type Water = Ingredient
  type Drink = Seq[Ingredient]
  type IngredientList = (Flavouring, Water, Milk, Sugar)
  type DrinkResult = Try[Drink]

  /*************************************/

  case object BadMilk extends Exception("Bad Milk")
  case object ColdWater extends Exception("Cold Water")
  case object InvalidSugar extends Exception("Invalid Sugar")

  val GONE_BAD = new Milk("Gone Bad")
  val INVALID_SUGAR = new Sugar("Salt")

  /*************************************/

  val makeDrink: IngredientList => DrinkResult = {
    case (flavour: Flavouring, water: Water, milk: Milk, sugar: Sugar) => for {
      step1 <- startMaking(flavour)
      step2 <- addWater(step1, water)
      step3 <- addMilk(step2, milk)
      drink <- addSugar(step3, sugar)
    } yield drink
  }

  /*************************************/

  val startMaking = (flavouring: Flavouring) => Success { Array(flavouring) }
  val addWater = (drink: Drink, water: Water) =>
    if ( water contains "Hot" )
      Success { drink :+ water }
    else
      Failure { ColdWater }
  
  val addMilk = (drink: Drink, milk: Milk) =>
    if ( milk != GONE_BAD )
      Success { drink :+ milk }
    else
      Failure { BadMilk }

  val addSugar = (drink: Drink, sugar: Sugar) =>
    if ( sugar != INVALID_SUGAR )
      Success { drink :+ sugar }
    else
      Failure { InvalidSugar }

  /*************************************/

  makeDrink("Tea", "Hot Water", "Semi-skimmed Milk", "No Sugar") match {
    case Success(drink) =>
      println { drink mkString("Your drink contains: ", ", ", ".") }
    case Failure(e) =>
      println { f"Sadly, your drink wasn't made because: ${e getMessage}" }
  }

  makeDrink("Tea", "Cold Water", "Semi-skimmed Milk", "No Sugar") match {
    case Success(drink) =>
      println { drink mkString("Your drink contains: ", ", ", ".") }
    case Failure(e) =>
      println { f"Sadly, your drink wasn't made because: ${e getMessage}" }
  }

  makeDrink("Tea", "Hot Water", "Semi-skimmed Milk", INVALID_SUGAR) match {
    case Success(drink) =>
      println { drink mkString("Your drink contains: ", ", ", ".") }
    case Failure(e) =>
      println { f"Sadly, your drink wasn't made because: ${e getMessage}" }
  }

  makeDrink("Tea", "Hot Water", GONE_BAD, "1 Lump") match {
    case Success(drink) =>
      println { drink mkString("Your drink contains: ", ", ", ".") }
    case Failure(e) =>
      println { f"Sadly, your drink wasn't made because: ${e getMessage}" }
  }
  /*************************************/
}
