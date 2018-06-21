package de.htwg.se.woodblockpuzzle.controller
import de.htwg.se.woodblockpuzzle.model.{Block, Field}
class Controller(){
  var field: Field = Field(0)
  var b1: Block = Block(-1)
  var b2: Block = Block(-1)
  var b3: Block = Block(-1)
  var availableBlocks = 0
  var highscore = 0

  def reset: Unit = {
    createField
    this.b1 = Block(-1)
    this.b2 = Block(-1)
    this.b3 = Block(-1)
    this.availableBlocks = 0
    highscore = 0
  }

  def giveup: Unit = {
    if(this.field.count > highscore){highscore = returnCount}
    createField
    this.b1 = Block(-1)
    this.b2 = Block(-1)
    this.b3 = Block(-1)
    this.availableBlocks = 0
  }

  def createField: Unit = this.field = Field(8)

  def createBlock(x: Int): Block = {
    var b = Block(x)
    b
  }

  def create3RandomBlocks = {
    var r = scala.util.Random
    this.b1 = createBlock(r.nextInt(17))
    this.b2 = createBlock(r.nextInt(17))
    this.b3 = createBlock(r.nextInt(17))
    this.availableBlocks = 3
  }


  def addingBlock(blocknumber: Int, atx: Int, aty: Int): Unit = {
    blocknumber match {
      case 1 => field = field + (b1, atx-1, aty-1)
        availableBlocks-=1
        b1 = Block(-1)
      case 2 => field = field + (b2, atx-1, aty-1)
        availableBlocks-=1
        b2 = Block(-1)
      case 3 => field = field + (b3, atx-1, aty-1)
        availableBlocks-=1
        b3 = Block(-1)
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

  def showFieldWithCoordinates(): String = this.field.toStringWithCoordinates

  def deleteFullRows() = this.field = this.field.eightInARow()

  def returnCount:Int = this.field.count

  def returnHighscore:Int = this.highscore

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
