package com.masil.clocks

import java.time.LocalDateTime

interface Clock {

  fun getNow() : LocalDateTime
}
