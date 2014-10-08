object chapter1_coffee {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(44); 
   println("Hello");$skip(25); 
  
  val cafe = new Cafe;System.out.println("""cafe  : Cafe = """ + $show(cafe ));$skip(45); val res$0 = 
  
  cafe.buyCoffee(new CreditCard("12345"));System.out.println("""res0: Coffee = """ + $show(res$0));$skip(42); val res$1 = 
  cafe.buyCoffee(new CreditCard("12345"));System.out.println("""res1: Coffee = """ + $show(res$1));$skip(42); val res$2 = 
  cafe.buyCoffee(new CreditCard("12345"));System.out.println("""res2: Coffee = """ + $show(res$2))}

  
}


// classes

case class Coffee(price:Double)



case class CreditCard(number:String) {
	def charge(price:BigDecimal) {
		 println("Charging Card...")
	}
}

class Cafe {
  def buyCoffee(cc:CreditCard): Coffee = {
  	val cup = new Coffee(5.43)
  	cc.charge(cup.price) // side-effect
  	cup
  }
}
