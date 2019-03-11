package de.htwg.se.woodblockpuzzle

import controller.Controller
import de.htwg.se.woodblockpuzzle.aview.swing.SwingGui
import de.htwg.se.woodblockpuzzle.aview.tui.Tui
object WoodBlockPuzzle {

  var controller = new Controller
  var tui = new Tui(controller)
  var swing = new SwingGui(controller)


  def main(args: Array[String]): Unit = {
    while(tui.processInputLine(readLine())){}
  }
}
