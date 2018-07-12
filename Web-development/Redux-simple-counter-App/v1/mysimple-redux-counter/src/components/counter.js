import React from 'react';
import { connect } from 'react-redux';

function Counter (props){
    return(
      <div className="counter-container">
         <h2>Counter: {props.count}</h2>
         <p>
           <button onClick={props.onIncrementClick}>Increment</button>
           <button onClick={props.onResetClick}>Reset</button>
         </p>
      </div>
    );
}

function mapStateToProps(state){
  return{
    count: state.count
  }
}

function mapDispatchToProps(dispatch){
  return {
    onIncrementClick: ()=>{
       const action = {type: 'INCREMENT'};
       dispatch(action);
    },
    onResetClick: ()=>{
      const action = {type: 'RESET'};
      dispatch(action);
    }

  }
}

export default connect(mapStateToProps, mapDispatchToProps)(Counter);
