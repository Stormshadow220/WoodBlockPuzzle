package de.htwg.se.woodblockpuzzle.model

case class Cell(var isblocked: Int){
  def + (that: Cell):Cell = Cell(this.isblocked + that.isblocked)
}
