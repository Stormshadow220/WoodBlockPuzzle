case class Cell(var isblocked: Integer){
  def + (that: Cell):Cell = Cell(this.isblocked + that.isblocked)
}

var cell1 = Cell(0)
cell1.isblocked

val fieldsize = 3
val blockmax = 3

case class Field(){
  val cells: Array[Array[Cell]] = Array.ofDim[Cell](fieldsize, fieldsize)
  for(y <- 0 to (fieldsize-1)) {
    for(x <- 0 to (fieldsize-1)) {
      cells(x)(y) = Cell(0)
    }
  }
  def + (that:Block):Field={
    for (y <- 0 until fieldsize;
         x <- 0 until fieldsize) {
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

var field1 = Field()

case class Block(){
  val cells: Array[Array[Cell]] = Array.ofDim[Cell](blockmax, blockmax)
  for(y <- 0 to (blockmax-1)) {
    for(x <- 0 to (blockmax-1)) {
      cells(x)(y) = Cell(0)
    }
  }
}
var kleinerblock = Block()
kleinerblock.cells(0)(0).isblocked = 1
kleinerblock.cells(1)(0).isblocked = 1
kleinerblock.cells(0)(1).isblocked = 1

field1 = field1 + kleinerblock
//field1.cells(0)(0).isblocked = field1.cells(0)(0).isblocked + kleinerblock.cells(0)(0).isblocked
//field1 + kleinerblock
print(field1.cells(2)(2))

print(field1.toString)

for (y <- 0 to fieldsize-1){
  for (x <- 0 to fieldsize-1) {
    print(kleinerblock.cells(x)(y).isblocked+"  ")
  }
  print("\n")
}