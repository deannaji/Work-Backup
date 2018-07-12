import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import { createStore } from 'redux';
import { Provider } from 'react-redux';

const initialState ={
  count:0
};

const rootReducer = (state=initialState, action) =>{
  switch(action.type){
    case 'INCREMENT':
      return Object.assign({}, state, {count: state.count+1});
    case 'RESET':
      return Object.assign({}, state, {count:0});
    default:
      return state;
  }
};

const store = createStore(rootReducer);

ReactDOM.render(<Provider store={store}><App /></Provider>, document.getElementById('root'));
registerServiceWorker();
