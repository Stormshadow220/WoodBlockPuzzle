package de.htwg.se.woodblockpuzzle.controller

import org.scalatest._


class ControllerSpec extends WordSpec with Matchers{
  "A controller" when {
    val controller1 = new Controller()
    "new" should {
      "create nothing, before using the right funktion" in{
        controller1.field.fieldsize should be(0)
        controller1.availableBlocks should be(0)
        controller1.b1.blocktype should be(0)
      }
    }
    "in use" should{
      "create 3 new blocks with random blocktype between 0 and 17" in {
        "after using create3RandomBlocks"
        controller1.create3RandomBlocks
        controller1.availableBlocks should be(3)
      }
      "create one block with blocktype x. the funktion can be called three times from create3RandomBlocks or manual," +
        " to create only one block" in {
        controller1.b1 = controller1.createBlock(3)
        controller1.b1.blocktype should be(3)
        controller1.b2 = controller1.createBlock(13)
        controller1.b2.blocktype should be(13)
      }
      "call the toString-funktion of its field with the funktion showField"in{
        controller1.createField
        controller1.field.toString should be(controller1.showField())
      }
      "call the toString-funktion of its blocks with the funktion showBlock(x). x is a number between 1 and 3."in{
        controller1.create3RandomBlocks
        controller1.b1.toString should be(controller1.showBlock(1))
        controller1.b2.toString should be(controller1.showBlock(2))
        controller1.b3.toString should be(controller1.showBlock(3))
        controller1.showBlock(4) should be("Block doesn't exist")
        controller1.showBlock(-20) should be("Block doesn't exist")
      }
      "return the status of a cell at the coordinates atx,aty. returns 0 for free, 1 for blocked and -1 if the coordinates aren't inside the field"in{
        controller1.createField
        controller1.field.cells(1)(1).isblocked = 1
        controller1.getCellStatusAt(0,0) should be(0)
        controller1.getCellStatusAt(1,1) should be(1)
        controller1.getCellStatusAt(20,20) should be(-1)
      }
    }
  }
}
