package page05

object coffee_page_05 {
  println("Hello")                                //> Hello

  val cafe = new Cafe()                           //> cafe  : page05.Cafe = StarBuckaroos
  val payments = new Payments                     //> payments  : page05.Payments = Payments()
  val cc = new CreditCard("12345")                //> cc  : page05.CreditCard = CreditCard(12345)

  cafe.buyCoffee(cc, payments)                    //> Charging Card(12345 -> 5.43)
                                                  //| res0: page05.Coffee = Coffee(5.43)
  cafe.buyCoffee(cc, payments)                    //> Charging Card(12345 -> 5.43)
                                                  //| res1: page05.Coffee = Coffee(5.43)
  cafe.buyCoffee(cc, payments)                    //> Charging Card(12345 -> 5.43)
                                                  //| res2: page05.Coffee = Coffee(5.43)

}

// classes

case class Coffee(price: BigDecimal)

case class CreditCard(number: String) {
  def charge(price: BigDecimal) = {
    println(s"Charging Card(${number} -> ${price})")
  }
}

case class Payments {
  def charge(cc: CreditCard, amount: BigDecimal) {
    cc.charge(amount) // default impl
  }
}

class Cafe {

  def buyCoffee(cc: CreditCard, p: Payments): Coffee = {
    val cup = new Coffee(5.43)
    p.charge(cc, cup.price) // side-effect
    cup
  }

  override def toString(): String = {
    "StarBuckaroos"
  }
}