package com.acme.cafex

object Cafe {

  def itemPrice(item: String): Double = item match {
    case "Cola" => 0.5
    case "Coffee" => 1
    case "Cheese Sandwich" => 2
    case "Steak Sandwich" => 4.5
  }

  def billFor(items: String*): Double = {
    items.foldLeft[Double](0)((total, item) => total + itemPrice(item))
  }

}
