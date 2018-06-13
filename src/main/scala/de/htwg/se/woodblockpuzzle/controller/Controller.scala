package de.htwg.se.woodblockpuzzle.controller
import de.htwg.se.woodblockpuzzle.model.{Block, Field}
case class Controller(unit:Unit){
  var field: Field = Field(0)
  var b1: Block = Block(0)
  var b2: Block = Block(0)
  var b3: Block = Block(0)
  var availableBlocks = 0
  var count = 0

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
    var s : String = "Block doesn't exist"
    if(blocknumber==1) {
      return b1.toString
    }
    if(blocknumber==2) {
      return b2.toString
    }
    if(blocknumber==3) {
      return b3.toString
    }
    return s
  }
  def showField(): String ={
    return this.field.toString
  }

  def deleteFullRows()={
    field = field.eightInARow()
  }
}
