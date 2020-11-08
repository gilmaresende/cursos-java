import React from "react";

import "bootswatch/dist/flatly/bootstrap.min.css";
import "../custom.css";

import Rotas from "./rotas";
import Navbar from "../components/navbar";

class App extends React.Component {
  render() {
    return (
      <div>
        <Navbar></Navbar>
        <div className="container">
          <Rotas />
        </div>
      </div>
    );
  }
}

export default App;