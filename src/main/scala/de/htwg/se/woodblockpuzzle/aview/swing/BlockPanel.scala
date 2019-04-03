package de.htwg.se.woodblockpuzzle.aview.swing

import de.htwg.se.woodblockpuzzle.controller.{Controller, FieldChanged}
import javax.swing.{ImageIcon, SwingUtilities}

import scala.swing.Swing.LineBorder
import scala.swing._
import scala.swing.event.MouseClicked

class BlockPanel(controller: Controller) extends GridPanel(1,3){
  border = LineBorder(java.awt.Color.BLACK, 2)
  background = java.awt.Color.darkGray
  var clickedLabel = 1
  preferredSize = new Dimension(300,120)
  contents += getLabel(1)
  contents += getLabel(2)
  contents += getLabel(3)

  listenTo(controller)

  reactions += {
    case e: FieldChanged => {
      redraw
    }
  }
  def redraw = {
    print("Blocks: "+controller.availableBlocks+"\n")
    SwingUtilities.invokeLater(new Runnable {
      override def run(): Unit = {
        contents.clear
        contents += getLabel(1)
        contents += getLabel(2)
        contents += getLabel(3)
        revalidate
        repaint
      }
    })
  }

  def getLabel(i: Int): Label = {
    var label = new Label() {
      preferredSize = new Dimension(100,100)
      icon = new ImageIcon("src/main/scala/de/htwg/se/woodblockpuzzle/aview/swing/blockImages/b"+controller.getBlockType(i)+".png")
      listenTo(mouse.clicks)
      reactions += {
        case MouseClicked(src, pt, mod, clicks, pops) => {
          clicked(i)
        }
      }
    }
    return label
  }
  def clicked(i: Int)= {
    controller.setChosenBlock(i)
    this.clickedLabel = i
  }

}