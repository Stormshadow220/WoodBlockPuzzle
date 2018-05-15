package de.htwg.se.woodblockpuzzle.model

case class Field(fs: Integer) {
  val fieldsize = fs
  val cells: Array[Array[Cell]] = Array.ofDim[Cell](fieldsize, fieldsize)
  for(y <- 0 until fieldsize) {
    for(x <- 0 until fieldsize) {
      cells(x)(y) = Cell(0)
    }
  }
  def + (that:Block,atx:Integer,aty:Integer):Field={
    for (y <- aty until that.blockmax;
         x <- atx until that.blockmax) {
      this.cells(x)(y)=this.cells(x)(y) + that.cells(x)(y)
    }
    this
  }

  override def toString: String = {
    var str = ""
    for (y <- 0 until fieldsize){
      for (x <- 0 until fieldsize) {
        str += this.cells(x)(y).isblocked+" "
      }
      str += ("\n")
    }
    str
  }
}
