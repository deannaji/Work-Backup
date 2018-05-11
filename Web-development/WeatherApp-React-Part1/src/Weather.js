import React from 'react';
import WeatherForm from './WeatherForm';

class Weather extends React.Component{
    state ={
      temp: undefined,
      humidity: undefined,
      description: undefined,
      city: undefined,
      country: undefined,
      error: undefined
    }

  getData = async(e)=>{
    e.preventDefault();
    const city = e.target.elements.city.value;
    const country= e.target.elements.country.value;
    const API_Call = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=${city},${country}&units=imperial&appid=8603ed1f00a932b693d0fbabc5656144`)  
    const response = await API_Call.json();
    if(city && country){
      this.setState({
         temp: response.main.temp,
         humidity: response.main.humidity,
         description: response.weather[0].description,
         city: response.name,
         country: response.sys.country,
         error: ""        
      });
    }else{
      this.setState({
        temp: undefined,
        humidity: undefined,
        description: undefined,
        city: undefined,
        country: undefined,
        error: "*Please enter values for City and Country."
      });
    }
      //console.log(response);
  }
    
  render(){
    return (<div>
       <WeatherForm getData={this.getData}/>
       {this.state.city && this.state.country && <h3>Weather of {this.state.city}, {this.state.country}:</h3>}
       {this.state.temp && <p>Temprature: {this.state.temp} F </p>}
       {this.state.humidity && <p>Humidity: {this.state.humidity} </p>}
       {this.state.description && <p>Conditions: {this.state.description} </p>}
       {this.state.error && <p>{this.state.error}</p>}
       </div>);
  }
}
export default Weather;