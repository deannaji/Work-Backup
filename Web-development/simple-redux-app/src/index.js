import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import { combineReducers, createStore } from 'redux';
import { Provider } from 'react-redux';
import userReducer from './reducers/user-reducer';
import productsReducer from './reducers/products-reducer';
//import updateUserAction from './actions/user-action';

const initialState ={
  products:[],
  user: 'No user selected'
}

const rootReducer = combineReducers({
  products: productsReducer,
  user: userReducer
});

const store = createStore(rootReducer,initialState , window.devToolsExtension && window.devToolsExtension());



//store.dispatch(updateUserAction);

ReactDOM.render(<Provider store={store}><App /></Provider>, document.getElementById('root'));
registerServiceWorker();
