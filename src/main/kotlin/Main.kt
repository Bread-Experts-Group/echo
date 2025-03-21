package bread_experts_group

import java.net.ServerSocket
import java.nio.ByteBuffer

fun main(args: Array<String>) {
	val tcp = ServerSocket((args.getOrNull(0) ?: "3002").toInt())
	println("TCP Socket Addr : ${tcp.localSocketAddress}")
	println("listening ...")
	while (true) {
		val socket = tcp.accept()
		Thread.ofPlatform().start {
			val buffer = ByteBuffer.allocate(65535)
			println("CONN TCP : ${socket.localSocketAddress}, ${socket.remoteSocketAddress}")
			val read = socket.channel.read(buffer)
			println("RX   TCP : ${socket.localSocketAddress}, ${socket.remoteSocketAddress} ; [${read}]")
			buffer.flip()
			val wrote = socket.channel.write(buffer)
			println("TX   TCP : ${socket.localSocketAddress}, ${socket.remoteSocketAddress} ; [${wrote}]")
			buffer.clear()
		}
	}
}