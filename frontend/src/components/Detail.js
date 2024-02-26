import React from "react";
import { useState } from "react";
import Header from "./Header";
import "bootstrap/dist/css/bootstrap.css";
import "./Style.css"
import response from '../response.js'

function Detail(){
    var resp = response
    const [permissions, setPermission] = useState("");

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

    return(
        <>
        <body class="bgcolor">
        <Header/>
        <nav class="appdesc offset-md-4">
        <div class="row">
  <div class="col-sm-4">
            <img src="" alt="image"></img>
            </div><div class="col-sm-2">
            <h1>name</h1>
            </div>
            </div>
        </nav>
        <button
                  class="btn btn-primary"
                  onClick={getPermission}
                  type="button"
                  id="analyseButton"
                ></button>
<div class="row">
  <div class="col-sm-6 mb-3 mb-sm-0">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">File in App</h5>
        <p class="card-text"><ul>
        {
          resp.file.map((data)=>{
            return(<li class="card-text"> {data}</li>);
          })
        }
        </ul></p>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">permissions</h5>
        <ul>
        {
          resp.permissions.map((data)=>{
            return(<li class="card-text"> {data}</li>);
          })
        }
        </ul>
      </div>
    </div>
  </div>
</div>
</body>
        </>
    )
}

export default Detail