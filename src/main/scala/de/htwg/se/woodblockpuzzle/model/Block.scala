package de.htwg.se.woodblockpuzzle.model

case class Block(var blocktype: Integer){
  var blockmax = 0
  val cells: Array[Array[Cell]]
  if(blocktype == 0) {
    blockmax = 0
    fill
  }else if(blocktype == 1){
    blockmax = 1
    fill
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
