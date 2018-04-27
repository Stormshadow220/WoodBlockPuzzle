package de.htwg.se.woodblockpuzzle.model

case class Field() {
  val fieldsize = 3
  val cells: Array[Array[Cell]] = Array.ofDim[Cell](fieldsize, fieldsize)
  for(y <- 0 until fieldsize-1) {
    for(x <- 0 until fieldsize-1) {
      cells(x)(y) = Cell(0)
    }
  }
  def + (that:Block):Field={
    for (y <- 0 until that.blockmax;
         x <- 0 until that.blockmax) {
      this.cells(x)(y)=this.cells(x)(y) + that.cells(x)(y)
    }
    this
  }

  override def toString: String = {
    var str = ""
    for (y <- 0 to fieldsize-1){
      for (x <- 0 to fieldsize-1) {
        str += this.cells(x)(y).isblocked+" "
      }
      str += ("\n")
    }
    str
  }
}
