import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import { createStore, applyMiddleware, combineReducers } from 'redux';
import { Provider } from 'react-redux';
import CounterReducer from './reducers/counterReducer';
import createSagaMiddleware from 'redux-saga';
import { helloSaga } from './saga/testSaga';
import incrementEventWatcher from './saga/eventWatcherSaga';

const initialState ={
  count: 0
};

const sagaMiddleware = createSagaMiddleware();

const store = createStore(CounterReducer, initialState, applyMiddleware(sagaMiddleware), window.devToolsExtension && window.devToolsExtension());

//sagaMiddleware.run(helloSaga);
sagaMiddleware.run(incrementEventWatcher);

ReactDOM.render(<Provider store={store}><App /></Provider>, document.getElementById('root'));
registerServiceWorker();
