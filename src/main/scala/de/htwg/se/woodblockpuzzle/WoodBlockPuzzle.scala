package de.htwg.se.woodblockpuzzle
import model.Field
import model.Block
object WoodBlockPuzzle {
  def main(args: Array[String]): Unit = {
    var f = Field(8)
    print(f.toStringWithCoordinates)

    var b = Block(7)
    print("\n")
    print(b)
    f = f+(b, 0 ,0)

    print("___________________________________\n")
    print(f.toStringWithCoordinates)

    print("\n")
    print(b)
    f = f+(b, 0 ,0)
    print("___________________________________\n")
      print(f.toStringWithCoordinates)
    print(b)
    f = f+(b, 0 ,0)
    print("___________________________________\n")
    print(f.toStringWithCoordinates)

    var b1 = Block(7)
    print("\n")
    print(b1)
    f = f+(b1, 3 ,3)
    f = f+(b1, 0 ,3)
    print("___________________________________\n")
    print(f.toStringWithCoordinates)
    var b2 = Block(5)
    print("\n")
    print(b2)
    f = f+(b2, 0 ,6)
    f = f+(b2, 0 ,7)
    print("___________________________________\n")
    print(f.toStringWithCoordinates)
    f = f.eightInARow()
    print("___________________________________\n")
    print(f.toStringWithCoordinates)
    print(f.count)

  }
}
