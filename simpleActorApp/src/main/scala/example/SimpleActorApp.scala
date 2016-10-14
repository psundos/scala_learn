package example

import akka.actor.{Actor, ActorSystem, Props}
import akka.actor.Actor.Receive

/**
  * Created by psun on 10/14/2016.
  */
object SimpleActorApp extends App{
  class SimpleActor extends Actor {
    override def receive = {
      case s:String => println("String: "+s)
      case i:Int => println("Number: "+i)
    }

    def foo = println("Normal method")
  }

  val system = ActorSystem("SimpleSystem")
  val actor = system.actorOf(Props[SimpleActor], "SimpleActor")

  println("Before messages")
  actor ! "Hi there"
  println("After string")
  actor ! 42
  println("After int")
  actor ! 'a'
  println("After char")

}
