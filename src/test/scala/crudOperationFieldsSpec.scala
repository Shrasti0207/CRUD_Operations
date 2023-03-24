import org.scalatest.funsuite.AnyFunSuite
class crudOperationFieldsSpec extends AnyFunSuite{
  val listCRUD = new ListCRUD[String]()
  //test for listCRUD
  listCRUD.create("apple")
  listCRUD.create("banana")
  listCRUD.create("cherry")

  test("read the elements of the list"){
    assert(listCRUD.read() == List("cherry", "banana", "apple"))
  }

  test("Test for update the list"){
  listCRUD.update("banana", "kiwi")
  assert(listCRUD.read() == List("cherry", "kiwi", "apple"))
  }

  test("Test for delete the element from the list"){
    listCRUD.delete("apple")
    assert(listCRUD.read() == List("cherry", "kiwi"))
  }

  // test for sequenceCRUD
  val seqCRUD = new SeqCRUD[Int]()
  seqCRUD.create(10)
  seqCRUD.create(20)
  seqCRUD.create(30)

  test("read the elements of the sequence") {
    assert(seqCRUD.read() == List(10, 20, 30))
  }

  test("Test for update the Sequence") {
    seqCRUD.update(30, 50)
    assert(seqCRUD.read() == List(10, 20, 50))
  }

  test("Test for delete the element from the sequence") {
    seqCRUD.delete(20)
    assert(seqCRUD.read() == List(10, 50))
  }

}
