package de.htwg.se.woodblockpuzzle.model

import org.scalatest._


class FieldSpec extends WordSpec with Matchers {
  "A new Field" when {
    "new" should {
    "each cell isblocked should be 0" in {
      var field = Field(8)
      for (y <- 0 until field.fieldsize;
           x <- 0 until field.fieldsize) {
        field.cells(x)(y).isblocked should be(0)
      }
    }
  }
      "add a Block, by adding each Cell of Field with each Cell of Block"
      "add a not empty block to a empty field" in{
        var field = Field(8)
        val block = Block(0)
        field +(block, 0,0) shouldNot be(field)
      }
    "add a type 7 block, which is one of our biggest blocks, to a not empty field" in{
      var field = Field(8)
      val block = Block(7)
      field = field +(block, 0,0)
      field.cells(0)(0).isblocked should be(1)
      field.cells(1)(0).isblocked should be(1)
      field.cells(2)(0).isblocked should be(1)
      field.cells(0)(1).isblocked should be(1)
      field.cells(1)(1).isblocked should be(1)
      field.cells(2)(1).isblocked should be(1)
      field.cells(0)(2).isblocked should be(1)
      field.cells(1)(2).isblocked should be(1)
      field.cells(2)(2).isblocked should be(1)
    }
    "checks if a block fits in the field, after checking, that the coordinates are " +
      "inside the field and the block wont create a index-out-of-Bounds-Error. Fitting in the field means," +
      " that the block wont overlap with a block, added before. " in{
      var field = Field(8)
      val block = Block(8)
      field = field +(block,0,0)
      field +(block,1,1) should be(field)
    }
    "The method fit gets a field and checks the cells of their number. fit returns false, if any cell.isblocked equals 2 or higher." in{
      var field = Field(8)
      field.cells(2)(2).isblocked = 2
      field.fit(field) should be(false)
    }

    "The method eightInARow checks the whole field for full rows and deletes them. in this way we can delete rows, similar to tetris"in{
      var field = Field(8)
      field.cells(0)(0).isblocked = 1
      field.cells(1)(0).isblocked = 1
      field.cells(2)(0).isblocked = 1
      field.cells(3)(0).isblocked = 1
      field.cells(4)(0).isblocked = 1
      field.cells(5)(0).isblocked = 1
      field.cells(6)(0).isblocked = 1
      field.cells(7)(0).isblocked = 1
      field.eightInARow()
    }
    "toString returns a string that represents the field"
    "toString of an empty field should return a string filled with 0"in{
      var field = Field(8)
      field.toString should be("")
    }
  }
}
