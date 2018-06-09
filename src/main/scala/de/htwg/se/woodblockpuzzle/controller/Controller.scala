package de.htwg.se.woodblockpuzzle.controller
import de.htwg.se.woodblockpuzzle.model.{Block, Field}
case class Controller {
  var field: Field
  var b1 : Block
  var b2 : Block
  var b3 : Block
  var availableBlocks = 0

  def createField: Field ={
    field = Field(8)
  }


  def createBlock(x:Int):Block={
    var b = Block(x)
    return b
  }

  def create3RandomBlocks = {
    var r = scala.util.Random
    b1 = createBlock(r.nextInt(17))
    b2 = createBlock(r.nextInt(17))
    b3 = createBlock(r.nextInt(17))
    availableBlocks = 3
  }
}
