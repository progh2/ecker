import serial
import ssl
import socket
import httplib

port = "/dev/ttyACM0"
serialFromArduino = serial.Serial(port, 9600)
serialFromArduino.flushInput()
c = httplib.HTTPSConnection("api.thingspeak.com")

while True:
	if(serialFromArduino.inWaiting() > 0):
		input = serialFromArduino.readline()
		datas = input.split("/")
		if(len(datas)!=4):
			continue;
		field1 = datas[0].split(":")
		field2 = datas[1].split(":")
		field3 = datas[2].split(":")
		print(field1[1] + " / " + field2[1] + " / " + field3[1] );		
		print("https://api.thingspeak.com/update?key=JXA31JEHX2XDU762&field1=" + field1[1] + "&field2=" + field2[1] + "&field3=" + field3[1] )
		c.request("GET", "/update?key=JXA31JEHX2XDU762&field1=" + field1[1] + "&field2=" + field2[1] + "&field3=" + field3[1] )
		response = c.getresponse()
		print response.status, response.reason
		data = response.read()
		print(data)
		print(input)
