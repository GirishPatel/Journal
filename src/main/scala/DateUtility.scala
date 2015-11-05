
import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

/**
 * Created by girish.patel on 05/11/15.
 */
object DateUtility {
  val dateFormat = new SimpleDateFormat("yyyy-MM-dd")
  val dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
  val timeFormat = new SimpleDateFormat("HH:mm:ss")

  def toDateString(date: Date): String = dateFormat.format(date)
  def toDateTimeString(date: Date): String = dateTimeFormat.format(date)
  def toTimeString(date: Date): String = timeFormat.format(date)

  def toDate(dateString: String): Date = dateFormat.parse(dateString)
  def toDateTime(dateString: String): Date = dateTimeFormat.parse(dateString)
  def toTime(dateString: String): Date = timeFormat.parse(dateString)

  def prependDate(msg:String) = DateUtility.toDateTimeString(new Date) + "\t" + msg

  def getStartOfDay: Date = toDate(toDateString(new Date))

}
