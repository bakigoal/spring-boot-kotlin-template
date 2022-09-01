package com.bakigoal.demo.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger

inline fun <reified T : Any> loggerFor(): Logger = getLogger(T::class.java)