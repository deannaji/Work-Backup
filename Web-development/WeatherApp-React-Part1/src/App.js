import React from 'react';
import { render } from 'react-dom';
import Weather from './Weather';

class App extends React.Component{
  constructor(){
    super();
  }
  render(){
    return(
      <div className="app">
        <h1>Welcome to the Weather App!</h1>
        <Weather />
      </div>
    );
  }
}

export default App;