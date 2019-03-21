package de.htwg.se.woodblockpuzzle.aview.swing

import de.htwg.se.woodblockpuzzle.controller.{Controller, FieldChanged}

import scala.swing.Swing.LineBorder
import scala.swing._
import scala.swing.event._

class CellClicked(val x: Int, val y: Int) extends Event

class SwingGui(var controller : Controller) extends Frame{
  listenTo(controller)
  title = "WoodBlockPuzzle"
  preferredSize = new Dimension(380, 530)

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
    preferredSize = new Dimension(300,20)
    contents += Button("Block 1") { setChosenBlock(1) }
    contents += Button("Block 2") { setChosenBlock(2) }
    contents += Button("Block 3") { setChosenBlock(3) }
  }
  def blockPanel = new GridPanel(1, 3) {
    border = LineBorder(java.awt.Color.BLACK, 2)
    background = java.awt.Color.darkGray
    preferredSize = new Dimension(300,120)
    var b1Panel = new BlockPanel(controller.getBlockType(1))
    var b2Panel = new BlockPanel(controller.getBlockType(2))
    var b3Panel = new BlockPanel(controller.getBlockType(3))
    contents += b1Panel
    contents += b2Panel
    contents += b3Panel
  }


  var statusline = new TextField("last event: "+controller.statusText, 20)
  var countLine = new Label("count: " + controller.returnCount.toString +"\t highscore: "
    + controller.highscore, null, Alignment.Center)

  contents = new BoxPanel(Orientation.Vertical) {
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
    contents += new Label("                ")
    contents += countLine
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
