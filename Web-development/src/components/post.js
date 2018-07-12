import React, { Component } from 'react';
import { connect } from 'react-redux';
import { fetchPosts } from '../actions/postActions';

class post extends Component{
    /*constructor(props){
      super(props);
      this.state={};
    }*/

    componentWillMount(){
      console.log("Component Mounted Successfully!");
      this.props.fetchPosts();
      /*const data = [
         {id:1, title:"post1", body:"test post #1"},
         {id: 2, title: "post2", body: "test post #2"},
         {id: 3, title: "post3", body: "test post #3"}
      ];
      this.setState({posts: data});*/
    }
    render(){
      const postItems = this.state.posts.map(post => (
        <div key={post.id}>
          <h3>{post.title}</h3>
          <p>{post.body}</p>
        </div>
      ));
      return (
        <div>
           <h1>Posts:</h1>
           {postItems}
        </div>
      );
    }
}

const mapStateToProps = state => ({
  posts: state.posts
});

export default connect(mapStateToProps, { fetchPosts })(post);
