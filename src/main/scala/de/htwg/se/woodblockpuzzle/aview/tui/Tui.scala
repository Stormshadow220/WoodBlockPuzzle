package de.htwg.se.woodblockpuzzle.aview.tui

import de.htwg.se.woodblockpuzzle.controller.Controller
import de.htwg.se.woodblockpuzzle.model
import scala.io.Source._


class Tui(var controller : Controller){
  printTui

  def printTui = {
    println("Count: "+controller.returnCount)
    println("Count: "+controller.returnCount)
    println(controller.showFieldWithCoordinates())
    print("b1\n"+controller.showBlock(1)+"\nb2\n"+controller.showBlock(2)+"\nb3\n"+controller.showBlock(2))
    println("Enter commands: r-reset & new game. sbxy - set block b to x y. g-give up, ceep points.")
  }


}
