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
    var backup = Field(8)
    for (y <- 0 until fieldsize){
      for (x <- 0 until fieldsize) {
        backup.cells(x)(y) = this.cells(x)(y)
      }
    }
    if (aty > fieldsize ||atx > fieldsize){
      return backup
    }
    for (y <- 0 until that.blockmaxy;
         x <- 0 until that.blockmaxx) {
      if(x<=fieldsize && y<=fieldsize){
        this.cells(atx+x)(aty+y)=this.cells(atx+x)(aty+y) + that.cells(x)(y)
      }else{
        return backup
      }
    }
    if(!fit(this)){
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

  def fit(f:Field):Boolean={
    for (y <- 0 until fieldsize;
         x <- 0 until fieldsize){
      if(f.cells(x)(y).isblocked > 1){
        print("passt nicht")
        return false
      }
    }
    return true
  }
}