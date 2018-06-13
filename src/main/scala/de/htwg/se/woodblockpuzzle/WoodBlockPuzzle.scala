package de.htwg.se.woodblockpuzzle
import model.Field
import model.Block
object WoodBlockPuzzle {
  def main(args: Array[String]): Unit = {
    var f = Field(8)
    print(f)

    var b = Block(7)
    print("\n")
    print(b)
    f = f+(b, 0 ,0)

    print("___________________________________\n")
    print(f)

    print("\n")
    print(b)
    f = f+(b, 0 ,0)
    print("___________________________________\n")
    print(f)
    print(b)
    f = f+(b, 0 ,0)
    print("___________________________________\n")
    print(f)

    var b1 = Block(7)
    print("\n")
    print(b1)
    f = f+(b1, 3 ,3)
    print("___________________________________\n")
    print(f)

  }
}
