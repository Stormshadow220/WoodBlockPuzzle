package de.htwg.se.woodblockpuzzle.model

import org.scalatest._


class CellSpec extends WordSpec with Matchers {
  "A Cell" when {
    "new" should {
      val cell = Cell(0)
      "isblocked be 0"  in {
        cell.isblocked should be(0)
      }
    }
  }
}
