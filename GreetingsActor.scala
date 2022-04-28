import akka.actor.{Actor, Props}

case class Hello(times: Int = 1)
case class HelloResponse(response: String)

class GreetingsActor extends Actor {

  var count: Int = 0

  override def receive: Receive = {
    case Hello(times) => { count += 1; sender ! HelloResponse( "Hello Greetings " * times ) }
    case Count() => sender ! CountResponse(count)
    case _ => unhandled()
  }
}

object GreetingsActor {
  def props = Props(classOf[GreetingsActor])
}

