package de.htwg.se.woodblockpuzzle.aview.swing

import scala.swing._
import scala.swing.event._
import de.htwg.se.woodblockpuzzle.controller.Controller
import de.htwg.se.woodblockpuzzle.controller.FieldChanged

class CellPanel(x: Int, y: Int, controller: Controller, chosen: Int) extends FlowPanel {
  val emptyCellColor = java.awt.Color.darkGray
  val blockedCellColor = java.awt.Color.green
  val cellBlocked = (controller.getCellStatusAtField(x, y) == 1)
  val chosenBlock = chosen

  val cell = new BoxPanel(Orientation.Vertical) {
    preferredSize = new Dimension(51, 51)
    maximumSize = new Dimension(51, 51)
    background = if (cellBlocked) emptyCellColor else blockedCellColor
    border = Swing.BeveledBorder(Swing.Raised)
    listenTo(mouse.clicks)
    listenTo(controller)
    reactions += {
      case e: FieldChanged => {
        repaint
      }
      case MouseClicked(src, pt, mod, clicks, pops) => {
        controller.addBlock(chosenBlock,x,y)
        repaint
      }
    }
  }

  def redraw = {
    contents.clear()
    setBackground(cell)
    contents += cell
    repaint
  }

  def setBackground(p: Panel) = p.background = if(!cellBlocked) blockedCellColor else emptyCellColor


}