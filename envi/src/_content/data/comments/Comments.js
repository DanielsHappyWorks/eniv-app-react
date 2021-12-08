import React, { Component } from 'react';
import './comments.scss';

class CommentsComponent extends Component {
  constructor(props) {
    super(props);
  }

  componentDidMount() {
  }

  render() {
    console.log(this.props);
      return (
        <div>
          <h3>Comments</h3>
          {this.props.comments.map(c => {     
           return (<div><h4>{c.name}</h4><p>{c.comment}</p></div>)
          })}
        </div>
      )
  }
}

export default CommentsComponent;