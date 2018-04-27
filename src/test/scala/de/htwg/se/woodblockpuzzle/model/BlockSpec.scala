package de.htwg.se.woodblockpuzzle.model

import org.scalatest._

class BlockSpec extends WordSpec with Matchers{
    "A Block" when{
      "new and Blocktype = 0" should{
        "blockmax should be 1 and the body of block should" in{
          var block = Block(0)

        }
        }
      }
}
