import React, { Component } from 'react';
import './App.css';
import Products from './Components/Products.js';

class App extends Component {
  constructor(){
    super();
    this.setState({
       products:["Laptop","Desktop","Cables","Routers"]
    });
  }
  render(){
    return(
       <div className="App">
          Your Inventory:
          <Products products={this.state.products}/>
       </div>
    );
  }
}

export default App;