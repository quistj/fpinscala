package page04

object coffee_page_04 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  println("Hello");$skip(25); 

  val cafe = new Cafe();System.out.println("""cafe  : page04.Cafe = """ + $show(cafe ));$skip(43); val res$0 = 

  cafe.buyCoffee(new CreditCard("12345"));System.out.println("""res0: page04.Coffee = """ + $show(res$0));$skip(42); val res$1 = 
  cafe.buyCoffee(new CreditCard("12345"));System.out.println("""res1: page04.Coffee = """ + $show(res$1));$skip(42); val res$2 = 
  cafe.buyCoffee(new CreditCard("12345"));System.out.println("""res2: page04.Coffee = """ + $show(res$2))}

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
