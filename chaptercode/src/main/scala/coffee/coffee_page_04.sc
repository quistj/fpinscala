package page04

object coffee_page_04 {
  println("Hello")                                //> Hello

  val cafe = new Cafe()                           //> cafe  : page04.Cafe = StarBuckaroos

  cafe.buyCoffee(new CreditCard("12345"))         //> Charging Card(12345 -> 5.43)
                                                  //| res0: page04.Coffee = Coffee(5.43)
  cafe.buyCoffee(new CreditCard("12345"))         //> Charging Card(12345 -> 5.43)
                                                  //| res1: page04.Coffee = Coffee(5.43)
  cafe.buyCoffee(new CreditCard("12345"))         //> Charging Card(12345 -> 5.43)
                                                  //| res2: page04.Coffee = Coffee(5.43)

}

// classes

case class Coffee(price: BigDecimal)

case class CreditCard(number: String) {
  def charge(price: BigDecimal) {
    println(s"Charging Card(${number} -> ${price})")
  }
}

class Cafe {
  def buyCoffee(cc: CreditCard): Coffee = {
    val cup = new Coffee(5.43)
    cc.charge(cup.price) // side-effect
    cup
  }

  override def toString(): String = {
    "StarBuckaroos"
  }
}