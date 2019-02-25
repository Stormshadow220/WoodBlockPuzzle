package de.htwg.se.woodblockpuzzle.model

case class Field(fs: Int) {
  val fieldsize = fs
  val cells: Array[Array[Cell]] = Array.ofDim[Cell](fieldsize, fieldsize)
  var count = 0
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
    if(!fit){
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
  def toStringWithCoordinates: String = {
    var str = " |1_2_3_4_5_6_7_8\n"
    for (y <- 0 until fieldsize){
      str += (y+1)+"|"
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
      if(this.cells(x)(y).isblocked > 1){
        return false
      }
    }
    return true
  }
  def eightInARow():Field = {
    var out = Field(8)
    out.count = this.count
    for (y <- 0 until fieldsize){
      for (x <- 0 until fieldsize) {
        out.cells(x)(y) = this.cells(x)(y)
      }
    }
    for(pos <- 0 until fieldsize){
      if(this.cells(0)(pos).isblocked == 1 && this.cells(1)(pos).isblocked == 1 && this.cells(2)(pos).isblocked == 1 && this.cells(3)(pos).isblocked == 1 && this.cells(4)(pos).isblocked == 1 && this.cells(5)(pos).isblocked == 1 && this.cells(6)(pos).isblocked == 1 && this.cells(7)(pos).isblocked == 1){
        out.cells(0)(pos).isblocked = 0
        out.cells(1)(pos).isblocked = 0
        out.cells(2)(pos).isblocked = 0
        out.cells(3)(pos).isblocked = 0
        out.cells(4)(pos).isblocked = 0
        out.cells(5)(pos).isblocked = 0
        out.cells(6)(pos).isblocked = 0
        out.cells(7)(pos).isblocked = 0
        out.count= out.count + 1
      }
      if(this.cells(pos)(0).isblocked == 1 && this.cells(pos)(1).isblocked == 1 && this.cells(pos)(2).isblocked == 1 && this.cells(pos)(3).isblocked == 1 && this.cells(pos)(4).isblocked == 1 && this.cells(pos)(5).isblocked == 1 && this.cells(pos)(6).isblocked == 1 && this.cells(pos)(7).isblocked == 1){
        out.cells(pos)(0).isblocked = 0
        out.cells(pos)(1).isblocked = 0
        out.cells(pos)(2).isblocked = 0
        out.cells(pos)(3).isblocked = 0
        out.cells(pos)(4).isblocked = 0
        out.cells(pos)(5).isblocked = 0
        out.cells(pos)(6).isblocked = 0
        out.cells(pos)(7).isblocked = 0
        out.count= out.count + 1
      }
    }
    return out
  }
}