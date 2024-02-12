import React, { useState } from "react";
import logo from "./logo.svg";
import "./App.css";

function App() {
  const [fileName, setFileName] = useState("");
  const handleFileChange = (event) => {
    const file = event.target.files[0];
    setFileName(file);
  };

  return (
    <>
      <h1>Upload your file here</h1>
      <div id="upload-form">
        <label for="file-input">Choose Files</label>
        <input type="file" id="file-input" onClick={handleFileChange} />
      </div>
      <ul id="file-list">{fileName}</ul>
    </>
  );
}

export default App;
