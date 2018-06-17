package de.htwg.se.woodblockpuzzle.controller
import de.htwg.se.woodblockpuzzle.model.{Block, Field}
class Controller(){
  var field: Field = Field(0)
  var b1: Block = Block(0)
  var b2: Block = Block(0)
  var b3: Block = Block(0)
  var availableBlocks = 0

  def createField = {
    this.field = Field(8)
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
    blocknumber match {
      case 1 => field = field + (b1, atx, aty)
        availableBlocks-=1
      case 2 => field = field + (b2, atx, aty)
        availableBlocks-=1
      case 3 => field = field + (b3, atx, aty)
        availableBlocks-=1
    }
  }

  def showBlock(blocknumber: Int): String = {
    blocknumber match {
      case 1 => b1.toString
      case 2 => b2.toString
      case 3 => b3.toString
      case _ => "Block doesn't exist"
    }
  }
  def showField(): String = this.field.toString

  def deleteFullRows() = field = field.eightInARow()

  def returnCount:Int = this.field.count

  def getCellStatusAtField(atx:Int, aty:Int): Int = {
    if(atx < this.field.fieldsize && aty < this.field.fieldsize){
      this.field.cells(atx)(aty).isblocked
    }else{
      -1
    }
  }
  def getCellStatusAtBlock(blocknumber:Int,atx:Int, aty:Int): Int = {
    blocknumber match {
      case 1 => if(atx < this.b1.blockmaxx && aty < this.b1.blockmaxy){
        this.b1.cells(atx)(aty).isblocked
      }else{-1}
      case 2 => if(atx < this.b2.blockmaxx && aty < this.b2.blockmaxy){
        this.b2.cells(atx)(aty).isblocked
      }else{-1}
      case 3 => if(atx < this.b3.blockmaxx && aty < this.b3.blockmaxy){
        this.b3.cells(atx)(aty).isblocked
      }else{-1}
      case _ => -1
    }
  }
}
