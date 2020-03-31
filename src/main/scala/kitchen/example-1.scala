package kitchen

/** Basic Example No Validation **/
object Example1 extends App {

  /*************************************/

  type Ingredient = String
  type Flavouring = Ingredient
  type Milk = Ingredient
  type Sugar = Ingredient
  type Water = Ingredient
  type Drink = Seq[Ingredient]
  type IngredientList = (Flavouring, Water, Milk, Sugar)


  /*************************************/


  val makeDrink: IngredientList => Option[Drink] = {
    case (flavour: Flavouring, water: Water, milk: Milk, sugar: Sugar) => for {
      step1 <- startMaking(flavour)
      step2 <- addWater(step1, water)
      step3 <- addMilk(step2, milk)
      drink <- addSugar(step3, sugar)
    } yield drink
  }


  /*************************************/


  val startMaking = (flavouring: Flavouring) => Some(Array(flavouring))
  val addWater = (drink: Drink, water: Water) => Some(drink :+ water)
  val addMilk = (drink: Drink, milk: Milk) => Some(drink :+ milk)
  val addSugar = (drink: Drink, water: Water) => Some(drink :+ water)


  /*************************************/


  for {
    drink <- makeDrink("Tea", "Hot Water", "Semi-skimmed Milk", "No sugar")
    msg <- drink mkString("Your drink contains: ", ", ", ".")
  } print (msg)


  /*************************************/

}

