import React, { Component } from 'react';
import { connect } from 'react-redux';
import { increment, decrement, reset } from '../actions/counter-actions';

class Counter extends Component{
  constructor(props){
    super(props)
    this.onIncrementClick = this.onIncrementClick.bind(this);
    this.onDecrementClick = this.onDecrementClick.bind(this);
    this.onResetClick = this.onResetClick.bind(this);
  }

  onIncrementClick(){
    this.props.onIncrementClick();
  }

  onDecrementClick(){
    this.props.onDecrementClick();
  }

  onResetClick(){
    this.props.onResetClick();
  }

  render(){
    return(
      <div className="counter-container">
         <h2>Counter: {this.props.count}</h2>
         <p>
           <button onClick={this.onIncrementClick}>Increment</button>
           <button onClick={this.onDecrementClick}>Decrement</button>
           <button onClick={this.onResetClick}>Reset</button>
         </p>
      </div>
    );
  }
}

function mapStateToProps(state){
  return{
    count: state.count
  }
}

const mapActionsToProps ={
  onIncrementClick: increment,
  onDecrementClick: decrement,
  onResetClick: reset
}


export default connect(mapStateToProps, mapActionsToProps)(Counter);
