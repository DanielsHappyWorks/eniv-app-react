import React, { Component } from 'react';
import './header.scss';
import { Link } from 'react-router-dom';


class SuperCoolComponent extends Component {

  componentDidMount() {
  }

  render() {
    return (
      <header className="navbar">
          <nav>
            <div className="logo">
              <div>Company Logo</div>
            </div>
            <ul>
              <li><Link to="/">Dashboard</Link></li>
              <li><Link to="/projects">Projects</Link></li>
              <li><Link to="/admin">Admin</Link></li>
              <li><Link to="/drawings">Drawings</Link></li>
              <li><Link to="/assets">Asset Register</Link></li>
            </ul>
          </nav>
      </header>
    )
  }
}

export default SuperCoolComponent;