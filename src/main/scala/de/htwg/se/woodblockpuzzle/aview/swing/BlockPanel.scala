package de.htwg.se.woodblockpuzzle.aview.swing

import scala.swing._
import scala.swing.event._
import de.htwg.se.woodblockpuzzle.controller.Controller
import de.htwg.se.woodblockpuzzle.controller.FieldChanged
class BlockPanel(blocknumber : Int, maxX: Int, maxY: Int, controller: Controller) extends GridPanel(maxX, maxY){

  val emptyCellColor = java.awt.Color.darkGray
  val blockedCellColor = java.awt.Color.green
  var cells = Array.ofDim[Int](maxX, maxY)
  for (y <- 1 to maxY;
       x <- 1 to maxX){
      cells(x-1)(y-1) = controller.getCellStatusAtBlock(blocknumber,x,y)
  }

  def redraw = {
    //contents.clear()
    //setBackground(cell)
    //contents += cell
    repaint
  }
  //def setBackground(p: Panel) = p.background = if(!cellBlocked) blockedCellColor else emptyCellColor

}
