package de.htwg.se.woodblockpuzzle.model

case class Field(fs: Int) {
  val fieldsize = fs
  val cells: Array[Array[Cell]] = Array.ofDim[Cell](fieldsize, fieldsize)
  for(y <- 0 until fieldsize) {
    for(x <- 0 until fieldsize) {
      cells(x)(y) = Cell(0)
    }
  }
  def + (that:Block,atx:Int,aty:Int):Field={
    val backup : this
    for (y <- aty until that.blockmaxy;
         x <- atx until that.blockmaxx) {
      this.cells(x)(y)=this.cells(x)(y) + that.cells(x)(y)
    }
    if(!fit()){
      return backup
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

  def fit():Boolean={
    for (y <- 0 until fieldsize;
         x <- 0 until fieldsize){
      if(this.cells(x)(y).isblocked == 2){
        return false
      }
    }
    return true
  }
}