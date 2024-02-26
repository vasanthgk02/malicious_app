import socket
d = []

def domaintoip(file):
	with open(file) as t:
		for Hostname in t:	
			Hostname = Hostname.rstrip()
			try:
				s = socket.gethostbyname(Hostname)
				d.append(s)
			except:
				print(Hostname, 'Not Valid')
				continue

	with open('backend/output/ip_to_domain.txt', 'w') as output:
		for out in d:
			print(out, file=output)
		output.close()

f = "backend/iptest/ip.txt"
# f = "backend/output/extracted_ip.txt"
domaintoip(f)