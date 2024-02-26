import React, { useState } from "react";
import logo from "./logo.svg";
import Content from "./components/Content";
import "./App.css";
import "bootstrap/dist/css/bootstrap.css";
import Detail from "./components/Detail";


function App() {
  const [fileName, setFileName] = useState("");
  const handleFileChange = (event) => {
    const file = event.target.files[0];
    setFileName(file);
  };

  return (
    <>
      {/* <Content/> */}
      <Detail/>
    </>
  );
}

export default App;
