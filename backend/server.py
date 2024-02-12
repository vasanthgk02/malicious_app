import os
from os import system as sys
from flask import Flask, redirect, url_for, request, jsonify, send_file
from file_permission.file_permission_extractor import Extract
from flask_cors import CORS
import json

app = Flask(__name__)
CORS(app)

def removeExistingFiles():
	files = os.listdir(UPLOAD_FOLDER)
	for file in files:
		file_path = os.path.join(UPLOAD_FOLDER, file)
		if os.path.isfile(file_path):
			os.remove(file_path)

def collectFileName():
	files = os.listdir("./backend/")
	for file in files:
		file_path = os.path.join(UPLOAD_FOLDER, file)
		if os.path.isfile(file_path):
			os.remove(file_path)

def getFileName():
	li = []
	for root, dirs, files in os.walk("/Users/vasanthgk02/Desktop/college_project/backend/output"):
		for file in files:
			file_path = os.path.join(root, file)
			st = "" + file_path
			li.append(st)
	return li

UPLOAD_FOLDER = '/Users/vasanthgk02/Desktop/college_project/backend/apk_uploads'

@app.route('/')
def serverUp():
	return 'Server is up and running on port 5001'

@app.route('/apkUpload', methods = ["POST"])
def apkUpload():
	if request.method == "POST":
		if 'file' not in request.files:
			return 'No file part'	
		file = request.files['file']
		if file.filename == '':
			return 'No selected file'
		removeExistingFiles()
		file.save(os.path.join(UPLOAD_FOLDER,file.filename))
		respone = {"status_code": 200, "file_name": file.filename, "message": "'File uploaded successfully."}
		return respone

@app.route("/analyse", methods = ["GET"])
def file_permission():
	if request.method == "GET":
		sys("rm -rf /Users/vasanthgk02/Desktop/college_project/backend/output")
		ans = Extract()
		file = getFileName()
		sys("cd /Users/vasanthgk02/Desktop/college_project/backend/output && tar -cf UnpackedApk.tar UnpackedApk")
		sys("cd apkcli && apkcli json ../apk_uploads/* > ../result.json")
		metadata = ""
		with open("result.json") as f:
			metadata = json.load(f)
		return  {"status_code": 200, "permissions": ans, "file" : file, "metadata": metadata}

@app.route("/download")
def downloadApk():
	return send_file("/Users/vasanthgk02/Desktop/college_project/backend/output/UnpackedApk.tar", as_attachment=True)

# main driver function
if __name__ == '__main__':
	app.run(debug=True, host="localhost", port=5001)


