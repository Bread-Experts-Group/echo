package bread_experts_group

import java.net.DatagramPacket
import java.net.DatagramSocket

fun main(args: Array<String>) {
	val udp = DatagramSocket((args.getOrNull(0) ?: "3001").toInt())
	println("UDP Socket Addr : ${udp.localAddress} : ${udp.localPort}")
	println("listening ...")
	while (true) {
		val packet = DatagramPacket(ByteArray(65535), 65535)
		udp.receive(packet)
		println("RX UDP : ${packet.address} : ${packet.port} ; [${packet.length}]")
		udp.send(packet)
		println("TX UDP : ${packet.address} : ${packet.port} ; [${packet.length}]")
	}
}