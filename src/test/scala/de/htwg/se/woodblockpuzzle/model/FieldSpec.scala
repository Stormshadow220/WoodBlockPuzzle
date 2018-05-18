package de.htwg.se.woodblockpuzzle.model


import org.scalatest._


class FieldSpec extends WordSpec with Matchers {
  "A new Field" when {
    val field = Field(8)
    "new" should {
    "each cell isblocked should be 0" in {
      for (y <- 0 until field.fieldsize;
           x <- 0 until field.fieldsize) {
        field.cells(x)(y).isblocked should be(0)
      }
    }
  }
      "add a Block, by adding each Cell of Field with each Cell of Block"
      "add a type 0 Block to a empty field" in{
        val block = Block(0)
        field +(block, 0, 0) should be(field)
      }
      "add a not empty block to a empty field" in{
        val block = Block(0)
        block.cells(0)(0).isblocked = 1
        field + block shouldNot be(field)
      }
    }
}
