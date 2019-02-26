package de.htwg.se.woodblockpuzzle

import controller.Controller
import de.htwg.se.woodblockpuzzle.aview.tui.Tui
import de.htwg.se.woodblockpuzzle.model.Field
object WoodBlockPuzzle {

  val field = new Field(8)
  var controller = new Controller
  var tui = new Tui(controller)


  def main(args: Array[String]): Unit = {
    while(tui.processInputLine(readLine())){}
  }
}
