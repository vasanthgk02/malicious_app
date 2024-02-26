from os import system as sys
import os, time
import xml.etree.ElementTree as ET
import csv
import shutil

def Extract():
    DIRTYPE=["./apk_uploads/"]
    permCollection = set()

    for datastoredir in DIRTYPE:
        Flag=1
        TimeStamp = str(time.time())
        Jdax = "./file_permission/Modules/jadx/bin/jadx"            # JADX MODULE PATH
        TargetApkPath = datastoredir
        ApkNameList = os.listdir(datastoredir)
        if len(ApkNameList) == int(0):
            Flag=0

        if Flag != int(0):
            ApkNameList.sort()
            TargetApkPath = datastoredir+"/"
            CurrentApk = 0

            for ApkName in ApkNameList:
                TargetApk = TargetApkPath + ApkName

                sys(Jdax + " -d output/UnpackedApk/" + ApkName + TimeStamp + " " + TargetApk+ " >/dev/null" )        # USE JADX TO EXTRACT FILES FROM APK AND MAINFEST.XML
                UnpackedDir = "output/UnpackedApk/" + ApkName + TimeStamp
                MainfestPath = UnpackedDir + "/resources/AndroidManifest.xml"
                try:
                    root = ET.parse(MainfestPath).getroot()
                    permissions = root.findall("uses-permission")

                    print("  SET STATUS :", end=' ')        # ADD NEW PERMISSION TO THE LIST
                    for perm in permissions:
                        for att in perm.attrib:
                            permelement = perm.attrib[att]

                            if permelement in permCollection:
                                print("0", end=' ')
                            else:
                                print("1", end=' ')
                                permCollection.add(permelement)

                except FileNotFoundError:
                    print('Error')
                    print(TargetApk)
                    pass
                # sys("rm -f -R " + UnpackedDir)
                print()
                CurrentApk += 1


    permList = list(permCollection)
    return permList

    # with open("backend/output/" + ApkName + "_permission.txt", 'w') as output:
    #     for out in permList:
    #         print(out, file=output)
    #     output.close()
    

# Extract()