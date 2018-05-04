/**
  * Possible extensions to the tea making process
  */
package kitchen

object Muggins5 extends App {


  /*************************************/


  trait Ingredient

  trait Drink


  /*************************************/


  sealed trait Milk

  case object SemiSkimmed extends Milk

  case object Whole extends Milk

  case object Soy extends Milk

  case object Almond extends Milk


  /*************************************/


  case class Sugar(lumps: Int) extends Ingredient {

    require(lumps >= 0)

    require(lumps < 4)

  }


  /*************************************/


  case class Water(temp: Int) extends Ingredient with Drink {

    require(temp > 20, "Water too cold: over 20 degrees please!")

    val allowToCool = () => {

      Water(temp - 5)

    } ensuring (_.temp > 20)

  }


  /*************************************/


  type PowerSupply = String

  case class Kettle(water: Water)(implicit socket: PowerSupply) {

    override def toString() = {

      f"Kettle: ${water} + ${socket}"
    }
  }

  implicit val electricity = new PowerSupply("Mains Socket")

  val kettle = Kettle(Water(22))

  println(kettle)


  /*************************************/

}

