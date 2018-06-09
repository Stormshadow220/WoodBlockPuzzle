package de.htwg.se.woodblockpuzzle.controller
import de.htwg.se.woodblockpuzzle.model.{Block, Field}
import de.htwg.se.woodblockpuzzle.controller.Controller
import org.scalatest._


class ControllerSpec extends WordSpec with Matchers{
  "A controller" when {
    val controller1 = Controller
    "new" should {
      "create nothing, unless u used the right funktion" in{
        controller1
        controller1
      }
    }
    "should create 3 new blocks with random blocktype between 0 and 17" in{
      "after using create3RandomBlocks"
      controller1.

    }

  }
}
