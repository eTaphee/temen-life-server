package life.temen

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TemenLifeServerApplication

fun main(args: Array<String>) {
    runApplication<TemenLifeServerApplication>(*args)
}
