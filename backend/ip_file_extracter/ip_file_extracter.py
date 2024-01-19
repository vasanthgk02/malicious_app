import os
import re

extracted_ip = []

def extractIPFromFile(file_path):
    pattern_ipv4 = r'\b\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}\b'
    pattern_ipv6 = r'\b(?:[A-Fa-f0-9]{1,4}:){7}[A-Fa-f0-9]{1,4}\b'
    try:
        subject = open(file_path, "r").read()

        # Find all IPV4 patterns
        ipv4_addresses = re.findall(pattern_ipv4, subject)
        for address in ipv4_addresses:
            extracted_ip.append(address)

        # Find all IPV6 patterns
        ipv6_addresses = re.findall(pattern_ipv6, subject)
        for address in ipv6_addresses:
            extracted_ip.append(address)
            
        with open('backend/output/extracted_ip.txt', 'w') as output:
            for out in extracted_ip:
                print(out, file=output)
            output.close()
    except:
        print("[ERROR]", file_path, " cannot be opened")


def print_files_in_folder(folder_path):
    for root, dirs, files in os.walk(folder_path):
        for file in files:
            file_path = os.path.join(root, file)
            extractIPFromFile(file_path)

# Replace 'your/backend/folder/path' with the actual path to your backend folder
folder_path = 'backend/iptest/'
print_files_in_folder(folder_path)