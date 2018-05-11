import React from 'react';
import {NavLink} from "react-router-dom";

const Navbar = () =>
  (
    <div className="MenuBar">
      {/* You can use this for a navbar, but you also can use NavLink below:
      <nav>
        <a href="/">Home</a>
        <a href="/contacts">Contacts</a>
        <a href="/about">About</a>
      </nav>*/}
      <div className="NavBar">
        <NavLink className="NavBar__NavLink" to="/" exact>Home</NavLink>
        <NavLink className="NavBar__NavLink" to="/contacts">Contacts</NavLink>
        <NavLink className="NavBar__NavLink" to="/about">About</NavLink>
      </div>   
    </div>
  );

export default Navbar;    