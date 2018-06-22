package de.htwg.se.woodblockpuzzle.util

class Observer {
  def update
}
class Observable{
  var subscriber: Vector[Observer] = Vector()
  def add
}
