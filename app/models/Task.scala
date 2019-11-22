package models

/**
  * LBCD-NOTE: Simple POJO to model immutable data. https://docs.scala-lang.org/tour/case-classes.html
  * @param id
  * @param label
  */
case class Task(id: Long, label: String)

/**
  * LBCD-NOTE:  Companion singleton object that holds static variables and methods
  * https://docs.scala-lang.org/tour/singleton-objects.html
  */
object Task {

  /**
    * Static collection to act as in-memory DB. Feel free to override this to use any data structure you like
    */
  val tasks = collection.mutable.Map[Long, String]()

  /**
    * Method to return the list of tasks that the user has added till now.
    * @return
    */
  def all(): List[Task] = tasks.toList.map(tuple =>Task(tuple._1, tuple._2))

  /**
    * Method to create a task and add it to the existing tasks
    * LBCD-NOTE: Unit is equivalent to java void.
    * @param label
    */
  def create(label: String): Unit = {
    tasks(tasks.size + 1) = label
  }

  /**
    * Method to update a label of task with given id
    * @param id
    * @param label
    */
  def update(id: Long, label: String): Unit = {
    tasks(id) = label
  }

}
