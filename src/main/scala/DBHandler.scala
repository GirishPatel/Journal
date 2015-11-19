import java.io.FileWriter

/**
 * Created by girish.patel on 05/11/15.
 */
object DBHandler {

  val fileName = "/Users/girish.patel/journal_history"

  // todo: open and closing for file is in same function. Should be independent.
  def addLine(msg:String) {
    val fw = new FileWriter(fileName, true)
    fw.write(msg)
    fw.flush()
    fw.close()
  }

  def loadFile:List[Message] = {
    val lines = scala.io.Source.fromFile(fileName).getLines
    val startOfDay = DateUtility.getStartOfDay.getTime
    lines
      .filter(_.trim.nonEmpty)
      .map(line => {
        line.split("\t") match { case Array(t,m) => Message(DateUtility.toDateTime(t),m) }
      })
      .filter(msg => {
        msg.timeStamp.getTime > startOfDay
      })
      .toList
  }

  def getMessages:String = {
    loadFile
      .map(msg => DateUtility.toTimeString(msg.timeStamp) + "\t" + msg.message)
      .mkString("\n") + "\n"
  }
}
