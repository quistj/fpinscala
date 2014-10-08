package page05

object coffee_page_05 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  println("Hello");$skip(25); 

  val cafe = new Cafe();System.out.println("""cafe  : page05.Cafe = """ + $show(cafe ));$skip(30); 
  val payments = new Payments;System.out.println("""payments  : page05.Payments = """ + $show(payments ));$skip(35); 
  val cc = new CreditCard("12345");System.out.println("""cc  : page05.CreditCard = """ + $show(cc ));$skip(32); val res$0 = 

  cafe.buyCoffee(cc, payments);System.out.println("""res0: page05.Coffee = """ + $show(res$0));$skip(31); val res$1 = 
  cafe.buyCoffee(cc, payments);System.out.println("""res1: page05.Coffee = """ + $show(res$1));$skip(31); val res$2 = 
  cafe.buyCoffee(cc, payments);System.out.println("""res2: page05.Coffee = """ + $show(res$2))}

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
