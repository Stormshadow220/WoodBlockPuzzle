package de.htwg.se.woodblockpuzzle.model

case class Block(var blocktype: Integer){
  var blockmax = 0
  val cells: Array[Array[Cell]]


  if(blocktype == 0) {
    blockmax = 1
    fill
  }else if(blocktype == 1){
    blockmax = 2
    fill
    cells(0)(0).isblocked = 1
    cells(1)(0).isblocked = 1
  }else if(blocktype == 2){
    blockmax = 2
    fill
    cells(0)(0).isblocked = 1
    cells(1)(0).isblocked = 1
    cells(1)(1).isblocked = 1
  }else if(blocktype == 3){
    blockmax = 2
    fill
    cells(0)(0).isblocked = 1
    cells(0)(1).isblocked = 1
  }else if(blocktype == 4){
    blockmax = 3
    fill
    cells(0)(0).isblocked = 1
    cells(0)(1).isblocked = 1
    cells(0)(2).isblocked = 1
  }else if(blocktype == 5){
    blockmax = 3
    fill
    cells(0)(0).isblocked = 1
    cells(1)(0).isblocked = 1
    cells(2)(0).isblocked = 1
  }else if(blocktype == 6){
    blockmax = 2
    fill
    cells(0)(0).isblocked = 1
    cells(0)(1).isblocked = 1
    cells(1)(0).isblocked = 1
    cells(1)(1).isblocked = 1
  }else if(blocktype == 7){
    blockmax = 3
    fill
    cells(0)(0).isblocked = 1
    cells(1)(0).isblocked = 1
    cells(2)(0).isblocked = 1
    cells(0)(1).isblocked = 1
    cells(1)(1).isblocked = 1
    cells(2)(1).isblocked = 1
    cells(0)(2).isblocked = 1
    cells(1)(2).isblocked = 1
    cells(2)(2).isblocked = 1
  }else if(blocktype == 8){
    blockmax = 2
    fill
    cells(0)(0).isblocked = 1
    cells(1)(0).isblocked = 1
    cells(0)(1).isblocked = 1
  }else if(blocktype == 9){
    blockmax = 3
    fill
    cells(1)(0).isblocked = 1
    cells(0)(1).isblocked = 1
    cells(1)(1).isblocked = 1
    cells(2)(1).isblocked = 1
  }else if(blocktype == 10){
    blockmax = 4
    fill
    cells(0)(0).isblocked = 1
    cells(0)(1).isblocked = 1
    cells(0)(2).isblocked = 1
    cells(0)(3).isblocked = 1
  }else if(blocktype == 11){
    blockmax = 4
    fill
    cells(0)(0).isblocked = 1
    cells(1)(0).isblocked = 1
    cells(2)(0).isblocked = 1
    cells(3)(0).isblocked = 1
  }else if(blocktype == 12){
    blockmax = 5
    fill
    cells(0)(0).isblocked = 1
    cells(0)(1).isblocked = 1
    cells(0)(2).isblocked = 1
    cells(0)(3).isblocked = 1
    cells(0)(4).isblocked = 1

  }else if(blocktype == 13){
    blockmax = 4
    fill
    cells(0)(0).isblocked = 1
    cells(1)(0).isblocked = 1
    cells(2)(0).isblocked = 1
    cells(3)(0).isblocked = 1
    cells(4)(0).isblocked = 1
  }else if(blocktype == 14){
    blockmax = 3
    fill
    cells(0)(1).isblocked = 1
    cells(1)(1).isblocked = 1
    cells(2)(1).isblocked = 1
    cells(2)(0).isblocked = 1

  }else if(blocktype == 15){
    blockmax = 3
    fill
    cells(0)(1).isblocked = 1
    cells(1)(1).isblocked = 1
    cells(2)(1).isblocked = 1
    cells(0)(0).isblocked = 1

  }else if(blocktype == 16){
    blockmax = 3
    fill
    cells(1)(0).isblocked = 1
    cells(0)(1).isblocked = 1
    cells(1)(1).isblocked = 1
    cells(2)(0).isblocked = 1
  }else if(blocktype == 17){
    blockmax = 3
    fill
    cells(1)(0).isblocked = 1
    cells(0)(0).isblocked = 1
    cells(1)(1).isblocked = 1
    cells(2)(1).isblocked = 1
  }
  def fill: Unit ={
    val cells: Array[Array[Cell]] = Array.ofDim[Cell](blockmax, blockmax)
    for(y <- 0 until blockmax) {
      for (x <- 0 until blockmax) {
        cells(x)(y) = Cell(0)
      }
    }
  }

}
