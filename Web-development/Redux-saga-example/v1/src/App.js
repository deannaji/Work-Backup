import React, { Component } from 'react';
import './App.css';
import Counter from './components/counter';
import Screen from './components/counter-screen';

class App extends Component {
  render() {
    return (
        <div className="App">
           <Counter count="0"/>
           <br/><br/><br/><br/>
           <Screen count="0"/>
        </div>
    );
  }
}

export default App;
