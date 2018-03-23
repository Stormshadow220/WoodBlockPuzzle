package de.htwg.se.woodblockpuzzle

import de.htwg.se.woodblockpuzzle.model.Player

object WoodBlockPuzzle {
  def main(args: Array[String]): Unit = {
    val student = Player("Your Name")
    println("Hello, " + student.name)
  }
}
