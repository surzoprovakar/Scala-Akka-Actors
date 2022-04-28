import akka.actor.{ActorRef, ActorSystem, PoisonPill}

object Main extends App{
  val _system: ActorSystem = ActorSystem.create("hello-system")
  val supervisor: ActorRef = _system.actorOf(SupervisorActor.props)

  supervisor ! Hello(5)
  supervisor ! Hello(2)
  supervisor ! Hello(3)
  supervisor ! Count()

  Thread.sleep(5000)

  supervisor ! PoisonPill

  _system.shutdown()
  _system.awaitTermination()
}