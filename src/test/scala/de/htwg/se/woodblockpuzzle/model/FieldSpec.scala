package de.htwg.se.woodblockpuzzle.model


import org.scalatest._


class FieldSpec extends WordSpec with Matchers {
  "A new Field" should {
      val field = Field()
      "each cell isblocked be 0" in {
        for (y <- 0 until 3;
             x <- 0 until 3) {
          field.cells(x)(y).isblocked should be(0)
        }
      }
      "add a Block, by adding each Cell of Field with each Cell of Block"
      "add a empty Block to a empty field" in{
        val block = Block()
        field + block should be(field)
      }
      "add a not empty block to a empty field" in{
        val block = Block()
        block.cells(0)(0).isblocked = 1
        field + block shouldNot be(field)
    }
    }

}
