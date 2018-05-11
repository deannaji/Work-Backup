import React from 'react';
import { render } from 'react-dom';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import Home from './Components/Home';
import Contacts from './Components/Contacts';
import About from './Components/About';
import Error from './Components/Error';
import Navbar from './Components/Navbar';


class App extends React.Component{
  render(){
    return (
       <BrowserRouter>
          <div>
             <Navbar /> 
             <Switch>
                 <Route exact path="/" component={Home} />
                 <Route path="/contacts" component={Contacts} />
                 <Route path="/about" component={About} />
                 <Route component={Error} />
             </Switch>
          </div>
       </BrowserRouter>
    )
  }
}

export default App;