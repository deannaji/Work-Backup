import { FETCH_POSTS, NEW_POST } from './types'

const data = [
   {id:1, title:"post1", body:"test post #1"},
   {id: 2, title: "post2", body: "test post #2"},
   {id: 3, title: "post3", body: "test post #3"}
];

export const fetchPosts = () => dispatch => {
  fetch('https://jsonplaceholder.typicode.com/posts')
    .then(res => res.json())
    .then(posts =>
      dispatch({
        type: FETCH_POSTS,
        payload: posts
      })
    );
};
