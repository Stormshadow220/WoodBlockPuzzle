package de.htwg.se.woodblockpuzzle.model


import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner



@RunWith(classOf[JUnitRunner])
class FieldSpec extends WordSpec with Matchers {
  "A Field" when {
    "new" should {
      val field = Field()
      "each cell isfree be true"  in {
      for (y <- 0 to fieldsize) {
        for (x <- 0 to fieldsize) {
          field.cells(x)(y).isfree should be(true)
        }
      }
    }
    }
  }

}
