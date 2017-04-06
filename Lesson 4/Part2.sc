class Time (h: Int, m: Int = 0) {

  private var minutesSinceMidnight = h * 60 + m

  def hours = minutesSinceMidnight / 60

  def minutes = minutesSinceMidnight % 60

  if (h<0 || h>23 || m<0 || m>59 ){
    throw new IllegalArgumentException
  }
    def minutes_=(newVal : Int) {
    if (newVal < 0 && newVal > 60)
      minutesSinceMidnight= minutesSinceMidnight/60 + newVal
    else
      throw new IllegalArgumentException
  }

  def before(t: Time) =  minutesSinceMidnight < t.minutesSinceMidnight

  override def toString: String = f"${hours}:${minutes}%02d"
}


val t = new Time(5,33)
val t1 = new Time(5,32)
val t2 = new Time(5,11)


t.before(t1)
t1.before(t2)
t2.before(t)

val t3 = new Time(5)
val t4 = new Time(-55,11)

