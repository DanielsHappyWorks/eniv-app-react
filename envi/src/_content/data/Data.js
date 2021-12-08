import React, { Component } from 'react';
import './data.scss';
import Loader from '../loader/Loader'
import { useParams } from 'react-router-dom'
import Comments from './comments/Comments'
import Map from './map/Map'


function DataWithId(props) {
  let id = useParams();
  return <DataComponent {...props} id={id.id} />
}

class DataComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: []
    };
  }

  componentDidMount() {
    console.log(this.props.id);
    var api = (process.env.REACT_APP_API_URL ? process.env.REACT_APP_API_URL : "http://localhost:3000");
    if (this.props.id == undefined) {
      this.setState({
        isLoaded: false,
        error: {
          message: "No Identifier Defined"
        }
      });
    }
    fetch(api + "/" + this.props.id)
      .then(res => res.json())
      .then(
        (result) => {
          this.setState({
            isLoaded: true,
            item: result
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
    const { error, isLoaded, item } = this.state;
    if (error) {
      return (
        <main>
          <h1>Error</h1>
          <p>{error.message}</p>
        </main>
      )
    } else if (!isLoaded) {
      return (
        <main>
          <Loader />
        </main>
      )
    } else {
      console.log(item);
      let comments = "";
      if(item.commentsList != undefined && item.commentsList.length != 0) {
        comments = <Comments id={this.props.id} comments={item.commentsList}/>
      }
      
      return (
        <main>
          <h1>{item.name}</h1>
          <h3>Description</h3><p>{item.description}</p>
          <h3>Last Visit</h3><p>{new Date(item.lastDate * 1000).toLocaleString()}</p>
          <h3>Next Visit</h3><p>{new Date(item.nextDate * 1000).toLocaleString()}</p>
          <h3>Author</h3><p>{item.author}</p>
          <h3>Location</h3><p>{item.longitude}, {item.latitude}</p>
          <Map long={item.longitude} lat={item.latitude}/>
          {comments}
        </main>
      )
    }
  }
}

export default DataWithId;