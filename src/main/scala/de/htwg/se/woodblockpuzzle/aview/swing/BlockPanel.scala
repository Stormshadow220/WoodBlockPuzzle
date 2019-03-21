package de.htwg.se.woodblockpuzzle.aview.swing

import javax.swing.ImageIcon

import scala.swing._

class BlockPanel(blockType:Int) extends FlowPanel(){
  background = java.awt.Color.white
  preferredSize = new Dimension(100,100)
  visible = true

  val label = new Label() {
    icon = new ImageIcon("src/main/scala/de/htwg/se/woodblockpuzzle/aview/swing/blockImages/b"+blockType+".png")
  }
  this.contents += label


}

