package de.htwg.se.woodblockpuzzle.controller
import de.htwg.se.woodblockpuzzle.model.{Block, Field}
import org.scalatest._


class ControllerSpec extends WordSpec with Matchers{
  "A controller" when {
    var controller = Controller
    "new" should {
      "create nothing, unless u used the right funktion" in{
        controller
      }
    }
    "should create 3 new blocks with random blocktype between 0 and 17" in{
      controller
      "after using create3RandomBlocks"

    }

  }
}
