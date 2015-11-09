import javax.imageio.ImageIO
import java.io.File
import javax.swing.ImageIcon

import scala.swing._
import scala.swing.event._

/**
 * Created by girish.patel on 05/11/15.
 */
class UI extends MainFrame {

  private def restrictHeight(s: Component) {
    s.maximumSize = new Dimension(Short.MaxValue, s.preferredSize.height)
  }

  val icon = new ImageIcon(getClass.getClassLoader.getResource("notebook.png"))
  this.iconImage = icon.getImage

  title = "Journal"
  val logJournalField = new TextField { columns = 32 }
  val logJournalLine = new BoxPanel(Orientation.Horizontal) {
    contents += logJournalField
    contents += Swing.HStrut(20)
  }
  val resultField = new TextArea {
    rows = 10
    lineWrap = true
    wordWrap = true
    editable = false
  }

  // make sure that resizing only changes the resultField:
  restrictHeight(logJournalLine)

  contents = new BoxPanel(Orientation.Vertical) {
    contents += new ScrollPane(resultField)
    contents += logJournalLine
    contents += Swing.VStrut(10)
    border = Swing.EmptyBorder(10, 10, 10, 10)
  }

  resultField.text = DBHandler.getMessages
  listenTo(logJournalField)

  reactions += {
    case EditDone(`logJournalField`) => logJournalNow
  }

  def logJournalNow {
    val msg = logJournalField.text
    if (msg.nonEmpty) {
      val line = DateUtility.prependDate(msg + "\n")
      DBHandler.addLine(line)
      resultField.text = line.replaceAll(raw"^\d\d\d\d-\d\d-\d\d ","") + resultField.text
      resultField.caret.position = 0
      logJournalField.text = ""
    }
  }
}
