package de.htwg.se.woodblockpuzzle.aview.swing

import scala.swing._
import scala.swing.event._
import de.htwg.se.woodblockpuzzle.controller.Controller
import de.htwg.se.woodblockpuzzle.controller.FieldChanged

class CellPanel(x: Int, y: Int, controller: Controller) extends FlowPanel {
  val emptyCellColor = java.awt.Color.darkGray
  val blockedCellColor = java.awt.Color.green
  var cellBlocked = (controller.getCellStatusAtField(x, y) == 1)


  background = if (!cellBlocked) emptyCellColor else blockedCellColor
  border = Swing.BeveledBorder(Swing.Raised)
  listenTo(mouse.clicks)
  listenTo(controller)
  reactions += {
    case e: FieldChanged => {
      repaint
    }
    case MouseClicked(src, pt, mod, clicks, pops) => {
      controller.addBlock(controller.chosenBlock,x,y)
      repaint
    }
  }

  def redraw = {
    cellBlocked = (controller.getCellStatusAtField(x, y) == 1)
    setBackground(this)
    repaint
  }

  def setBackground(p: Panel) = p.background = if(!cellBlocked) emptyCellColor else blockedCellColor


}