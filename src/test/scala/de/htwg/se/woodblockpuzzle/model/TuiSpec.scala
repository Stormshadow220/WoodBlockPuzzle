package de.htwg.se.woodblockpuzzle.aview.tui
import de.htwg.se.woodblockpuzzle.controller.Controller
import org.scalatest._


class TuiSpec  extends WordSpec with Matchers{
  "A Tui"when{
    var controller1 = new Controller
    var tui = new Tui(controller1)
    "new" should{
      "get controller as parameter and print the current count, highscore, field with coordinates and all 3 blocks" in {
        // Nothing
      }
    }

    "in use" should {
      "quit the input if q was put in" in {
        tui.processInputLine("q") should be(false)
      }
      "return true if the input was correct" in {
        tui.processInputLine("n") should be(true)
      }
      "can call the reset function of the controller to reset the controller completely"in{
        controller1.highscore = 200
        tui.processInputLine("n")
        for(y <- 0 until controller1.field.fieldsize;
            x <- 0 until controller1.field.fieldsize){
          controller1.field.cells(x)(y).isblocked should be(0)
        }
        controller1.highscore should be(0)
        controller1.statusText should be("reset")
      }
      "can call the giveup function of the controller and ceep the highscore"in{
        controller1.reset
        controller1.highscore = 200
        tui.processInputLine("g")
        controller1.highscore should be(200)
        controller1.statusText should be("give up")
      }
      "can call the funktion addblock"in{
        controller1.reset
        tui.processInputLine("111")
        controller1.availableBlocks should be(2)
        controller1.history.size should be(1)
        controller1.b1.blocktype should be(-1)
      }
      "and reverse the move afterwards"in{
        controller1.reset
        tui.processInputLine("111")
        controller1.reverse()
        controller1.availableBlocks should be(3)
        controller1.history.size should be(0)
        controller1.b1.blocktype should not be(-1)
      }
    }
  }
}
