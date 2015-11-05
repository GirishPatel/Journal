import java.io.FileWriter

/**
 * Created by girish.patel on 05/11/15.
 */
object DBHandler {

  val fileName = "/Users/girish.patel/journal_history"
  val fw = new FileWriter(fileName, true)

  def addLine(msg:String) {
    fw.write(msg)
    fw.flush()
  }

  def loadFile:List[Message] = {
    val lines = scala.io.Source.fromFile(fileName).getLines
    val startOfDay = DateUtility.getStartOfDay.getTime
    lines
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
