import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import { connect } from 'react-redux';
import { updateUser } from './actions/user-action';

class App extends Component {
  constructor(props){
    super(props);
    this.onUpdateUserVar = this.onUpdateUser.bind(this);
  }

  onUpdateUser(e){
    this.props.onUpdateUser(e.target.value);
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
         <label>Username: </label>
         <input onChange={this.onUpdateUserVar}/>
         <p>{this.props.user}</p>
      </div>
    );
  }
}

const mapStateToProps = state =>({
  products: state.products,
  user: state.user
});

const mapActionsToProps = {
  onUpdateUser: updateUser
};

export default connect(mapStateToProps, mapActionsToProps)(App);
