package de.htwg.se.woodblockpuzzle.aview.swing
import de.htwg.se.woodblockpuzzle.controller.{Controller, FieldChanged}
import javax.swing.JButton

import scala.swing.event._
import scala.swing._
import scala.swing.Swing.LineBorder

class CellClicked(val row: Int, val column: Int) extends Event

class SwingGui(var controller : Controller) extends Frame{
  listenTo(controller)
  title = "WoodBlockPuzzle"
  val cells: Array[Array[JButton]] = Array.ofDim[JButton](controller.fieldsize, controller.fieldsize)




  val statusline = new TextField(controller.statusText, 20)

  contents = new BorderPanel {
    //add(gridPanel, BorderPanel.Position.Center)
    add(statusline, BorderPanel.Position.South)
  }




  menuBar = new MenuBar {
    contents += new Menu("Game") {
      mnemonic = Key.G
      contents += new MenuItem(Action("New") { controller.reset})
      contents += new MenuItem(Action("Give Up") {controller.giveup})
      contents += new MenuItem(Action("Quit") { System.exit(0) })
      contents += new MenuItem(Action("Testset") { controller.addBlock(1,2,2)})
    }
  }

  visible = true

  reactions += {
    case e: FieldChanged  => redraw
  }

  def redraw = {
    for (y <- 0 until controller.fieldsize;
         x <- 0 until controller.fieldsize){
        //cells(x)(y).setText(controller.getCellStatusAtField(x,y).toString)
      //cells(x)(y).setText("0")
    }
    repaint
  }
}
