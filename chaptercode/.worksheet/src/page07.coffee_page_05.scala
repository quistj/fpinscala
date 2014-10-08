package page07

object coffee_page_05 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  println("Hello");$skip(25); 

  val cafe = new Cafe();System.out.println("""cafe  : page07.Cafe = """ + $show(cafe ));$skip(35); 
  val cc = new CreditCard("12345");System.out.println("""cc  : page07.CreditCard = """ + $show(cc ));$skip(50); 

  val (coffees, charge) = cafe.buyCoffees(cc, 4);System.out.println("""coffees  : List[page07.Coffee] = """ + $show(coffees ));System.out.println("""charge  : page07.Charge = """ + $show(charge ));$skip(22); 
	charge.applyToCard();$skip(115); 
                                                  
  val totals_are_equal =
    charge.amount == BigDecimal(21.72);System.out.println("""totals_are_equal  : Boolean = """ + $show(totals_are_equal ))}
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
