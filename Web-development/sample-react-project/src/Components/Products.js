import React, { Component } from 'react';

class Products extends Component{
   render(){
      return(
        <div class="itemsBox">
           {
             this.props.products.map(product =>{
                return (<li>{product}</li>);
             })
           }
        </div>
      )
   }
}

export default Products;