import React, { Component } from 'react';

class postForm extends Component{
  constructor(props){
    super(props);
    this.state={
      title:'',
      body:''
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onChange(e){
    this.setState({[e.target.name]: e.target.value});
  }

  onSubmit(e){
    e.preventDefault();
    const post ={
      title: this.state.title,
      body: this.state.body
    }
    console.log(post);
  }


  render(){
    return(
      <div>
        <form onSubmit={this.onSubmit}>
           <input name="title" type="text" value={this.state.title} placeholder="Title" onChange={this.onChange}/>
           <br/><br/>
           <textarea name="body" value={this.state.body} placeholder="Post Body" onChange={this.onChange}/>
           <br/><br/>
           <input type="submit" value="Submit Post"/>
        </form>
      </div>
    );
  }
}
export default postForm;