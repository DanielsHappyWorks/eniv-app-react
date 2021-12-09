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
           return (<div><p><span style="font-weight:bold;">{c.name}</span> - {new Date(c.time * 1000).toLocaleString()} - {c.comment}</p></div>)
          })}
        </div>
      )
  }
}

export default CommentsComponent;