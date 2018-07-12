import { INCREMENT, DECREMENT, RESET } from '../actions/counter-actions';


const counterReducer = (state={count:0}, action) =>{
  switch(action.type){
    case INCREMENT:
      return Object.assign({}, state, increment(state));
    case DECREMENT:
      return Object.assign({}, state, decrement(state));
    case RESET:
      return Object.assign({}, state, reset(state));
    default:
      return state;
  }
};

function increment(state){
  return {count: state.count+1};
}

function decrement(state){
  if(state.count > 0)
    return {count: state.count-1};
  else
    reset(state);
}

function reset(state){
  return {count:0};
}

export default counterReducer;
