import de.htwg.se.woodblockpuzzle.model.Block

var i = -1
while(i < 18) {
  val b = new Block(i)
  print(i + ":\n\n")
  print("" + b.toString)
  println("\n\n")
  i += 1
}




