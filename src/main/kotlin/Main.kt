package bread_experts_group

import java.net.ServerSocket
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
fun main(args: Array<String>) {
	val tcp = ServerSocket((args.getOrNull(0) ?: "3002").toInt())
	println("TCP Socket Addr : ${tcp.localSocketAddress}")
	println("listening ...")
	while (true) {
		val socket = tcp.accept()
		Thread {
			val buffer = ByteArray(64000)
			val rand = Uuid.random()
			println("CONN TCP : ${socket.localSocketAddress}, ${socket.remoteSocketAddress} ($rand)")
			val read = socket.inputStream.read(buffer)
			println("RX   TCP : $rand ; [${read}]")
			val write = buffer.sliceArray(0..(read - 1))
			socket.outputStream.write(write)
			println("TX   TCP : $rand ; [${write.size}]")
		}.start()
	}
}