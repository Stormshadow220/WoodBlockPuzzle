package de.htwg.se.woodblockpuzzle.aview.swing
import de.htwg.se.woodblockpuzzle.controller.{Controller, FieldChanged}

import scala.swing.Button
import scala.swing.event.MouseClicked


class FieldButton(x: Int, y: Int, controller: Controller) extends Button{
  text = controller.getCellStatusAtField(x,y).toString
  reactions += {
    case _: FieldChanged => {
      redraw
      repaint
    }
    case MouseClicked(_, _, _, _, _) => {
      controller.addBlock(1,x,y)
      redraw
      repaint
    }
  }
  def redraw: Unit = {
    this.text = controller.getCellStatusAtField(x,y).toString
    repaint
  }
}
