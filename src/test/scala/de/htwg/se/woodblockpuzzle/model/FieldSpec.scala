package de.htwg.se.woodblockpuzzle.model


import org.scalatest._


class FieldSpec extends WordSpec with Matchers {
  "A new Field" when {
    var field = Field(8)
    "new" should {
    "each cell isblocked should be 0" in {
      for (y <- 0 until field.fieldsize;
           x <- 0 until field.fieldsize) {
        field.cells(x)(y).isblocked should be(0)
      }
    }
  }
      "add a Block, by adding each Cell of Field with each Cell of Block"
      "add a not empty block to a empty field" in{
        val block = Block(0)
        field +(block, 0,0) shouldNot be(this)
      }
     /*"add a not empty block to a field at a position, thats out of fieldsize " in{
        val block = Block(5)
        val backup = field
        field +(block, 8,8) should be(backup)
      }*/
  }
}
