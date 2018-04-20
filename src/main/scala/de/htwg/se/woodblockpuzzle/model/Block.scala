package de.htwg.se.woodblockpuzzle.model

case class Block(){
  val blockmax = 3
  val cells: Array[Array[Cell]] = Array.ofDim[Cell](blockmax, blockmax)
  for(y <- 0 until blockmax) {
    for(x <- 0 until blockmax) {
      cells(x)(y) = Cell(0)
    }
  }
}
