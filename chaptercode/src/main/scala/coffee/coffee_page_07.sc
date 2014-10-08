package page07

object coffee_page_05 {
  println("Hello")                                //> Hello

  val cafe = new Cafe()                           //> cafe  : page07.Cafe = page07.Cafe@96532d6
  val cc = new CreditCard("12345")                //> cc  : page07.CreditCard = CreditCard(12345)

  val (coffees, charge) = cafe.buyCoffees(cc, 4)  //> coffees  : List[page07.Coffee] = List(Coffee(5.43), Coffee(5.43), Coffee(5.4
                                                  //| 3), Coffee(5.43))
                                                  //| charge  : page07.Charge = Charge(CreditCard(12345),21.72)
	charge.applyToCard()                      //> Charging Card(12345 -> 21.72)
                                                  
  val totals_are_equal =
    charge.amount == BigDecimal(21.72)            //> totals_are_equal  : Boolean = true
}

// classes
case class Coffee(price: BigDecimal)

case class Charge(cc: CreditCard, amount: BigDecimal) {
  def combine(other: Charge): Charge = {
    if (cc == other.cc) {
      Charge(cc, amount + other.amount)
    } else {
      throw new Exception("Can't combine charges to different cards");
    }
  }
  
  def applyToCard() = {
  	cc.charge(amount)
  }
}

case class CreditCard(number: String) {
  def charge(price: BigDecimal) = {
    println(s"Charging Card(${number} -> ${price})")
  }
}

class Cafe {
  def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee(5.43)
    (cup, new Charge(cc, cup.price))
  }

  def buyCoffees(cc: CreditCard, n: Int): (List[Coffee], Charge) = {
    val purchases: List[(Coffee, Charge)] = List.fill(n)(buyCoffee(cc)) // generate n coffees
    val (coffees, charges) = purchases.unzip // splits a list of pairs into a pairs of lists
    (coffees, charges.reduce((c1, c2) => c1.combine(c2))) // reduce the charges list to a single value
  }
}