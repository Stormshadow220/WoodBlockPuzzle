package de.htwg.se.woodblockpuzzle.aview.swing

import scala.swing._
import scala.swing.event._
import de.htwg.se.woodblockpuzzle.controller.Controller
import de.htwg.se.woodblockpuzzle.controller.FieldChanged

class CellPanel(x: Int, y: Int, controller: Controller) extends FlowPanel {
  val emptyCellColor = new Color(200, 200, 255)
  val blockedCellColor = new Color(224, 224, 255)
  val cellText = controller.getCellStatusAtField(x,y)
  val cellBlocked = (controller.getCellStatusAtField(x, y) == 1)

  val label =
    new Label {
      text = " " + cellText
      font = new Font("Verdana", 1, 36)
  }





  val cell = new BoxPanel(Orientation.Vertical) {
    contents += label
    preferredSize = new Dimension(51, 51)
    background = if (cellBlocked) blockedCellColor else emptyCellColor
    border = Swing.BeveledBorder(Swing.Raised)
    listenTo(mouse.clicks)
    listenTo(controller)
    reactions += {
      case e: FieldChanged => {
        label.text = " " + cellText
        repaint
      }
      case MouseClicked(src, pt, mod, clicks, pops) => {
        controller.getCellStatusAtField(x, y)
        repaint
      }
    }
  }

  val candidatelist = (1 to controller.fieldsize).map {
    (value =>
      new Label {
        text = if (cellBlocked) "1" else "0"
        preferredSize = new Dimension(17, 17)
        font = new Font("Verdana", 1, 9)
        background = emptyCellColor
        border = Swing.BeveledBorder(Swing.Raised)
        listenTo(mouse.clicks)
        listenTo(controller)
        reactions += {
          case e: FieldChanged => {
            text = if (cellBlocked) "1" else "0"
            repaint
          }
          case MouseClicked(src, pt, mod, clicks, pops) => {
            controller.addBlock(1, x, y)
            text = if (cellBlocked) "1" else "0"
            repaint
          }
        }
      })
  }

  val candidates = new GridPanel(controller.fieldsize, controller.fieldsize) {
    setBackground(this)
    contents ++= candidatelist
  }
  contents += candidates

  def redraw = {
    contents.clear()
   // if ((myCell.isShowingCandidates || controller.showAllCandidates) && !myCell.isSet) {
     // setBackground(candidates)
      //contents += candidates
    //} else {
      label.text = " " + cellText
      setBackground(cell)
      contents += cell
    //}
    repaint
  }

  def setBackground(p: Panel) = p.background =
    if(controller.getCellStatusAtField(x, y) == 1) blockedCellColor
  else emptyCellColor


}