import React, { Component } from 'react';
import './dashboard.scss';
import Loader from '../loader/Loader'

class DashboardComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: []
    };
  }

  componentDidMount() {
    var api = (process.env.REACT_APP_API_URL ? process.env.REACT_APP_API_URL : "http://localhost:3000");
    fetch(api + "/v1/data")
      .then(res => res.json())
      .then(
        (result) => {
          this.setState({
            isLoaded: true,
            items: result.items
          });
        },
        (error) => {
          this.setState({
            isLoaded: true,
            error
          });
        }
      )
  }

  render() {
    const { error, isLoaded, items } = this.state;
    if (error) {
      return (
        <main>
          <h1>Dashboard</h1>
          <p>Error: {error.message}</p>
        </main>
      )
    } else if (!isLoaded) {
      return (
        <main>
          <h1>Dashboard</h1>
          <Loader />
        </main>
      )
    } else {
      return (
        <main>
          <h1>Dashboard</h1>
          <p>Items: {items}</p>
        </main>
      )
    }
  }
}

export default DashboardComponent;