case class Cell(free: Boolean)

var cell1 = Cell(true)
cell1.free

case class Field(){
  var cells: Array[Array[Cell]]
}



var field1 = Field()
field1.cells(2)(2).free = false

for (c <- field1.cells) {
  for (ck <- c) {
    ck.free = true
  }
}

field1.cells(2)(5).free.false

class Person()
