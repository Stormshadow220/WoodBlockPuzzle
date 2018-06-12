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
    if (aty+that.blockmaxy > fieldsize ||atx+that.blockmaxx > fieldsize){
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
  def eightInARow(f:Field):Field = {
    for(pos <- 0 until fieldsize){
      if(f.cells(0)(pos).isblocked == 1 && f.cells(1)(pos).isblocked == 1 && f.cells(2)(pos).isblocked == 1 &&f.cells(3)(pos).isblocked == 1 && f.cells(4)(pos).isblocked == 1 && f.cells(5)(pos).isblocked == 1 && f.cells(6)(pos).isblocked == 1 && f.cells(7)(pos).isblocked == 1){
        f.cells(0)(pos).isblocked == 0
        f.cells(1)(pos).isblocked == 0
        f.cells(2)(pos).isblocked == 0
        f.cells(3)(pos).isblocked == 0
        f.cells(4)(pos).isblocked == 0
        f.cells(5)(pos).isblocked == 0
        f.cells(6)(pos).isblocked == 0
        f.cells(7)(pos).isblocked == 0
      }
      if(f.cells(pos)(0).isblocked == 1 && f.cells(pos)(1).isblocked == 1 && f.cells(pos)(2).isblocked == 1 &&f.cells(pos)(3).isblocked == 1 && f.cells(pos)(4).isblocked == 1 && f.cells(pos)(5).isblocked == 1 && f.cells(pos)(6).isblocked == 1 && f.cells(pos)(7).isblocked == 1){
        f.cells(pos)(0).isblocked == 0
        f.cells(pos)(1).isblocked == 0
        f.cells(pos)(2).isblocked == 0
        f.cells(pos)(3).isblocked == 0
        f.cells(pos)(4).isblocked == 0
        f.cells(pos)(5).isblocked == 0
        f.cells(pos)(6).isblocked == 0
        f.cells(pos)(7).isblocked == 0
      }
    }
    return f
  }
}