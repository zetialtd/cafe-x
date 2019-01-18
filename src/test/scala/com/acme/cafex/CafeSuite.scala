package com.acme.cafex

import com.acme.cafex.Cafe._
import org.scalatest.FunSuite

class CafeSuite extends FunSuite {
  test("Cola price") {
    assert(billFor("Cola") == 0.5)
  }

  test("Coffee price") {
    assert(billFor("Coffee") == 1)
  }

  test("Cheese sandwich price") {
    assert(billFor("Cheese Sandwich") == 2)
  }

  test("Steak sandwich price") {
    assert(billFor("Steak Sandwich") == 4.5)
  }

  test("Mixed orders") {
    assert(billFor("Cola", "Coffee") == 1.5)
    assert(billFor("Cola", "Coffee", "Cheese Sandwich") == 3.5)
    assert(billFor("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich") == 8)
  }
}
