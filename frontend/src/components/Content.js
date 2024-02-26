import React, { useState, useEffect } from "react";
import "bootstrap/dist/css/bootstrap.css";
import Header from "./Header";
import "./Style.css";

function redirectToNewPage() {
  window.location.href = "./Details.html"
}

function Content() {
  const [selectedFile, setSelectedFile] = useState(null);
  const [successMessage, setSuccessMessage] = useState("");
  const [failureMessage, setfailureMessage] = useState("");
  const [permissions, setPermission] = useState("");

  const handleFileChange = (event) => {
    setSelectedFile(event.target.files[0]);
  };

  const handleUpload = () => {
    const formData = new FormData();
    formData.append("file", selectedFile);
    console.log(selectedFile);
    fetch("http://localhost:5001/apkUpload", {
      method: "POST",
      body: formData,
    })
      .then((response) => {
        if (response) {
          setSuccessMessage("File uploaded successfully");
        } else {
          setfailureMessage("Failed to upload file");
        }
      })
      .catch((error) => {
        console.error("Error uploading file:", error);
      });
  };
  const getPermission = async () => {
    await fetch("http://localhost:5001/analyse", {
      method: "GET",
    })
      .then((response) => {
        // console.log(response.text())
        setPermission(response.text());
      })
      .catch((error) => {
        console.log(error);
      });
  };
  
  // document.getElementById('analyseButton').addEventListener('click', redirectToNewPage);
  

  return (
    <>
      <Header />
      
      <div class="container">
        <div class="row">
          <div class="col-md-6 offset-md-3">
            
            <>
              <div id="upload-form" class="dottedoutline">
                <form method="post">
                  <label for="file-input">Choose Files</label>
                  <input
                    type="file"
                    id="file-input"
                    onClick={handleFileChange}
                  />
                  <br />
                  <div class="buttonspacing">
                    <button
                      class="btn btn-outline-secondary "
                      onClick={handleUpload}
                      type="button"
                      id="inputGroupFileAddon03"
                    >
                      Upload
                    </button>
                  </div>
                </form>
              </div>
              <h1 class="h1tag">Upload APK File</h1>
            </>
            {successMessage && (
              <div class="d-grid gap-2">
                <button
                  class="btn btn-primary"
                  onClick={getPermission}
                  type="button"
                  id="analyseButton"
                >
                  Analyse
                </button>
              </div>
            )}
          </div>
          {permissions && (
            <div>
              <p>{permissions}</p>
            </div>
          )}
        </div>
      </div>
      {successMessage && (
              <div 
                class="alert alert-success d-flex align-items-center msg"
                role="alert"
              >
                {successMessage}
              </div>
            )}
            {failureMessage && (
              <div 
                class="alert alert-danger d-flex align-items-center msg"
                role="alert"
              >
                {failureMessage}
              </div>
            )}
    </>
  );
}


export default Content;
