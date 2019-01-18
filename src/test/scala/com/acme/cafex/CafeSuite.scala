package com.acme.cafex

import com.acme.cafex.Cafe._
import org.scalatest.FunSuite

class CafeSuite extends FunSuite {
  test("Cola price") {
    assert(billFor("Cola").subTotal == 0.5)
  }

  test("Coffee price") {
    assert(billFor("Coffee").subTotal == 1)
  }

  test("Cheese sandwich price") {
    assert(billFor("Cheese Sandwich").subTotal == 2)
  }

  test("Steak sandwich price") {
    assert(billFor("Steak Sandwich").subTotal == 4.5)
  }

  test("Mixed orders") {
    assert(billFor("Cola", "Coffee").subTotal == 1.5)
    assert(billFor("Cola", "Coffee", "Cheese Sandwich").subTotal == 3.5)
    assert(billFor("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich").subTotal == 8)
  }

  test("10% service charge when food ordered") {
    assert(billFor("Cheese Sandwich") == Bill(2, 0.2, 2.2))
    assert(billFor("Steak Sandwich") == Bill(4.5, 0.45, 4.95))
    assert(billFor("Cola", "Coffee", "Cheese Sandwich") == Bill(3.5, 0.35, 3.85))
    assert(billFor("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich") == Bill(8, 0.8, 8.80))
  }
}
