import React from 'react';
import { connect } from 'react-redux';

function counterScreen(props){
  return(
    <div className="screen-container">
      <h1>Test Screen!</h1>
      <h1>The counter is now:  {props.count}</h1>
    </div>
  );
}

function mapStateToProps(state){
  return {
    count: state.count
  }
}

export default connect(mapStateToProps)(counterScreen);
