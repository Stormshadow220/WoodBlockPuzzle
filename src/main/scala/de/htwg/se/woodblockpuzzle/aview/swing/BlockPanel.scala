package de.htwg.se.woodblockpuzzle.aview.swing

import de.htwg.se.woodblockpuzzle.controller.{Controller, FieldChanged}
import javax.swing.ImageIcon

import scala.swing.Swing.LineBorder
import scala.swing._
import scala.swing.event.MouseClicked

class BlockPanel(controller: Controller) extends GridPanel(1,3){
  listenTo(controller)
  border = LineBorder(java.awt.Color.BLACK, 2)
  background = java.awt.Color.darkGray
  preferredSize = new Dimension(300,120)
  contents += getLabel(1)
  contents += getLabel(2)
  contents += getLabel(3)


  reactions += {
    case e: FieldChanged => {
      repaint
    }
  }
  def redraw = {
    print("Blocks: "+controller.availableBlocks+"\n")
    repaint
  }

  def getLabel(i: Int): Label = {
    var label = new Label() {
      preferredSize = new Dimension(100,100)
      icon = new ImageIcon("src/main/scala/de/htwg/se/woodblockpuzzle/aview/swing/blockImages/b"+controller.getBlockType(i)+".png")
      print("Label "+i+": b"+ controller.getBlockType(i)+".png")
    }
    return label
  }

}

