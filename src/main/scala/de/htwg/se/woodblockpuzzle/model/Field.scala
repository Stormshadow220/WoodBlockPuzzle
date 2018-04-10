package de.htwg.se.woodblockpuzzle.model

case class Field() {
    val cells: Array[Array[Cell]] = Array.ofDim[Cell](8, 8)
    for(y <- 0 to 7) {
      for(x <- 0 to 7) {
        cells(x)(y) = Cell(true)
      }
    }
}
case class Cell(var isfree: Boolean)
