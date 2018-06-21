package de.htwg.se.woodblockpuzzle

import controller.Controller
object WoodBlockPuzzle {
  def main(args: Array[String]): Unit = {
    var c = new Controller

    c.createField
    c.create3RandomBlocks
    print(c.showFieldWithCoordinates())
    print("b1=\n"+c.showBlock(1)+"\n" +
      "b1=\n"+c.showBlock(2)+"\n" +
        "b2=\n"+c.showBlock(3))
    c.addingBlock(1,1,1)
    print(c.showFieldWithCoordinates())
    print("b1\n="+c.showBlock(1)+"\n" +
      "b1=\n"+c.showBlock(2)+"\n" +
      "b2=\n"+c.showBlock(3))

  }
}
