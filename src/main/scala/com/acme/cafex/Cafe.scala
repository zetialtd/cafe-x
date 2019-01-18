package com.acme.cafex

import scala.math.BigDecimal
import scala.math.BigDecimal.RoundingMode

object Cafe {

  case class Bill(subTotal: BigDecimal, serviceCharge: BigDecimal, total: BigDecimal)

  def itemPrice(item: String): BigDecimal = item match {
    case "Cola" => 0.5
    case "Coffee" => 1
    case "Cheese Sandwich" => 2
    case "Steak Sandwich" => 4.5
  }


  def billFor(items: String*): Bill = {
    val subtotal = items.foldLeft[BigDecimal](0)((total, item) => total + itemPrice(item))

    if (items.contains("Cheese Sandwich") || items.contains("Steak Sandwich")) {
      val serviceCharge = (subtotal * 0.1).setScale(2, RoundingMode.HALF_EVEN)
      return Bill(subtotal, serviceCharge, subtotal + serviceCharge)
    }

    Bill(subtotal, 0, subtotal)
  }

}
