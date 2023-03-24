abstract class CRUDOperations[T] {
  def create(element: T): Unit
  def read(): Seq[T]
  def update(oldElement: T, newElement: T): Unit
  def delete(element: T): Unit
}

class ListCRUD[T] extends CRUDOperations[T] {
  private var list: List[T] = List.empty           // Initially take  empty list which modify over the operations

  override def create(element: T): Unit = {   // create method is used to create the  list
    list = element :: list
  }

  override def read(): List[T] = {      //read method is used to read the list
    list
  }

  override def update(oldElement: T, newElement: T): Unit = {   // update method is used to update the list
    list = list.map(elem => if (elem == oldElement) newElement else elem)
  }

  override def delete(element: T): Unit = {   // delete method is used to delete the element from the list
    list = list.filterNot(elem => elem == element)
  }
}

class SeqCRUD[T] extends CRUDOperations[T] {
  private var seq: Seq[T] = Seq.empty   // Initially take  empty sequence which modify over the operations

  override def create(element: T): Unit = {   // create method is used to create the  sequence
    seq = seq :+ element
  }

  override def read(): List[T] = {      //read method is used to read the sequence
    seq.toList
  }

  override def update(oldElement: T, newElement: T): Unit = {   // update method is used to update the sequence
    seq = seq.updated(seq.indexOf(oldElement), newElement)
  }

  override def delete(element: T): Unit = {   //delete method is used to delete the element from the sequence
    seq = seq.filterNot(elem => elem == element)
  }
}

