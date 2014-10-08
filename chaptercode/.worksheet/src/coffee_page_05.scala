object coffee_page_05 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(43); 
   println("Hello");$skip(27); 
  
  val cafe = new Cafe();System.out.println("""cafe  : Cafe = """ + $show(cafe ));$skip(45); val res$0 = 
  
  cafe.buyCoffee(new CreditCard("12345"));System.out.println("""res0: <error> = """ + $show(res$0));$skip(42); val res$1 = 
  cafe.buyCoffee(new CreditCard("12345"));System.out.println("""res1: <error> = """ + $show(res$1));$skip(42); val res$2 = 
  cafe.buyCoffee(new CreditCard("12345"));System.out.println("""res2: <error> = """ + $show(res$2))}

  
}


// classes

case class Coffee(price:Double)

case class CreditCard(number:String) {
	def charge(price:BigDecimal) = {
		 println(s"Charging Card(${number} -> ${price} ...")
	}
}

case class Payments {
	def charge(cc:CreditCard, amount:Double) {
			cc.charge(amount)
	}
}

class Cafe {
  def buyCoffee(cc:CreditCard, p ;Payments): Coffee = {
  	val cup = new Coffee(5.43)
  	p.charge(cc, cup.price) // side-effect
  	cup
  }
}
