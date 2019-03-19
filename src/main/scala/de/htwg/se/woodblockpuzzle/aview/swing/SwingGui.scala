package de.htwg.se.woodblockpuzzle.aview.swing
import de.htwg.se.woodblockpuzzle.controller.{Controller, FieldChanged}
import javax.swing.JButton

import scala.swing.event._
import scala.swing._
import scala.swing.Swing.LineBorder

class CellClicked(val x: Int, val y: Int) extends Event

class SwingGui(var controller : Controller) extends Frame{
  listenTo(controller)
  title = "WoodBlockPuzzle"
  preferredSize = new Dimension(400, 530)

  var cells = Array.ofDim[FieldButton](controller.fieldsize, controller.fieldsize)
  var chosenBlock = 1

  def setChosenBlock(i: Int) = {chosenBlock = i}

  def fieldPanel = new GridPanel(controller.fieldsize, controller.fieldsize) {
    border = LineBorder(java.awt.Color.BLACK, 1)
    background = java.awt.Color.BLACK
    preferredSize = new Dimension(300,300)
    for (y <- 1 to controller.fieldsize;
         x <- 1 to controller.fieldsize) {
      var b = new FieldButton(x, y, controller)
      contents += b
      cells(x-1)(y-1) = b
    }
   }

  def chosePanel = new GridPanel(1, 3) {
    border = LineBorder(java.awt.Color.BLUE, 2)
    background = java.awt.Color.BLUE
    preferredSize = new Dimension(300,20)
    contents += Button("Block 1") { setChosenBlock(1) }
    contents += Button("Block 2") { setChosenBlock(2) }
    contents += Button("Block 3") { setChosenBlock(3) }
  }
  def blockPanel = new GridPanel(1, 3) {
    border = LineBorder(java.awt.Color.BLUE, 2)
    background = java.awt.Color.BLUE
    preferredSize = new Dimension(300,100)
    contents += new BlockPanel(1, controller.b1.blockmaxx, controller.b1.blockmaxy, controller)
    contents += new BlockPanel(2, controller.b2.blockmaxx, controller.b2.blockmaxy, controller)
    contents += new BlockPanel(3, controller.b3.blockmaxx, controller.b3.blockmaxy, controller)
  }


  var statusline = new TextField("last event: "+controller.statusText, 20)
  var countLine = new TextField("count: " + controller.returnCount.toString
    +"\n highscore: " + controller.highscore, 20)
  contents = new BoxPanel(Orientation.Vertical) {
    contents += countLine
    contents += fieldPanel
    contents += chosePanel
    contents += blockPanel
    contents += statusline
    border = Swing.EmptyBorder(10, 10, 10, 10)
  }




  menuBar = new MenuBar {
    contents += new Menu("Game") {
      mnemonic = Key.G
      contents += new MenuItem(Action("New") { controller.reset})
      contents += new MenuItem(Action("Give Up") {controller.giveup})
      contents += new MenuItem(Action("Quit") { System.exit(0) })
    }
  }

  visible = true

  reactions += {
    case e: FieldChanged  => redraw
  }

  def redraw = {
    for (y <- 0 until controller.fieldsize;
      x <- 0 until controller.fieldsize){
      cells(x)(y).redraw
    }
    statusline.text = "last event: "+controller.statusText
    countLine.text = "count: " + controller.returnCount.toString +"\n highscore: " + controller.returnHighscore.toString
    repaint
  }
}
