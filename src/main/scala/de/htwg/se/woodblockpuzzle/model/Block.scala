package de.htwg.se.woodblockpuzzle.model

case class Block(var blocktype: Int){
  var blockmaxx, blockmaxy = 0
  val cells : Array[Array[Cell]]

  if(blocktype == 0) {
    blockmaxx = 1
    blockmaxy = 1
    fill
  }else if(blocktype == 1){
    blockmaxx = 2
    blockmaxy = 1
    fill
    cells(0)(0).isblocked = 1
    cells(1)(0).isblocked = 1
  }else if(blocktype == 2){
    blockmaxx = 2
    blockmaxy = 2
    fill
    cells(0)(0).isblocked = 1
    cells(1)(0).isblocked = 1
    cells(1)(1).isblocked = 1
  }else if(blocktype == 3){
    blockmaxx = 1
    blockmaxy = 2
    fill
    cells(0)(0).isblocked = 1
    cells(0)(1).isblocked = 1
  }else if(blocktype == 4){
    blockmaxx = 1
    blockmaxy = 3
    fill
    cells(0)(0).isblocked = 1
    cells(0)(1).isblocked = 1
    cells(0)(2).isblocked = 1
  }else if(blocktype == 5){
    blockmaxx = 3
    blockmaxy = 1
    fill
    cells(0)(0).isblocked = 1
    cells(1)(0).isblocked = 1
    cells(2)(0).isblocked = 1
  }else if(blocktype == 6){
    blockmaxx = 2
    blockmaxy = 2
    fill
    cells(0)(0).isblocked = 1
    cells(0)(1).isblocked = 1
    cells(1)(0).isblocked = 1
    cells(1)(1).isblocked = 1
  }else if(blocktype == 7){
    blockmaxx = 3
    blockmaxy = 3
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
    blockmaxx = 2
    blockmaxy = 2
    fill
    cells(0)(0).isblocked = 1
    cells(1)(0).isblocked = 1
    cells(0)(1).isblocked = 1
  }else if(blocktype == 9){
    blockmaxx = 3
    blockmaxy = 2
    fill
    cells(1)(0).isblocked = 1
    cells(0)(1).isblocked = 1
    cells(1)(1).isblocked = 1
    cells(2)(1).isblocked = 1
  }else if(blocktype == 10){
    blockmaxx = 1
    blockmaxy = 4
    fill
    cells(0)(0).isblocked = 1
    cells(0)(1).isblocked = 1
    cells(0)(2).isblocked = 1
    cells(0)(3).isblocked = 1
  }else if(blocktype == 11){
    blockmaxx = 4
    blockmaxy = 1
    fill
    cells(0)(0).isblocked = 1
    cells(1)(0).isblocked = 1
    cells(2)(0).isblocked = 1
    cells(3)(0).isblocked = 1
  }else if(blocktype == 12){
    blockmaxx = 1
    blockmaxy = 5
    fill
    cells(0)(0).isblocked = 1
    cells(0)(1).isblocked = 1
    cells(0)(2).isblocked = 1
    cells(0)(3).isblocked = 1
    cells(0)(4).isblocked = 1

  }else if(blocktype == 13){
    blockmaxx = 5
    blockmaxy = 1
    fill
    cells(0)(0).isblocked = 1
    cells(1)(0).isblocked = 1
    cells(2)(0).isblocked = 1
    cells(3)(0).isblocked = 1
    cells(4)(0).isblocked = 1
  }else if(blocktype == 14){
    blockmaxx = 3
    blockmaxy = 2
    fill
    cells(0)(1).isblocked = 1
    cells(1)(1).isblocked = 1
    cells(2)(1).isblocked = 1
    cells(2)(0).isblocked = 1

  }else if(blocktype == 15){
    blockmaxx = 3
    blockmaxy = 2
    fill
    cells(0)(1).isblocked = 1
    cells(1)(1).isblocked = 1
    cells(2)(1).isblocked = 1
    cells(0)(0).isblocked = 1

  }else if(blocktype == 16){
    blockmaxx = 3
    blockmaxy = 2
    fill
    cells(1)(0).isblocked = 1
    cells(0)(1).isblocked = 1
    cells(1)(1).isblocked = 1
    cells(2)(0).isblocked = 1
  }else if(blocktype == 17){
    blockmaxx = 3
    blockmaxy = 2
    fill
    cells(1)(0).isblocked = 1
    cells(0)(0).isblocked = 1
    cells(1)(1).isblocked = 1
    cells(2)(1).isblocked = 1
  }
  def fill: Unit ={
    val cells: Array[Array[Cell]] = Array.ofDim[Cell](blockmaxx, blockmaxy)
    for(y <- 0 until blockmaxy) {
      for (x <- 0 until blockmaxx) {
        cells(x)(y) = Cell(0)
      }
    }
  }

}
