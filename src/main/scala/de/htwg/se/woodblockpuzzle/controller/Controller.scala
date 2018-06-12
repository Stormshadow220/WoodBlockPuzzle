package de.htwg.se.woodblockpuzzle.controller
import de.htwg.se.woodblockpuzzle.model.{Block, Field}
case class Controller(x:Int){
  var field: Field = field(0)
  var b1: Block = Block(0)
  var b2: Block = Block(0)
  var b3: Block = Block(0)
  var availableBlocks = 0

  def createField: Field = {
    field = Field(x)
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
    if(blocknumber ==1){
      this.field = field +(b1,atx,aty)
    }
    if(blocknumber ==2){
      this.field = field +(b2,atx,aty)
    }
    if(blocknumber ==3){
      this.field = field +(b3,atx,aty)
    }
  }

  def showBlock(blocknumber: Int): String ={
    var s = ""
    s = blocknumber match{
      case 1=> b1.toString
      case 2=> b2.toString
      case 3=> b3.toString
    }

  }
  def showField(): String ={
    return this.field.toString
  }

  def deleteFullRows()={
    field = field.eightInARow(field)
  }
}
