import { put, takeLatest, call } from 'redux-saga/effects'
import { INCREMENT, RESET } from '../actions/counter-actions';

//Generators(Sagas):
//------------------
export function* createResetEvent(){
  yield put({type: RESET});
  console.log('Increasing is not allowed! Reseting Counter...');
}

export function* msgBroadcast(){
  yield call(printEvent1);
}

export function* callGetUser(){
  yield call(getUser);
  console.log('Counter Reseting... Returning a user obj..');
}

//Actions Watcher Saga:
export default function* incrementEventWatcher(){
  yield takeLatest(INCREMENT, msgBroadcast);
  yield takeLatest(RESET, callGetUser);
}


//Regular functions:
//-------------------
function printEvent1(){
  console.log('Counter increased...');
}


function getUser(){
  fetch('https://jsonplaceholder.typicode.com/posts/1')
  .then(response => response.json())
  .then(json => console.log(json))
}
