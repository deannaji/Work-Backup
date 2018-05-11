import React from 'react';
import Weather from './Weather'

/*class WeatherForm extends React.Component{
  render(){
    return(<div> 
      <form className="form1" onSubmit={this.props.getData}>
         <input name="city" type="text" placeholder="City" />
         <input name="country" type="text" placeholder="Country" />
         <br />
         <input type="submit" value="Submit" />
      </form>
      </div>);
  }
}*/

/**
 * Since the is no state in the class above, then there is no need for a class at all.
 * The Component below is called "Statless Componenet".
 * Its a constant equals to a function with a return statement.
 */
const WeatherForm = function(props){
  return(
    <div>
      <form className="form1" onSubmit={props.getData}>
        <input name="city" type="text" placeholder="City" />
        <input name="country" type="text" placeholder="Country" />
        <br />
        <input type="submit" value="Submit" />
      </form>
    </div>
  );
}

/*Or you can use the shorter arrow function annotation below: */
/*const WeatherForm = (props) => (
    <div>
      <form className="form1" onSubmit={props.getData}>
        <input name="city" type="text" placeholder="City" />
        <input name="country" type="text" placeholder="Country" />
        <br />
        <input type="submit" value="Submit" />
      </form>
    </div>
  );*/

export default WeatherForm;