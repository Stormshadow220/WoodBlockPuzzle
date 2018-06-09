package de.htwg.se.woodblockpuzzle.controller
import de.htwg.se.woodblockpuzzle.model.{Block, Field}
case class Controller {
  var field: Field = field(1)
  var b1: Block = Block(0)
  var b2: Block = Block(0)
  var b3: Block = Block(0)
  var availableBlocks = 0

  def createField: Field = {
    field = Field(8)
  }


  def createBlock(x: Int): Block = {
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


  def addingBlock(blocknumber: Int, atx: Int, aty: Int): Unit = {

  }

  def showBlock(blocknumber: Int): String ={
    var s : String
    match(blocknumber){
      case 1=> s =b1.toString
      case 2=> s =b2.toString
      case 3=> s =b3.toString
    }

  }
  def showField(): String ={
    return this.field.toString
  }
}
