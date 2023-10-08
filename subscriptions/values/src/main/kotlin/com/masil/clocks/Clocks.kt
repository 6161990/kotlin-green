package com.masil.clocks

import java.time.LocalDateTime

abstract class Clocks : Clock{

  companion object {
    val SYSTEM_CLOCK : Clock = SystemClock()
    var INSTANCE = SYSTEM_CLOCK

    fun getInstance() : Clock {
      return INSTANCE
    }

    fun now(): LocalDateTime{
      return getInstance().getNow()
    }

    @Synchronized
    fun freeze(localDateTime: LocalDateTime){
      INSTANCE = FrozenClock(localDateTime)
    }

    @Synchronized
    fun resetToSystem(){
      INSTANCE = SYSTEM_CLOCK
    }
  }

  class SystemClock : Clock{
    override fun getNow(): LocalDateTime {
      return LocalDateTime.now()
    }
  }

  class FrozenClock(
    private val localDateTime: LocalDateTime
  ) : Clock{

    override fun getNow(): LocalDateTime {
      return localDateTime
    }
  }
}
