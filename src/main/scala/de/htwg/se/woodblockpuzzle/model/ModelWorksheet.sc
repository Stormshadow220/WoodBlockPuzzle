case class Cell(var isfree: Boolean)

var cell1 = Cell(true)
cell1.isfree

case class Field(){
  val cells: Array[Array[Cell]] = Array.ofDim[Cell](8, 8)
  for(y <- 0 to 7) {
    for(x <- 0 to 7) {
      cells(x)(y) = Cell(true)
    }
  }
}



var field1 = Field()
field1.cells(5)(2).isfree = false

for (y <- 0 to 7){
  for (x <- 0 to 7) {
    print(field1.cells(x)(y).isfree + "|")
  }
  print("\n")
}

field1.cells(2)(5).isfree = false

class Person()
