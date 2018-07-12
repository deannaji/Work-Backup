export const INCREMENT ='increment';
export const DECREMENT ='decrement';
export const RESET ='reset';

export function increment(newCount){
  return{
    type: INCREMENT,
    payload:{
      count: newCount
    }
  };
}

export function decrement(newCount){
  return{
    type: DECREMENT,
    payload:{
      count: newCount
    }
  };
}

export function reset(newCount){
  return{
    type:RESET,
    payload:{
      count : newCount
    }
  };
}
