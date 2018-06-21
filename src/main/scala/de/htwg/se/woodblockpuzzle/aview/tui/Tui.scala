package de.htwg.se.woodblockpuzzle.aview.tui

import de.htwg.se.woodblockpuzzle.controller.Controller
import de.htwg.se.woodblockpuzzle.model
import scala.io.Source._


class Tui(var controller : Controller){
  printTui

  def printTui = {
    println("Count: "+controller.returnCount)
    println("Highscore: "+controller.returnHighscore)
    println(controller.showFieldWithCoordinates())
    print("b1\n"+controller.showBlock(1)+"\nb2\n"+controller.showBlock(2)+"\nb3\n"+controller.showBlock(2)+"\n")
    println("Enter command: q-Quit. n-Reset all & new game. sbxy - Set block b to x y. g-Give up & ceep points.")
  }
  def processInputLine(input: String) = {
    var continue = true
    input.charAt(0) match{
      case 'q' => continue = false
      case 'n' =>{
        controller.reset
        controller.create3RandomBlocks
        println("All points have been marked down, lets start new!")}
      case 's' =>{
        val b = Char.char2int(input.charAt(1))
        val x = Char.char2int(input.charAt(2))
        val y = Char.char2int(input.charAt(3))
        controller.addingBlock(b,x,y)
      }
      case 'g' =>{
        controller.giveup
        controller.create3RandomBlocks
        println("keep your highscore and try again!")
      }
    }
    continue
  }

}
